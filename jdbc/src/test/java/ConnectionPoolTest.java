import org.junit.Test;

public class ConnectionPoolTest {
    @Test
    public void get() throws Exception {
        ConnectionPool.create("src/test/resources/db/db.properties");
    }
}