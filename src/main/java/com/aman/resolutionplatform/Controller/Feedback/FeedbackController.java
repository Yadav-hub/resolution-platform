package com.aman.resolutionplatform.Controller.Feedback;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RestController;

import com.aman.resolutionplatform.DTO.Feedback.FeedbackRequestDTO;
import com.aman.resolutionplatform.DTO.Feedback.FeedbackResponseDTO;
import com.aman.resolutionplatform.DTO.Feedback.UpdateFeedbackDTO;
import com.aman.resolutionplatform.Services.Feedback.FeedbackService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.util.List;
import java.util.Set;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
public class FeedbackController {

    private final FeedbackService feedbackService;


    private final Set<String> allowedSortByString = Set.of(
        "customerName",
        "roomNo",
        "rating",
        "onCreate",
        "status"
    );

    public FeedbackController(FeedbackService feedbackService)
    {
        this.feedbackService = feedbackService;
        
    }
    
    @GetMapping("/feedback/{feedbackId}")
    public ResponseEntity<FeedbackResponseDTO> getFeedbackById(@PathVariable @Valid Integer feedbackId, @RequestParam() Integer id) {
        return ResponseEntity.ok(feedbackService.getFeedbackById(feedbackId));
    }
    
    @PostMapping("/feedback")
    public ResponseEntity<FeedbackResponseDTO> saveFeedback(@RequestBody @Valid FeedbackRequestDTO dto) 
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(feedbackService.submitFeedback(dto));
    }
    
    @GetMapping("/feedback")
    public ResponseEntity<Page<FeedbackResponseDTO>> getAllFeedback(
        @PositiveOrZero @RequestParam(defaultValue = "0") Integer page,
        @Positive @RequestParam(defaultValue = "10") Integer size,
        @RequestParam(defaultValue = "onCreate") String sortBy, 
        @RequestParam(defaultValue = "DESC") String sortDirection
    ) 
    {
        

        if(!allowedSortByString.contains(sortBy))
        {
            throw new IllegalArgumentException("Wrong choice of sort by");
        }
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection),sortBy);

        Pageable pageable = PageRequest.of(page,size,sort);


        return ResponseEntity.ok(feedbackService.getAllFeedback(pageable));

    }
    
    @PatchMapping("feedback/{id}")
    public ResponseEntity<FeedbackResponseDTO> updateFeedback(@PathVariable @Valid Integer feedbackId, @RequestBody @Valid UpdateFeedbackDTO dto) {

        return ResponseEntity.ok(feedbackService.updateFeedback(feedbackId, dto));
    }

    @DeleteMapping("feedback/{feedbackId}")
    public ResponseEntity<Void> deleteFeedback(@PathVariable @Valid Integer feedbackId)
    {
        feedbackService.deleteFeedbackById(feedbackId);
        return ResponseEntity.noContent().build();
    }
}
