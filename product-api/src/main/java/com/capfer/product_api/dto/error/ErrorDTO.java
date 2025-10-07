package com.capfer.product_api.dto.error;

import java.time.LocalDateTime;

public record ErrorDTO(
        int statusCode,
        String message,
        String exceptionMessage,
        LocalDateTime timestamp
) {
}
