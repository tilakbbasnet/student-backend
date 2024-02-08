package com.test.firstproject.exception;

import com.test.firstproject.model.ValidationErrorResponse;
import jakarta.validation.UnexpectedTypeException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandling {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ValidationErrorResponse>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        List<ValidationErrorResponse> validationErrorResponseList = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach(fieldError -> {
            ValidationErrorResponse validationErrorResponse = new ValidationErrorResponse(fieldError.getField(), fieldError.getDefaultMessage());
            validationErrorResponseList.add(validationErrorResponse);
        });
        return ResponseEntity.ok(validationErrorResponseList);
    }

    @ExceptionHandler(NullPointerException.class)
    public void handleNullPointerException(NullPointerException e){
        //
    }
}
