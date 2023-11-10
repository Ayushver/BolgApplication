package com.practiceseries.demo7.Exception;

import com.practiceseries.demo7.payload.ErrorDetails99;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails99> handlerGlobalExceptionNotfound(ResourceNotFoundException exception, WebRequest webRequest){
        ErrorDetails99 errorDetails99 = new ErrorDetails99(new Date(), exception.getMessage(), webRequest.getDescription(false));
        return new  ResponseEntity<>(errorDetails99, HttpStatus.NOT_FOUND);
    }
}
