import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.function.Supplier;

public class ConnectionPoolTest {

    public static final String PATH_TO_CONFIG = "src/test/resources/db/db.properties";
    public static final String PATH_TO_INIT = "src/test/resources/db/init.sql";
    static Supplier<Connection> connectionPool;

    @BeforeClass
    public static void init() throws SQLException, IOException {
        connectionPool = ConnectionPool.create(PATH_TO_CONFIG, PATH_TO_INIT);
    }

    @Test
    public void get() throws Exception {
        Collection<Contact> contacts;
        try (Connection connection = connectionPool.get();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "SELECT id, first_name, last_name, birth_date FROM Contact")) {
            contacts = new HashSet<>();
            while (resultSet.next())
                contacts.add(
                        new Contact(
                                resultSet.getLong("id"),
                                resultSet.getString("first_name"),
                                resultSet.getString("last_name"),
                                resultSet.getDate("birth_date").toLocalDate()));
        }

        Assert.assertTrue(contacts.contains(
                new Contact(1L, "Chris", "Schaefer", LocalDate.parse("1981-05-03"))
        ));

        System.out.println(contacts);
    }
}