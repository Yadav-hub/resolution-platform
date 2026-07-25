package com.aman.resolutionplatform.DTO.Ticket;

import com.aman.resolutionplatform.Enum.Ticket.TicketStatus;

import jakarta.validation.constraints.NotNull;

public class UpdateTicketStatusDTO {

    @NotNull(message = "Ticket status can't be null while modifing")
    private TicketStatus ticketStatus;

    public void setTicketStatus(TicketStatus ticketStatus)
    {
        this.ticketStatus = ticketStatus;
    }

    public TicketStatus getTicketStatus()
    {
        return this.ticketStatus;
    }

}
