import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.function.Supplier;

@FunctionalInterface
public interface ConnectionPool extends Supplier<Connection>, AutoCloseable {

    BlockingQueue<Connection> getConnectionQueue();

    @SneakyThrows
    static ConnectionPool create() {

        Properties properties = new Properties();
        properties.load(new FileInputStream("src/test/resources/db/db.properties"));

        Class.forName(getValueAndRemoveKey(properties, "driver"));
        String url = getValueAndRemoveKey(properties, "url");
        int poolSize = Integer.parseInt(getValueAndRemoveKey(properties, "poolSize"));

        BlockingQueue<Connection> connectionQueue = new ArrayBlockingQueue<>(poolSize);

        for (int i = 0; i < poolSize; i++)
            connectionQueue.add(
                    new PooledConnection(
                            DriverManager.getConnection(url, properties)));

        return () -> connectionQueue;
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
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
//                throw new RuntimeException(e);
            }
        });
    }
}