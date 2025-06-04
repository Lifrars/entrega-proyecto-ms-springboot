package com.uncledavecode.feedback_service.model.dtos;

import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FeedbackResponse {
    private Long id;
    private Long productId;
    private String userId;
    private String comment;
    private Integer rating;
    private LocalDateTime createdAt;
}
