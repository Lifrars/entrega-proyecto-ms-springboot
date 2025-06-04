package com.uncledavecode.feedback_service.model.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FeedbackRequest {
    private Long productId;
    private String userId;
    private String comment;
    private Integer rating;
}
