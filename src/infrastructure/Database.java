package infrastructure;

import org.apache.derby.jdbc.EmbeddedDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by ljunior on 5/31/16.
 */
public class Database implements IDatabase {
    public static String DB_NAME = "tecnicasDB";
    public static String USER_NAME = "app";
    public static String PASSWORD = "app";
    private static IDatabase instance;
    private EmbeddedDataSource dataSource;

    private Database(EmbeddedDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static IDatabase getInstance(EmbeddedDataSource dataSource) {
        if (instance == null) {
            dataSource.setDatabaseName(DB_NAME);
            dataSource.setCreateDatabase("create");
            dataSource.setUser(USER_NAME);
            dataSource.setPassword(PASSWORD);

            instance = new Database(dataSource);
        }
        return instance;
    }

    @Override
    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
