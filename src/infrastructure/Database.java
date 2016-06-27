package infrastructure;

import org.apache.derby.jdbc.EmbeddedDataSourceInterface;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 * Created by ljunior on 5/31/16.
 */
public class Database implements IDatabase {
    public static String DB_NAME = "tecnicasDB";
    public static String USER_NAME = "app";
    public static String PASSWORD = "app";
    private static IDatabase instance;
    private EmbeddedDataSourceInterface dataSource;
    private Connection conn;

    private Database(EmbeddedDataSourceInterface dataSource) {
        this.dataSource = dataSource;
    }

    public static IDatabase getInstance(EmbeddedDataSourceInterface dataSource) {
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

    @Override
    public void createOrCheckDatabase() throws SQLException {
        dropTable(Constants.Seats.TABLE_NAME);
        dropTable(Constants.Flights.TABLE_NAME);
        dropTable(Constants.Tickets.TABLE_NAME);
        createOrCheckSeats();
        createOrCheckFlights();
        createOrCheckTickets();
    }

    private void dropTable(String table) {
        try (Connection conn = this.getConnection()) {
            Statement s = conn.createStatement();
            s.execute("DELETE FROM " + table);
            s.execute("DROP TABLE " + table);
            conn.close();
        }catch (SQLException e) {
            System.out.println(e);
        }
    }

    private void createOrCheckTable(String table, String sqlQuery) throws SQLException {
        try (Connection conn = this.getConnection()) {
            ResultSet rs = conn.getMetaData().getTables(null, null, table, null);

            if (!rs.next()) {
                Statement sql = conn.createStatement();

                sql.execute(sqlQuery);
            }

            conn.close();
        }
    }

    private void createOrCheckSeats() throws SQLException {
        StringBuilder sqlQuery = new StringBuilder();

        sqlQuery.append(" CREATE TABLE " + Constants.Seats.TABLE_NAME +  " ( ");
        sqlQuery.append(Constants.Seats.SeatId + " INT PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),");
        sqlQuery.append(Constants.Seats.FlightId + " INT NOT NULL, ");
        sqlQuery.append(Constants.Seats.Number + " INT NOT NULL, ");
        sqlQuery.append(Constants.Seats.Occupied + " INT NOT NULL ");
        sqlQuery.append(" ) ");

        createOrCheckTable(Constants.Seats.TABLE_NAME , sqlQuery.toString());
    }

    private void createOrCheckFlights() throws SQLException {
        StringBuilder sqlQuery = new StringBuilder();

        sqlQuery.append(" CREATE TABLE " + Constants.Flights.TABLE_NAME + " ( ");
        sqlQuery.append(Constants.Flights.FlightId + " INT PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), ");
        sqlQuery.append(Constants.Flights.DepartureLocal + " VARCHAR(50), ");
        sqlQuery.append(Constants.Flights.DepartureDate + " TIMESTAMP, ");
        sqlQuery.append(Constants.Flights.ArrivalLocal + " VARCHAR(50), ");
        sqlQuery.append(Constants.Flights.ArrivalDate + " TIMESTAMP, ");
        sqlQuery.append(Constants.Flights.International + " INT, ");
        sqlQuery.append(Constants.Flights.Price + " INT ");
        sqlQuery.append(" ) ");

        createOrCheckTable(Constants.Flights.TABLE_NAME, sqlQuery.toString());
    }

    private void createOrCheckTickets() throws SQLException {
        StringBuilder sqlQuery = new StringBuilder();

        sqlQuery.append(" CREATE TABLE " + Constants.Tickets.TABLE_NAME +  " ( ");
        sqlQuery.append(Constants.Tickets.TicketId + " INT PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), ");
        sqlQuery.append(Constants.Tickets.Passenger + " VARCHAR(50) NOT NULL, ");
        sqlQuery.append(Constants.Tickets.Document + " INT NOT NULL, ");
        sqlQuery.append(Constants.Tickets.OutboundFlightId + " INT NOT NULL, ");
        sqlQuery.append(Constants.Tickets.OutboundSeatId + " INT, ");
        sqlQuery.append(Constants.Tickets.InboundFlightId + " INT, ");
        sqlQuery.append(Constants.Tickets.InboundSeatId + " INT ");
        sqlQuery.append(" ) ");

        createOrCheckTable(Constants.Tickets.TABLE_NAME, sqlQuery.toString());
    }
}
