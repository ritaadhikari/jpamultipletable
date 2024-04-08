package com.example.tables.advice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.hibernate.sql.ast.SqlTreeCreationLogger.LOGGER;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
//         Log the exception details for debugging purposes


        // Inspect the cause or message of the exception to tailor the response
        Throwable rootCause = ex.getRootCause();
        String errorMessage = "A data integrity error occurred.";
        log.error("this is a loooger from error message");

        if (rootCause != null) {
            errorMessage += " Details: " + rootCause.getMessage();
        }

        return ResponseEntity
                .status(HttpStatus.CONFLICT) // Consider appropriate HTTP status
                .body(errorMessage);
    }
}
