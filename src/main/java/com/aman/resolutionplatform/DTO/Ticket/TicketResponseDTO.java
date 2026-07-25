package com.aman.resolutionplatform.DTO.Ticket;

import com.aman.resolutionplatform.Enum.Ticket.Department;
import com.aman.resolutionplatform.Enum.Ticket.TicketStatus;

import java.time.LocalDateTime;

public class TicketResponseDTO {

    private Integer ticketId;


    private TicketStatus ticketStatus;
    private Department department;

    private LocalDateTime createdAt;
    private String issueInfo;

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getIssueInfo() {
        return issueInfo;
    }

    public void setIssueInfo(String issueInfo) {
        this.issueInfo = issueInfo;
    }
}
