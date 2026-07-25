package com.aman.resolutionplatform.Exception;
import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.aman.resolutionplatform.Exception.response.ErrorReponse;

import jakarta.validation.ConstraintViolationException;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FeedbackNotFoundException.class)
    public ResponseEntity<ErrorReponse> handleFeedbackNotFoundException(FeedbackNotFoundException ex)
    {
        ErrorReponse error = new ErrorReponse();
        error.setMessage(ex.getMessage());
        error.setTimestamp(LocalDateTime.now());
        error.setStatusCode(HttpStatus.NOT_FOUND);
        return ResponseEntity.
                status(error.getStatusCode())
                .body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorReponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex)
    {
        ErrorReponse error = new ErrorReponse();
        error.setMessage(ex.getMessage());
        error.setTimestamp(LocalDateTime.now());
        error.setStatusCode(HttpStatus.BAD_REQUEST);

        return ResponseEntity.
                status(error.getStatusCode()).
                body(error);
    }

    @ExceptionHandler(TicketNotFoundException.class)
    public ResponseEntity<ErrorReponse> handleTicketNotFoundException(TicketNotFoundException ex)
    {
        ErrorReponse error = new ErrorReponse();
        error.setMessage(ex.getMessage());
        error.setStatusCode(HttpStatus.NOT_FOUND);
        error.setTimestamp(LocalDateTime.now());
        return ResponseEntity
                .status(error.getStatusCode())
                .body(error);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public  ResponseEntity<ErrorReponse> handleHttpMessageNotReadableException(HttpMessageNotReadableException e)
    {
        ErrorReponse error = new ErrorReponse();
        error.setMessage(e.getMessage());
        error.setTimestamp(LocalDateTime.now());
        

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public  ResponseEntity<ErrorReponse> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e)
    {
        ErrorReponse error = new ErrorReponse();
        error.setMessage(e.getMessage());
        error.setTimestamp(LocalDateTime.now());
        

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorReponse> handleConstraintViolationException(ConstraintViolationException ex)
    {
        ErrorReponse error = new ErrorReponse();
        error.setMessage(ex.getMessage());
        error.setTimestamp(LocalDateTime.now());
        error.setStatusCode(HttpStatus.BAD_REQUEST);
        return ResponseEntity.status(error.getStatusCode()).body(error);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleAnyException(Exception e)
    {
       ErrorReponse error = new ErrorReponse();
       error.setMessage(e.getMessage());
       error.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
       error.setTimestamp(LocalDateTime.now());
       return ResponseEntity
               .status(error.getStatusCode())
               .body(e.getClass().getName());
       
        

    }

}
