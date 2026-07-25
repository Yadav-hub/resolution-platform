package com.aman.resolutionplatform.Services.Feedback.ServiceImplementation;
import com.aman.resolutionplatform.mapper.FeedbackMapper;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.aman.resolutionplatform.DTO.Feedback.FeedbackDTO;
import com.aman.resolutionplatform.DTO.Feedback.FeedbackResponseDTO;
import com.aman.resolutionplatform.DTO.Feedback.UpdateFeedbackDTO;
import com.aman.resolutionplatform.Exception.FeedbackNotFoundException;
import com.aman.resolutionplatform.Model.Feedback.Feedback;
import com.aman.resolutionplatform.Repository.Feedback.FeedbackRepo;
import com.aman.resolutionplatform.Services.Feedback.FeedbackService;

@Service
public class FeedbackServiceImple implements FeedbackService{

    private final FeedbackMapper feedbackMapper;
    private final FeedbackRepo feedbackRepo;

    public FeedbackServiceImple(FeedbackRepo feedbackRepo, FeedbackMapper feedbackMapper)
    {
        this.feedbackRepo = feedbackRepo;
        this.feedbackMapper = feedbackMapper;
    }

    public FeedbackResponseDTO submitFeedback(FeedbackDTO dto)
    {
        Feedback feedbackData = new Feedback();
        feedbackData.setCustomerName(dto.getCustomerName());
        feedbackData.setCustomerPhoneNO(dto.getCustomerPhoneNo());
        feedbackData.setFeedbackInfo(dto.getFeedbackInfo());
        feedbackData.setRoomNo(dto.getRoomNo());
        feedbackData.setRating(dto.getRating());
        Feedback savedFeedback = feedbackRepo.save(feedbackData);

        return feedbackMapper.convertToFeedbackDTO(savedFeedback);
    }

    public FeedbackResponseDTO getFeedbackById(Integer feedbackId)
    {
        Feedback feedback = feedbackRepo.findById(feedbackId).orElseThrow(()-> new FeedbackNotFoundException("Feedback not found with id : "+feedbackId));

        return feedbackMapper.convertToFeedbackDTO(feedback);
        
    }

    public Page<FeedbackResponseDTO> getAllFeedback(Pageable pageable)
    {
        return feedbackRepo.findAll(pageable).map(feedbackMapper::convertToFeedbackDTO);
    }

  
    public FeedbackResponseDTO updateFeedback(Integer feedbackId, UpdateFeedbackDTO dto) {
        Feedback feedback = feedbackRepo.findById(feedbackId).orElseThrow(()-> new FeedbackNotFoundException("Feedback not found with id : "+ feedbackId));

        if(dto.getCustomerName()!=null && !dto.getCustomerName().isBlank())
        {
            feedback.setCustomerName(dto.getCustomerName());
        }
        if(dto.getCustomerPhoneNo()!=null && !dto.getCustomerPhoneNo().isBlank())
        {
            feedback.setCustomerPhoneNO(dto.getCustomerPhoneNo());
        }
        if(dto.getFeedbackInfo()!= null && !dto.getFeedbackInfo().isBlank())
        {
            feedback.setFeedbackInfo(dto.getFeedbackInfo());
        }
        if(dto.getRating()!= null)
        {
            feedback.setRating(dto.getRating());
        }
        if(dto.getRoomNo()!= null)
        {
            feedback.setRoomNo(dto.getRoomNo());
        }

        Feedback savedFeedback = feedbackRepo.save(feedback);

        return feedbackMapper.convertToFeedbackDTO(savedFeedback);
    }

    public FeedbackResponseDTO deleteFeedbackById(Integer feedbackId)
    {
        Feedback feedback = feedbackRepo.findById(feedbackId).orElseThrow(()-> new FeedbackNotFoundException("Feedback not found with id "+feedbackId));
        feedbackRepo.delete(feedback);
        return feedbackMapper.convertToFeedbackDTO(feedback);
    }
}
