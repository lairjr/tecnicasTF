import infrastructure.Database;
import infrastructure.IDatabase;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * Created by ljunior on 5/31/16.
 */
public class DatabaseTest {
    private IDatabase database;

    @Before
    public void setUp() {
        database = Database.getInstance(null);
    }

    @Test
    public void hasCorrectProperties() {
        assertNotNull(database);
    }
}
