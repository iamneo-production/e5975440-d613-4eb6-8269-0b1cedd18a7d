package com.hackathon.team15.medicationservice.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hackathon.team15.medicationservice.exception.ErrorInfo;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(NoSuchMedicationExistsException.class)
    public @ResponseBody ResponseEntity<?> medicationNotFoundException(NoSuchMedicationExistsException e, HttpServletRequest request)
    {
        return new ResponseEntity<>(new ErrorInfo(e.getMessage(), request.getRequestURI(),LocalDateTime.now()),HttpStatus.NOT_FOUND);
    }
}
