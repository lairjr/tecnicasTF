package repository.dao;

import dtos.FlightDTO;
import dtos.TicketDTO;
import dtos.factories.ITicketDTOFactory;
import infrastructure.Constants;
import infrastructure.IDatabase;
import repository.ITicketDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ljunior on 6/2/16.
 */
public class TicketDao implements ITicketDao {
    private static TicketDao instance;
    private IDatabase db;
    private ITicketDTOFactory ticketDTOFactory;

    private TicketDao(IDatabase database, ITicketDTOFactory ticketDTOFactory) {
        db = database;
        this.ticketDTOFactory = ticketDTOFactory;
    }

    public static TicketDao getInstance(IDatabase database, ITicketDTOFactory ticketDTOFactory) {
        if (instance == null)
            instance = new TicketDao(database, ticketDTOFactory);

        return instance;
    }

    @Override
    public TicketDTO getByTicketId(int ticketId) {
        StringBuilder sql = new StringBuilder();

        sql.append(" SELECT * FROM " + Constants.Tickets.TABLE_NAME);

        sql.append(" WHERE ");

        sql.append(Constants.Tickets.TicketId + " = ? ");

        try (Connection conn = db.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql.toString());
            ps.setInt(1, ticketId);

            ResultSet rs = ps.executeQuery();

            rs.next();

            return ticketDTOFactory.create(rs);
        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;
    }

    @Override
    public TicketDTO insert(TicketDTO ticket) {
        StringBuilder sql = new StringBuilder();

        sql.append(" INSERT INTO " + Constants.Tickets.TABLE_NAME);
        sql.append(" ( ");

        sql.append(Constants.Tickets.Passenger + ", ");
        sql.append(Constants.Tickets.Document + ", ");
        sql.append(Constants.Tickets.OutboundFlightId + ", ");
        sql.append(Constants.Tickets.OutboundSeatId + ", ");
        sql.append(Constants.Tickets.InboundFlightId + ", ");
        sql.append(Constants.Tickets.InboundSeatId + ", ");
        sql.append(Constants.Tickets.Price);

        sql.append(" ) VALUES (? ,?, ?, ?, ?, ?, ?) ");

        try (Connection conn = db.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, ticket.getPassenger());
            ps.setInt(2, Integer.parseInt(ticket.getDocument()));
            ps.setInt(3, ticket.getOutboundFlightNumber());
            ps.setInt(4, ticket.getOutboundSeat());
            ps.setInt(5, ticket.getInboundFlightNumber());
            ps.setInt(6, ticket.getInboundSeat());
            ps.setInt(7, ticket.getPrice());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            rs.next();

            ticket.setTicketId(rs.getInt(1));

            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return ticket;
    }

    @Override
    public TicketDTO update(TicketDTO ticket) {
        StringBuilder sql = new StringBuilder();

        sql.append(" UPDATE " + Constants.Tickets.TABLE_NAME);
        sql.append(" SET ");

        sql.append(Constants.Tickets.Passenger + " = ?, ");
        sql.append(Constants.Tickets.Document + " = ?, ");
        sql.append(Constants.Tickets.OutboundFlightId + " = ?, ");
        sql.append(Constants.Tickets.OutboundSeatId + " = ?, ");
        sql.append(Constants.Tickets.InboundFlightId + " = ?, ");
        sql.append(Constants.Tickets.InboundSeatId + " = ?, ");
        sql.append(Constants.Tickets.Price + " = ? ");

        sql.append(" WHERE ");

        sql.append(Constants.Tickets.TicketId + " = ? ");

        try (Connection conn = db.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql.toString());

            ps.setString(1, ticket.getPassenger());
            ps.setInt(2, Integer.parseInt(ticket.getDocument()));
            ps.setInt(3, ticket.getOutboundFlightNumber());
            ps.setInt(4, ticket.getOutboundSeat());
            ps.setInt(5, ticket.getInboundFlightNumber());
            ps.setInt(6, ticket.getInboundSeat());
            ps.setInt(7, ticket.getPrice());
            ps.setInt(8, ticket.getTicketId());

            ps.executeUpdate();

            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return ticket;
    }

    @Override
    public int getNumberOfTicketsByPassenger(String document) {
        StringBuilder sql = new StringBuilder();

        sql.append(" SELECT COUNT(*) FROM " + Constants.Tickets.TABLE_NAME);

        sql.append(" WHERE ");

        sql.append(Constants.Tickets.Document + " = ? ");

        try (Connection conn = db.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql.toString());

            ps.setString(1, document);

            ResultSet rs = ps.executeQuery();

            rs.next();

            int numberOfTickets = rs.getInt(1);

            conn.close();

            return numberOfTickets;
        } catch (SQLException e) {
            System.out.println(e);
        }

        return 0;
    }
}
