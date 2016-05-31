package repositories.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.derby.jdbc.EmbeddedDataSource;

public class Database implements IDatabase {
    public static String DB_NAME = "tecnicasDB";
    public static String USER_NAME = "app";
    public static String PASSWORD = "app";
    private static IDatabase instance;
    private EmbeddedDataSource dataSource;
    
    private Database(EmbeddedDataSource dataSource) {
    	this.dataSource = dataSource;
    }
    
    public static IDatabase getInstance() {
    	if (instance == null) {
    		EmbeddedDataSource dataSource = new EmbeddedDataSource();
        	
        	dataSource.setDatabaseName(DB_NAME);
        	dataSource.setCreateDatabase("create");
        	dataSource.setUser(USER_NAME);
        	dataSource.setPassword(PASSWORD);
        	
    		instance = new Database(dataSource);
    	}
    	return instance;
    }

	/* (non-Javadoc)
	 * @see repositories.dao.IDatabase#getConnection()
	 */
	@Override
	public Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
}

