package com.aman.resolutionplatform.Repository.Ticket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aman.resolutionplatform.Model.Ticket.Ticket;
import java.util.List;
import com.aman.resolutionplatform.Enum.Ticket.TicketStatus;
import com.aman.resolutionplatform.Enum.Ticket.Department;



@Repository
public interface TicketRepo extends JpaRepository<Ticket, Integer>{
    
    List<Ticket> findByTicketStatus(TicketStatus ticketStatus);

    List<Ticket> findByDepartment(Department department);

    List<Ticket> findByDepartmentAndTicketStatus(Department department, TicketStatus ticketStatus);
}
