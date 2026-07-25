package com.aman.resolutionplatform.Services.Feedback;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.aman.resolutionplatform.DTO.Feedback.FeedbackDTO;
import com.aman.resolutionplatform.DTO.Feedback.FeedbackResponseDTO;
import com.aman.resolutionplatform.DTO.Feedback.UpdateFeedbackDTO;
import com.aman.resolutionplatform.Model.Feedback.Feedback;

public interface FeedbackService {


    FeedbackResponseDTO submitFeedback(FeedbackDTO dto);

    FeedbackResponseDTO getFeedbackById(Integer feedbackId);

    Page<FeedbackResponseDTO> getAllFeedback(Pageable pageable);

    FeedbackResponseDTO updateFeedback(Integer feedbackId, UpdateFeedbackDTO dto);

    FeedbackResponseDTO deleteFeedbackById(Integer feedbackId);
}
