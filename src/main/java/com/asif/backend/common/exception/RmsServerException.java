package com.asif.backend.common.exception;

import com.asif.backend.common.constant.ApplicationConstant;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;

import java.io.Serial;

@Setter
@Getter
public class RmsServerException extends RuntimeException {
    /**
     * Serial version UID.
     */
    @Serial
    private static final long serialVersionUID = 1436995162658277359L;
    /**
     * Error id.
     */
    private final String errorId;

    /**
     * trace id.
     */
    private final String traceId;

    private HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

    public RmsServerException(String errorId, HttpStatus status, String traceId) {
        this.errorId = errorId;
        this.traceId = traceId;
        this.status = status;
    }

    public static RmsServerException badRequest(String errorId) {
        return new RmsServerException(errorId, HttpStatus.BAD_REQUEST, MDC.get(
                ApplicationConstant.TRACE_ID));
    }

    public static RmsServerException notFound(String errorId) {
        return new RmsServerException(errorId, HttpStatus.NOT_FOUND, MDC.get(
                ApplicationConstant.TRACE_ID));
    }

    public static RmsServerException dataSaveException(String errorId) {
        return new RmsServerException(errorId, HttpStatus.INTERNAL_SERVER_ERROR,
            MDC.get(ApplicationConstant.TRACE_ID));
    }

    public static RmsServerException internalServerException(String errorId) {
        return new RmsServerException(errorId, HttpStatus.INTERNAL_SERVER_ERROR,
                MDC.get(ApplicationConstant.TRACE_ID));
    }

    public static RmsServerException methodNotAllowed(String errorId) {
        return new RmsServerException(errorId, HttpStatus.UNAUTHORIZED,
            MDC.get(ApplicationConstant.TRACE_ID));
    }

    public static RmsServerException notAuthorized(String errorId) {
        return new RmsServerException(
                errorId,
                HttpStatus.FORBIDDEN,
                MDC.get(ApplicationConstant.TRACE_ID)
        );
    }
}
