package com.uncledavecode.feedback_service.controllers;

import com.uncledavecode.feedback_service.model.dtos.FeedbackRequest;
import com.uncledavecode.feedback_service.model.dtos.FeedbackResponse;
import com.uncledavecode.feedback_service.services.FeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/feedbacks")
@RequiredArgsConstructor
public class FeedbackController {

    private final FeedbackService service;

    @PostMapping
    public ResponseEntity<FeedbackResponse> createFeedback(@RequestBody FeedbackRequest request) {
        FeedbackResponse response = service.createFeedback(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/by-product/{productId}")
    public ResponseEntity<List<FeedbackResponse>> getFeedbackByProductId(
            @PathVariable("productId") Long productId) {
        List<FeedbackResponse> lista = service.getFeedbacksByProductId(productId);
        return ResponseEntity.ok(lista);
    }
}
