import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@FunctionalInterface
public interface ConnectionPool extends Supplier<Connection>, AutoCloseable {

    BlockingQueue<PooledConnection> getConnectionQueue();

    @SneakyThrows
    static ConnectionPool create(String pathToConfig) {

        Properties properties = new Properties();
        properties.load(new FileInputStream(pathToConfig));

        Class.forName(getValueAndRemoveKey(properties, "driver"));
        String url = getValueAndRemoveKey(properties, "url");
        int poolSize = Integer.parseInt(getValueAndRemoveKey(properties, "poolSize"));

        BlockingQueue<PooledConnection> connectionQueue = new ArrayBlockingQueue<>(poolSize);

        for (int i = 0; i < poolSize; i++)
            connectionQueue.add(
                    PooledConnection.create(
                            DriverManager.getConnection(url, properties),
                            connectionQueue));

        return () -> connectionQueue;
    }

    @SneakyThrows
    static ConnectionPool create(String pathToConfig, String pathToInitScript) {

        ConnectionPool connectionPool = create(pathToConfig);

        try (Connection connection = connectionPool.get();
             Statement statement = connection.createStatement()) {

            Arrays.stream(
                    Files.lines(Paths.get(pathToInitScript))
                            .collect(Collectors.joining())
                            .split(";"))
                    .forEachOrdered(sql -> {
                        try {
                            statement.addBatch(sql);
                        } catch (SQLException e) {
                            throw new RuntimeException();
                        }
                    });

            statement.executeBatch();
        }

        return connectionPool;
    }

    static String getValueAndRemoveKey(Properties properties, String key) {
        return (String) properties.remove(key);
    }

    @Override
    @SneakyThrows
    default Connection get() {
        return getConnectionQueue().take();
    }

    @Override
    default void close() throws Exception {
        getConnectionQueue().forEach(connection -> {
            try {
                connection.reallyClose();
            } catch (SQLException e) {
                e.printStackTrace();
//                throw new RuntimeException(e);
            }
        });
    }
}