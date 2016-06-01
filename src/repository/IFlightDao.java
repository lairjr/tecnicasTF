package repository;

import dtos.FlightDTO;
import repository.dao.FlightDao;

import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by ljunior on 5/31/16.
 */
public interface IFlightDao {
    int insert(FlightDTO flight);
    List<FlightDTO> getByDate(Date from, Date to);
}
