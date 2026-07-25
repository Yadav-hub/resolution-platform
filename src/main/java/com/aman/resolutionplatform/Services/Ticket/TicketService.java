package com.aman.resolutionplatform.Services.Ticket;

import java.util.List;

import com.aman.resolutionplatform.DTO.Ticket.TicketResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.aman.resolutionplatform.DTO.Ticket.TicketDTO;
import com.aman.resolutionplatform.Enum.Ticket.Department;
import com.aman.resolutionplatform.Enum.Ticket.TicketStatus;

public interface TicketService {



    TicketResponseDTO createTicket(TicketDTO ticketDTO);
    TicketResponseDTO getTicketById(Integer ticket_id);
    Page<TicketResponseDTO> getAllTickets(Pageable pageable);

    TicketResponseDTO updateTicketStatus(Integer ticket_id, TicketStatus status);

    List<TicketResponseDTO> findByTicketStatus(TicketStatus status);

    List<TicketResponseDTO> findByDepartment(Department department);

    List<TicketResponseDTO> findByDepartmentAndTicketStatus(Department department, TicketStatus ticketStatus);
}
