import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ConnectionPoolTest {

    public static final String PATH_TO_CONFIG = "src/test/resources/db/db.properties";
    public static final String PATH_TO_INIT = "src/test/resources/db/init.sql";
    static Supplier<Connection> connectionPool;

    @BeforeClass
    public static void init() throws SQLException, IOException {
        connectionPool = ConnectionPool.create(PATH_TO_CONFIG);
        try (Connection connection = connectionPool.get();
             Statement statement = connection.createStatement()) {

            Arrays.stream(
                    Files.lines(Paths.get(PATH_TO_INIT))
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

    }

    @Test
    public void get() throws Exception {

    }
}