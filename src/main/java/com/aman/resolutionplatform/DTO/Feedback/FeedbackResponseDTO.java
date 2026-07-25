package com.aman.resolutionplatform.DTO.Feedback;

import java.time.LocalDateTime;

import com.aman.resolutionplatform.Enum.Feedback.Rating;


public class FeedbackResponseDTO {
    
    
    private Integer feedbackId;
    private String customerName;
    private String customerPhoneNo;
    private String roomNo;
    private String feedbackInfo;
    
    private Rating rating;

    private LocalDateTime onCreate;
    

    public LocalDateTime getOnCreate()
    {
        return this.onCreate;
    }

    public void setOnCreate(LocalDateTime onCreate)
    {
        this.onCreate = onCreate;
    }

    public Integer getFeedbackId()
    {
        return this.feedbackId;
    }

    public void setFeedbackId(Integer feedbackId)
    {
        this.feedbackId = feedbackId;
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
