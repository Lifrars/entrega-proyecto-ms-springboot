package com.uncledavecode.feedback_service.services;

import com.uncledavecode.feedback_service.model.dtos.FeedbackRequest;
import com.uncledavecode.feedback_service.model.dtos.FeedbackResponse;
import com.uncledavecode.feedback_service.model.entities.Feedback;
import com.uncledavecode.feedback_service.repositories.FeedbackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedbackService {

    private final FeedbackRepository repository;

    public FeedbackResponse createFeedback(FeedbackRequest request) {
        // Obtener userId desde el token (igual que en Reviews)
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();

        Feedback saved = repository.save(
            Feedback.builder()
                .productId(request.getProductId())
                .userId(userId)
                .comment(request.getComment())
                .rating(request.getRating())
                .createdAt(LocalDateTime.now())
                .build()
        );

        return FeedbackResponse.builder()
                .id(saved.getId())
                .productId(saved.getProductId())
                .userId(saved.getUserId())
                .comment(saved.getComment())
                .rating(saved.getRating())
                .createdAt(saved.getCreatedAt())
                .build();
    }

    public List<FeedbackResponse> getFeedbacksByProductId(Long productId) {
        return repository.findByProductId(productId)
                .stream()
                .map(fb -> FeedbackResponse.builder()
                        .id(fb.getId())
                        .productId(fb.getProductId())
                        .userId(fb.getUserId())
                        .comment(fb.getComment())
                        .rating(fb.getRating())
                        .createdAt(fb.getCreatedAt())
                        .build())
                .toList();
    }
}
