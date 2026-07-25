package com.aman.resolutionplatform.mapper;

import org.springframework.stereotype.Component;

import com.aman.resolutionplatform.DTO.Feedback.FeedbackResponseDTO;
import com.aman.resolutionplatform.Model.Feedback.Feedback;

@Component
public class FeedbackMapper {

    public FeedbackResponseDTO convertToFeedbackDTO(Feedback feedback)
    {
        FeedbackResponseDTO responseDTO = new FeedbackResponseDTO();

        responseDTO.setFeedbackId(feedback.getFeedbackId());
        responseDTO.setCustomerName(feedback.getCustomerName());
        responseDTO.setCustomerPhoneNO(feedback.getCustomerPhoneNo());
        responseDTO.setFeedbackInfo(feedback.getFeedbackInfo());
        responseDTO.setOnCreate(feedback.getOnCreate());
        responseDTO.setRating(feedback.getRating());
        responseDTO.setRoomNo(feedback.getRoomNo());

        return responseDTO;
    }

   

        

    
}
