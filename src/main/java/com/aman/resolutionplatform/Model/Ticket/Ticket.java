package com.aman.resolutionplatform.Model.Ticket;
import java.time.LocalDateTime;
import com.aman.resolutionplatform.Enum.Ticket.Department;
import com.aman.resolutionplatform.Enum.Ticket.SeverityType;
import com.aman.resolutionplatform.Enum.Ticket.TicketStatus;
import com.aman.resolutionplatform.Model.Feedback.Feedback;
import com.aman.resolutionplatform.Model.User.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;


@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ticket_id;

    @ManyToOne
    @JoinColumn(name = "feedback_id")
    private Feedback feedback;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Department department;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SeverityType severityType;
    
    @Column(nullable = false)
    private String issueInfo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TicketStatus ticketStatus;
    
    private LocalDateTime createdAt;

    @ManyToOne()
    @JoinColumn(name = "userId")
    private User assignedEngineer;

    public String getIssueInfo() {
        return issueInfo;
    }

    public void setIssueInfo(String issueInfo) {
        this.issueInfo = issueInfo;
    }


    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @PrePersist
    public void onCreate()
    {
        this.createdAt = LocalDateTime.now();
        this.ticketStatus = TicketStatus.CREATED;
    }

    public Integer getTicket_id()
    {
        return this.ticket_id;
    }

    public void setDepartment(Department department)
    {
        this.department = department;
    }
    public Department getDepartment()
    {
        return this.department;
    }

    public void setSeverityType(SeverityType severityType)
    {
        this.severityType = severityType;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public SeverityType getSeverityType()
    {
        return this.severityType;
    }

    public void setTicketStatus(TicketStatus ticketStatus)
    {
        this.ticketStatus = ticketStatus;
    }

    public TicketStatus getTicketStatus()
    {
        return this.ticketStatus;
    }

    public void setFeedback(Feedback feedback)
    {
        this.feedback = feedback;
    }

    public Feedback getFeedback()
    {
        return this.feedback;
    }

    public void setAssignedEngineer(User assignedEngineer)
    {
        this.assignedEngineer = assignedEngineer;
    }

    public User getAssignedEngineer()
    {
        return this.assignedEngineer;
    }
    

}
