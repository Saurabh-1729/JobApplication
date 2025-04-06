package com.saurabh.FirstJobApp.Reviews;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ReviewsService {
    List<Reviews> getAllReviews(Long companyId);
    boolean addReview(Reviews reviews, Long companyId);
    Reviews getReview(Long companyId, Long reviewId);
    boolean updateReview( Long companyId,  Long reviewId,  Reviews reviews);

    boolean deleteReview(Long companyId, Long reviewId);
}
