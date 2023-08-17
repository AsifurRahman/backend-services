package com.asif.backend.common.advice;


import com.asif.backend.common.constant.ApplicationConstant;
import com.asif.backend.common.constant.ErrorId;
import com.asif.backend.common.exception.ApiError;
import com.asif.backend.common.exception.ErrorCodeReader;
import com.asif.backend.common.exception.RMSError;
import com.asif.backend.common.exception.RmsServerException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Objects;
import java.util.Set;

import static org.apache.commons.lang3.StringUtils.*;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        ApiError apiError = new ApiError();
        RMSError RMSError =
                new RMSError(ErrorId.SYSTEM_ERROR, ex.getLocalizedMessage());
        apiError.addError(RMSError);
        ex.printStackTrace();
        return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public final ResponseEntity<Object>
    handleConstraintViolationExceptionAllException(ConstraintViolationException ex, WebRequest request) {
        ApiError apiError = new ApiError();
        Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
        violations.forEach(violation -> {
            RMSError reservationError = getEngineeringManagementError(violation.getMessageTemplate());
            apiError.addError(reservationError);
        });
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RmsServerException.class)
    public final ResponseEntity<Object> handleEngineeringManagementServerException(
            RmsServerException ex, WebRequest request) {
        ApiError apiError = new ApiError();
        RMSError reservationError = getEngineeringManagementError(ex.getErrorId());
        apiError.addError(reservationError);
        return new ResponseEntity<>(apiError, ex.getStatus());
    }

//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(
//            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
//        ApiError apiError = new ApiError();
//
//        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
//            RMSError reservationError = getEngineeringManagementError(error.getDefaultMessage(),
//                    buildErrorMessage(error));
//            apiError.addError(reservationError);
//        }
//        return new ResponseEntity(apiError, HttpStatus.BAD_REQUEST);
//    }

//    @Override
//    protected ResponseEntity<Object> handleHttpMessageNotReadable(
//            HttpMessageNotReadableException e, HttpHeaders headers, HttpStatus status, WebRequest request) {
//        ApiError apiError = new ApiError();
//        if (e.getMostSpecificCause() instanceof RmsServerException) {
//            RmsServerException rmsServerException = (RmsServerException) e.getMostSpecificCause();
//            RMSError error = getEngineeringManagementError(rmsServerException.getErrorId());
//            apiError.addError(error);
//            return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
//        } else if (e.getMostSpecificCause() instanceof InvalidFormatException) {
//            InvalidFormatException iex = (InvalidFormatException) e.getMostSpecificCause();
//            iex.getPath().forEach(reference -> {
//                RMSError RMSError = new RMSError(ErrorId.INVALID_DATA_FORMAT_EXCEPTION, iex.getOriginalMessage());
//                apiError.addError(RMSError);
//            });
//            return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
//        }
//        return handleAllExceptions(e, request);
//    }

    private RMSError getEngineeringManagementError(String code) {
        RMSError RMSError = ErrorCodeReader.getEngineeringManagementError(code);
        if (Objects.isNull(RMSError)) {
            return ErrorCodeReader.getErrorByMessage(code);
        }
        return RMSError;
    }

    private RMSError getEngineeringManagementError(String code, String message) {
        RMSError RMSError = ErrorCodeReader.getEngineeringManagementError(code);
        if (Objects.isNull(RMSError)) {
            return ErrorCodeReader.getErrorByMessage(message);
        }
        return RMSError;
    }

    private String buildErrorMessage(FieldError error) {
        return capitalize(StringUtils.join(splitByCharacterTypeCamelCase(emptyFieldErrorIfNull(error)
        ), SPACE)) + SPACE + error.getDefaultMessage();
    }

    private String emptyFieldErrorIfNull(FieldError fieldError) {
        return Objects.isNull(fieldError) ? ApplicationConstant.EMPTY_STRING : fieldError.getField();
    }
}
