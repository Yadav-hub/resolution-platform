package com.aman.resolutionplatform.mapper;

import com.aman.resolutionplatform.DTO.Ticket.TicketResponseDTO;
import com.aman.resolutionplatform.Model.Ticket.Ticket;
import org.springframework.stereotype.Component;

@Component
public class TicketMapper {

    public TicketResponseDTO convertToDTO(Ticket ticket)
    {
        TicketResponseDTO response = new TicketResponseDTO();
        response.setTicketId(ticket.getTicket_id());
        response.setTicketStatus(ticket.getTicketStatus());
        response.setCreatedAt(ticket.getCreatedAt());
        response.setDepartment(ticket.getDepartment());
        response.setIssueInfo(ticket.getIssueInfo());

        return response;
    }
}
