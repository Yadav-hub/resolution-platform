package com.aman.resolutionplatform.Exception;
import java.time.LocalDateTime;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.HandlerMethodValidationException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.aman.resolutionplatform.Exception.response.ErrorResp;

import jakarta.validation.ConstraintViolationException;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FeedbackNotFoundException.class)
    public ResponseEntity<ErrorResp> handleFeedbackNotFoundException(FeedbackNotFoundException ex)
    {
        ErrorResp error = new ErrorResp();
        error.setMessage(ex.getMessage());
        error.setTimestamp(LocalDateTime.now());
        error.setStatusCode(HttpStatus.NOT_FOUND);
        return ResponseEntity.
                status(error.getStatusCode())
                .body(error);
    }

    @ExceptionHandler(HandlerMethodValidationException.class)
    public ResponseEntity<ErrorResp> handleHandlerMethodValidationException(HandlerMethodValidationException ex)
    {
        ErrorResp error = new ErrorResp();
        error.setMessage(ex.getMessage());
        error.setTimestamp(LocalDateTime.now());
        error.setStatusCode(HttpStatus.BAD_REQUEST);

        return ResponseEntity.
                status(error.getStatusCode()).
                body(error);
    }
    

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResp> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex)
    {
        ErrorResp error = new ErrorResp();
        error.setMessage(ex.getMessage());
        error.setTimestamp(LocalDateTime.now());
        error.setStatusCode(HttpStatus.BAD_REQUEST);

        return ResponseEntity.
                status(error.getStatusCode()).
                body(error);
    }

    @ExceptionHandler(TicketNotFoundException.class)
    public ResponseEntity<ErrorResp> handleTicketNotFoundException(TicketNotFoundException ex)
    {
        ErrorResp error = new ErrorResp();
        error.setMessage(ex.getMessage());
        error.setStatusCode(HttpStatus.NOT_FOUND);
        error.setTimestamp(LocalDateTime.now());
        return ResponseEntity
                .status(error.getStatusCode())
                .body(error);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public  ResponseEntity<ErrorResp> handleHttpMessageNotReadableException(HttpMessageNotReadableException e)
    {
        ErrorResp error = new ErrorResp();
        error.setMessage(e.getMessage());
        error.setTimestamp(LocalDateTime.now());
        

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public  ResponseEntity<ErrorResp> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e)
    {
        ErrorResp error = new ErrorResp();
        error.setMessage(e.getMessage());
        error.setTimestamp(LocalDateTime.now());
        

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResp> handleConstraintViolationException(ConstraintViolationException ex)
    {
        ErrorResp error = new ErrorResp();
        error.setMessage(ex.getMessage());
        error.setTimestamp(LocalDateTime.now());
        error.setStatusCode(HttpStatus.BAD_REQUEST);
        return ResponseEntity.status(error.getStatusCode()).body(error);
    }

    
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResp> handleDataIntegrityViolationException(DataIntegrityViolationException e)
    {
        ErrorResp error = new ErrorResp();
        error.setMessage("Email already exists.");
        error.setStatusCode(HttpStatus.CONFLICT);
        error.setTimestamp(LocalDateTime.now());

        return ResponseEntity
            .status(error.getStatusCode())
            .body(error);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResp> handleUserNotFoundException(UserNotFoundException e)
    {
        ErrorResp error = new ErrorResp();
        error.setMessage(e.getMessage());
        error.setStatusCode(HttpStatus.NOT_FOUND);
        error.setTimestamp(LocalDateTime.now());

        return ResponseEntity
            .status(error.getStatusCode())
            .body(error);
    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<ErrorResp> handleEmailAlreadyExistsException(EmailAlreadyExistsException e)
    {
        ErrorResp err = new ErrorResp();
        err.setMessage(e.getMessage());
        err.setStatusCode(HttpStatus.CONFLICT);
        err.setTimestamp(LocalDateTime.now());
        
        return ResponseEntity.status(err.getStatusCode()).body(err);

    }

    @ExceptionHandler(PhoneNumberAlreadyExistsException.class)
    public ResponseEntity<ErrorResp> handlePhoneNumberAlreadyExistsException(PhoneNumberAlreadyExistsException e)
    {
        ErrorResp error = new ErrorResp();
        error.setMessage(e.getMessage());
        error.setStatusCode(HttpStatus.CONFLICT);
        error.setTimestamp(LocalDateTime.now());

        return ResponseEntity.status(error.getStatusCode()).body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleAnyException(Exception e)
    {
       ErrorResp error = new ErrorResp();
       error.setMessage(e.getMessage());
       error.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
       error.setTimestamp(LocalDateTime.now());
       return ResponseEntity
               .status(error.getStatusCode())
               .body(e.getClass().getName());
    }

    

}
