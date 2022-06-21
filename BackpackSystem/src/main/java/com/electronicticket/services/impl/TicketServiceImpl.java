package com.electronicticket.services.impl;

import com.electronicticket.domain.Ticket;
import com.electronicticket.domain.User;
import com.electronicticket.repository.TicketRepository;
import com.electronicticket.repository.UserRepository;
import com.electronicticket.services.TicketService;
import com.electronicticket.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author Niubaiquan
 * @desc
 * @date 2022年02月22日 2022/2/22
 */
@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public Ticket insertTicket(Ticket ticket) {
        return ticketRepository.saveAndFlush(ticket);
    }

    @Override
    public List<Ticket> findTickets() {
        return ticketRepository.findAll();
    }
}
