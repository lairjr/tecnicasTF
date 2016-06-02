package domain;

import dtos.TicketDTO;

/**
 * Created by ljunior on 5/31/16.
 */
public interface ITicketService {
    TicketDTO save(TicketDTO ticketDTO);
}
