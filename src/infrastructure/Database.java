package infrastructure;

import org.apache.derby.jdbc.EmbeddedDataSourceInterface;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by ljunior on 5/31/16.
 */
public class Database implements IDatabase {
    public static String DB_NAME = "tecnicasDB";
    public static String USER_NAME = "app";
    public static String PASSWORD = "app";
    private static IDatabase instance;
    private EmbeddedDataSourceInterface dataSource;

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

    public static void createDB(EmbeddedDataSourceInterface dataSource) throws Exception {
        try (Connection con = getInstance(dataSource).getConnection();
             Statement sta = con.createStatement()) {
            String sqlPassenger = "CREATE TABLE PASSENGERS("
                    + "ID_PASSENGER CHAR(9) PRIMARY KEY NOT NULL,"
                    + "NAME VARCHAR(150) NOT NULL)";
            sta.executeUpdate(sqlPassenger);
            String sqlAirport = "CREATE TABLE AIRPORTS("
                    + "ID_AIRPORT CHAR(3) PRIMARY KEY NOT NULL,"
                    + "NAME VARCHAR (150) NOT NULL)";
            sta.executeUpdate(sqlAirport);
            String sqlAirLine = "CREATE TABLE AIRLINE("
                    + "ID_AIRLINE CHAR(2) PRIMARY KEY NOT NULL,"
                    + "NAME VARCHAR (150) NOT NULL)";
            sta.executeUpdate(sqlAirLine);
            String sqlFlights = "CREATE TABLE FLIGHTS("
                    + "ID_FLIGHT CHAR(7) PRIMARY KEY NOT NULL,"
                    + "SCHEDULE TIMESTAMP NOT NULL,"
                    + "INTERNATIONAL BOOLEAN NOT NULL,"
                    + "FROM CHAR(3) NOT NULL,"
                    + "TO CHAR(3) NOT NULL,"
                    + "ID_AIRLINE CHAR(2) NOT NULL)";
            sta.executeUpdate(sqlFlights);
            String sqlFlight1 = "ALTER TABLE FLIGHTS"
                    + "ADD CONSTRAINT FK_FLIGHTS_AIRPORTS_FROM FOREIGN KEY (FROM) REFERENCES AIRPORTS (ID_AIRPORT)";
            sta.executeUpdate(sqlFlight1);
            String sqlFlight2 = "ALTER TABLE FLIGHTS"
                    + "ADD CONSTRAINT FK_FLIGHTS_AIRPORTS_TO FOREIGN KEY (TO) REFERENCES AIRPORTS (ID_AIRPORT)";
            sta.executeUpdate(sqlFlight2);
            String sqlFlight3 = "ALTER TABLE FLIGHTS"
                    + "ADD CONSTRAINT FK_FLIGHTS_AIRLINES FOREIGN KEY (ID_AIRLINE) REFERENCES AIRLINES (ID_AIRLINE)";
            sta.executeUpdate(sqlFlight2);
            String sqlPassage = "CREATE TABLE PASSAGES("
                    + "ID_PASSAGE CHAR(3) NOT NULL,"
                    + "ID_FLIGHT CHAR(7) NOT NULL,"
                    + "ID_PASSENGER CHAR(9) NOT NULL,"
                    + "DOC_TYPE VARCHAR(50) NOT NULL,"
                    + "STATUS VARCHAR(50) NOT NULL)";
            sta.executeUpdate(sqlPassage);
            String sqlPassage1 = "ALTER TABLE PASSAGES"
                    + "ADD CONSTRAINT PK_PASSAGES PRIMARY KEY (ID_PASSAGE,ID_FLIGHT)";
            sta.executeUpdate(sqlPassage1);
            String sqlPassage2 = "ALTER TABLE PASSAGES"
                    + "ADD CONSTRAINT FK_PASSAGES_FLIGHTS FOREIGN KEY (ID_FLIGHT) REFERENCES FLIGHTS (ID_FLIGHT)";
            sta.executeUpdate(sqlPassage2);
            String sqlPassage3 = "ALTER TABLE PASSAGES"
                    + "ADD CONSTRAINT FK_PASSAGES_PASSENGERS FOREIGN KEY (ID_PASSENGER) REFERENCES PASSENGERS (ID_PASSENGER)";
            sta.executeUpdate(sqlPassage3);
            String sqlSeat = "CREATE TABLE SEATS("
                    + "ID_SEAT CHAR(3) NOT NULL,"
                    + "ID_FLIGHT CHAR(7) NOT NULL,"
                    + "OCCUPIED BOOLEAN NOT NULL)";
            sta.executeUpdate(sqlSeat);
            String sqlSeat1 = "ALTER TABLE SEATS"
                    + "ADD CONSTRAINT PK_SEATS PRIMARY KEY (ID_SEAT,ID_FLIGHT)";
            sta.executeUpdate(sqlSeat1);
            String sqlSeat2 = "ALTER TABLE SEATS"
                    + "ADD CONSTRAINT FK_SEATS_FLIGHTS FOREIGN KEY (ID_FLIGHT) REFERENCES FLIGHTS (ID_FLIGHT)";
            sta.executeUpdate(sqlSeat2);
            String sqlPromotion = "CREATE TABLE PROMOTIONS("
                    + "ID_PROMOTION CHAR(3) PRIMARY KEY NOT NULL,"
                    + "DESCRIPTIONS CHAR(250),"
                    + "PERCENTAGE NUMERIC(3) NOT NULL)";
            sta.executeUpdate(sqlPromotion);
            String sqlPromotionFlight = "CREATE TABLE PROMOTIONS_FLIGHTS("
                    + "ID_PROMOTION CHAR(3) NOT NULL,"
                    + "ID_FLIGHT CHAR(7) NOT NULL)";
            sta.executeUpdate(sqlPromotionFlight);
            String sqlPromotionFlight1 = "ALTER TABLE PROMOTIONS_FLIGHTS"
                    + "ADD CONSTRAINT PK_PROMOTIONS_FLIGHTS PRIMARY KEY (ID_PROMOTION,ID_FLIGHT)";
            sta.executeUpdate(sqlPromotionFlight1);
        }
        
    }
}
