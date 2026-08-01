package com.aman.resolutionplatform.DTO.Ticket;

import com.aman.resolutionplatform.Enum.Ticket.Department;
import com.aman.resolutionplatform.Enum.Ticket.SeverityType;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public class TicketRequestDTO {
    

    @NotNull(message = "Feedback Id can't be null")
    private Integer feedbackId;

    @NotNull(message = "Severity type can't be null")
    private SeverityType severityType;
    @NotNull(message = "Department can't be null")
    private Department department;

    @NotBlank(message = "Issue length should be grater than 5 letters")
    private String issueInfo;

    public String getIssueInfo() {
        return issueInfo;
    }

    public void setIssueInfo(String issueInfo) {
        this.issueInfo = issueInfo;
    }

    public void setFeedbackId(Integer feedbackId)
    {
        this.feedbackId = feedbackId;
    }

    public Integer getFeedbackId()
    {
        return this.feedbackId;
    }

    public void setSeverityType(SeverityType severityType)
    {
        this.severityType = severityType;
    }

    public SeverityType getSeverityType()
    {
        return this.severityType;
    }

    public void setDepartment(Department department)
    {
        this.department = department;
    }

    public Department getDepartment()
    {
        return this.department;
    }
}
