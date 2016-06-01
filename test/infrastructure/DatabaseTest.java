import infrastructure.Database;
import infrastructure.IDatabase;
import org.apache.derby.jdbc.EmbeddedDataSourceInterface;
import org.junit.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by ljunior on 5/31/16.
 */
public class DatabaseTest {
    private IDatabase database;
    private EmbeddedDataSourceInterface dataSource;

    @Before
    public void setUp() {
        dataSource = mock(EmbeddedDataSourceInterface.class);
        database = Database.getInstance(dataSource);
    }

    @Test
    public void hasCorrectProperties() {
        verify(dataSource, times(1)).setDatabaseName("tecnicasDB");
        verify(dataSource, times(1)).setCreateDatabase("create");
        verify(dataSource, times(1)).setUser("app");
        verify(dataSource, times(1)).setPassword("app");
    }
}
