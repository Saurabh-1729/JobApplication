package com.saurabh.FirstJobApp.Reviews.impl;

import com.saurabh.FirstJobApp.Company.Company;
import com.saurabh.FirstJobApp.Company.CompanyService;
import com.saurabh.FirstJobApp.Reviews.Reviews;
import com.saurabh.FirstJobApp.Reviews.ReviewsRepository;
import com.saurabh.FirstJobApp.Reviews.ReviewsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewsServiceImpl implements ReviewsService {

    private final ReviewsRepository reviewsRepository;
    private final CompanyService companyService;

    public ReviewsServiceImpl(ReviewsRepository reviewsRepository, CompanyService companyService) {
        this.reviewsRepository = reviewsRepository;
        this.companyService = companyService;
    }

    @Override
    public List<Reviews> getAllReviews(Long companyId) {
        return reviewsRepository.findByCompanyId(companyId);
    }

    @Override
    public boolean addReview(Reviews reviews, Long companyId) {
//        get the company
        Company company = companyService.getCompanyById(companyId);
        if(company != null) {
//            since review is not coming with company we have to set it
            reviews.setCompany(company);

            reviewsRepository.save(reviews);
            return true;
        }
        return false;
    }

    @Override
    public Reviews getReview(Long companyId, Long reviewId) {
        List<Reviews> reviews = reviewsRepository.findByCompanyId(companyId);
        return reviews.stream().filter(reviews1 -> reviews1.getId().equals(reviewId)).findFirst().orElse(null);
    }

    @Override
    public boolean updateReview(Long companyId, Long reviewId, Reviews updatedReviews) {
        if(companyService.getCompanyById(companyId) != null){
            updatedReviews.setCompany(companyService.getCompanyById(companyId));
            updatedReviews.setId(reviewId);
            reviewsRepository.save(updatedReviews);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteReview(Long companyId, Long reviewId) {
        if(companyService.getCompanyById(companyId) != null && reviewsRepository.existsById(reviewId)){
//            Since it is a Bidirectional Result
            Reviews reviews = reviewsRepository.findById(reviewId).orElse(null);
            assert reviews != null;
            Company company = reviews.getCompany();
            company.getReviews().remove(reviews);
            reviews.setCompany(null);
            companyService.updateCompany(companyId, company);
            reviewsRepository.deleteById(reviewId);
            return true;
        }
        return false;
    }
}
