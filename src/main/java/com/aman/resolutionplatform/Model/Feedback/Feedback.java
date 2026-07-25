package com.aman.resolutionplatform.Model.Feedback;

import java.time.LocalDateTime;

import com.aman.resolutionplatform.Enum.Feedback.Rating;
import com.aman.resolutionplatform.Enum.Feedback.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;

@Entity
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer feedbackId;
    private String customerName;
    private String customerPhoneNo;
    private String roomNo;
    private String feedbackInfo;
    @Enumerated(EnumType.STRING)
    private Rating rating;
    private LocalDateTime onCreate;
    @Enumerated(EnumType.STRING)
    private Status status;

    
    public Status getStatus()
    {
        return status;
    }

    @PrePersist
    public void onCreate()
    {
        this.onCreate = LocalDateTime.now();
        this.status = Status.CREATED;
    }

    public LocalDateTime getOnCreate()
    {
        return this.onCreate;
    }


    public Integer getFeedbackId()
    {
        return this.feedbackId;
    }

    public String getCustomerPhoneNo()
    {
        return this.customerPhoneNo;
    }

    public void setCustomerPhoneNO(String customerPhoneNo)
    {
        this.customerPhoneNo = customerPhoneNo;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getRoomNo() {
        return this.roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getFeedbackInfo() {
        return this.feedbackInfo;
    }

    public void setFeedbackInfo(String feedbackInfo) {
        this.feedbackInfo = feedbackInfo;
    }

    public void setRating(Rating rating)
    {
        this.rating = rating;
    }

    public Rating getRating()
    {
        return this.rating;
    }
    

}
