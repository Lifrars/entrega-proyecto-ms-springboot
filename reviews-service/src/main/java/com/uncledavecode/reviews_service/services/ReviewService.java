package com.uncledavecode.reviews_service.services;

import com.uncledavecode.reviews_service.model.dtos.ReviewRequest;
import com.uncledavecode.reviews_service.model.dtos.ReviewResponse;
import com.uncledavecode.reviews_service.model.entities.Review;
import com.uncledavecode.reviews_service.repositories.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository repository;

    public void saveReview(ReviewRequest request) {
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();

        Review review = Review.builder()
                .productId(request.getProductId())
                .userId(userId)
                .comment(request.getComment())
                .rating(request.getRating())
                .createdAt(LocalDateTime.now())
                .build();

        repository.save(review);
    }

    public List<ReviewResponse> getReviewsByProductId(Long productId) {
        return repository.findByProductId(productId).stream().map(review -> ReviewResponse.builder()
                .id(review.getId())
                .productId(review.getProductId())
                .userId(review.getUserId())
                .comment(review.getComment())
                .rating(review.getRating())
                .createdAt(review.getCreatedAt())
                .build()
        ).toList();
    }
}
