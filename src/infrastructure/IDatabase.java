package infrastructure;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by ljunior on 5/31/16.
 */
public interface IDatabase {
    Connection getConnection() throws SQLException;
}
