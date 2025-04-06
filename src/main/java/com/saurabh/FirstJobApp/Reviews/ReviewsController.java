package com.saurabh.FirstJobApp.Reviews;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewsController {
    private final ReviewsService reviewsService;

    public ReviewsController(ReviewsService reviewsService) {
        this.reviewsService = reviewsService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Reviews>> getAllReviews(@PathVariable Long companyId){
        return new ResponseEntity<>(reviewsService.getAllReviews(companyId), HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> addReview(@RequestBody  Reviews reviews, @PathVariable Long companyId){
        boolean isReviewSaved = reviewsService.addReview(reviews, companyId);
        if(isReviewSaved)
            return new ResponseEntity<>("Review Added Successfully", HttpStatus.OK);
        return new ResponseEntity<>("Review Not Saved", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Reviews> getReview(@PathVariable Long companyId, @PathVariable Long reviewId){
        return new ResponseEntity<>(reviewsService.getReview(companyId, reviewId), HttpStatus.OK);
    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long companyId, @PathVariable Long reviewId, @RequestBody Reviews reviews){
        boolean isReviewUpdated = reviewsService.updateReview(companyId, reviewId, reviews);
        if(isReviewUpdated)
            return new ResponseEntity<>("Review Updated Successfully", HttpStatus.OK);
        return new ResponseEntity<>("Review Not found",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long reviewId, @PathVariable Long companyId){
        boolean isReviewDeleted = reviewsService.deleteReview(companyId, reviewId);
        if(isReviewDeleted)
            return new ResponseEntity<>("Review Deleted Successfully", HttpStatus.OK);
        return new ResponseEntity<>("Review Not Found", HttpStatus.NOT_FOUND);
    }
}
