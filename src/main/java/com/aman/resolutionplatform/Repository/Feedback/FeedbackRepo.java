package com.aman.resolutionplatform.Repository.Feedback;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aman.resolutionplatform.Model.Feedback.Feedback;


@Repository
public interface FeedbackRepo extends JpaRepository<Feedback,Integer> {


}
