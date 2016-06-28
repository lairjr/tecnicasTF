package infrastructure;

import java.sql.Connection;
import java.sql.SQLException;

public interface IDatabase {
    Connection getConnection() throws SQLException;
    void createOrCheckDatabase() throws SQLException;
}
