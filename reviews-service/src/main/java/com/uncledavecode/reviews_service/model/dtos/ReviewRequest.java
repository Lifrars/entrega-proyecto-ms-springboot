package com.uncledavecode.reviews_service.model.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewRequest {
    private Long productId;
    private String comment;
    private Integer rating;
}
