package com.uncledavecode.reviews_service.controllers;

import com.uncledavecode.reviews_service.model.dtos.ReviewRequest;
import com.uncledavecode.reviews_service.model.dtos.ReviewResponse;
import com.uncledavecode.reviews_service.services.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService service;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody ReviewRequest request) {
        service.saveReview(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<ReviewResponse>> getReviews(@PathVariable Long productId) {
        return ResponseEntity.ok(service.getReviewsByProductId(productId));
    }
}
