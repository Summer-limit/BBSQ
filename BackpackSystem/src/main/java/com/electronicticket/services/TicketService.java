package com.electronicticket.services;

import com.electronicticket.domain.Ticket;
import com.electronicticket.domain.User;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author Niubaiquan
 * @desc
 * @date 2022年02月22日 2022/2/22
 */
public interface TicketService {
    Ticket insertTicket(Ticket ticket);
    List<Ticket> findTickets();
}
