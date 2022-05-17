package com.example.luv2code.bookappdemo.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(DataNotFound exception)
    {
        ErrorResponse errorResponse = new ErrorResponse() ;
        errorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND) ;
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleGenericException(Exception exception)
    {
        ErrorResponse errorResponse = new ErrorResponse() ;
        errorResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST) ;
    }
}
