package com.sd.devicemanagement.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    private ApiExceptionFormat buildResponseEntity(HttpStatus status, String message) {
        ApiExceptionFormat apiException = new ApiExceptionFormat();
        apiException.setStatus(status.value());
        apiException.setMessage(message);
        apiException.setTimestamp(LocalDateTime.now());
        return apiException;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(DmConflictException.class)
    public ApiExceptionFormat handleDmConflictException(DmConflictException ex) {
        return buildResponseEntity(HttpStatus.CONFLICT, ex.getMessage());
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(DmNotFoundException.class)
    public ApiExceptionFormat handleDmNotFoundException(DmNotFoundException ex) {
        return buildResponseEntity(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedException.class)
    public ApiExceptionFormat handleUnauthorizedException(UnauthorizedException ex) {
        return buildResponseEntity(HttpStatus.UNAUTHORIZED, ex.getMessage());
    }
}
