package dtos.factories;

import dtos.TicketDTO;

import java.sql.ResultSet;

/**
 * Created by ljunior on 6/27/16.
 */
public interface ITicketDTOFactory {
    TicketDTO create(ResultSet rs);
}
