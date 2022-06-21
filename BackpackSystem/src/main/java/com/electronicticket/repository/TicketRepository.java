package com.electronicticket.repository;

import com.electronicticket.domain.Ticket;
import com.electronicticket.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Niubaiquan
 * @desc 这是通过JPA实现
 * @date 2022年02月22日 2022/2/22
 */
public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
