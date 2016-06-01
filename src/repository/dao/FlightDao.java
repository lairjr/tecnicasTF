package repository.dao;

import dtos.FlightDTO;
import infrastructure.IDatabase;
import repository.IFlightDao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Created by ljunior on 5/31/16.
 */
public class FlightDao implements IFlightDao {
    private IDatabase db;

    public FlightDao(IDatabase database) {
        db = database;
    }

    @Override
    public int insert(FlightDTO flight) {
        try {
            Connection con = db.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<FlightDTO> getByDate(Date from, Date to) {
        return null;
    }
}
