package com.asif.backend.common.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RMSError {
    private String code;
    private String message;

    public RMSError(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
