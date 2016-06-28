package repository;

import dtos.TicketDTO;

/**
 * Created by ljunior on 6/1/16.
 */
public interface ITicketDao {
    TicketDTO getByTicketId(int ticketId);
    TicketDTO insert(TicketDTO ticket);
    TicketDTO update(TicketDTO ticket);
}
