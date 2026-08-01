package com.aman.resolutionplatform.DTO.Feedback;

import com.aman.resolutionplatform.Enum.Feedback.Rating;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public class FeedbackRequestDTO {

    @Size(min = 3, message = "Name must contain at least 3 charachters")
    private String customerName;
    @NotBlank
    private String customerPhoneNo;
    @NotBlank(message = "Room Number must be greater than 0")

    private String roomNo;
    @Size(min = 10, message = "Feedback must contain at least 10 charachters")
    private String feedbackInfo;
    @NotNull(message = "Rating must be between One to Five")
    private Rating rating;

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

    public String getCustomerPhoneNo()
    {
        return this.customerPhoneNo;
    }

    public void setCustomerPhoneNO(String customerPhoneNo)
    {
        this.customerPhoneNo = customerPhoneNo;
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
