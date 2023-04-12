package com.enoca.challenge.exception;

import com.enoca.challenge.exception.custom.CompanyNotFoundException;
import com.enoca.challenge.exception.custom.EmployeeNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleEmployeeNotFoundException(EmployeeNotFoundException exception) {
        ExceptionType exceptionType = ExceptionType.EMPLOYEE_NOT_FOUND;
        return new ResponseEntity<>(ExceptionResponse.builder()
                .exceptionCode(exceptionType.getCode())
                .exceptionMessage(exception.getMessage())
                .httpStatus(exceptionType.getHttpStatus().name())
                .build(), exceptionType.getHttpStatus());
    }

    @ExceptionHandler(CompanyNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleCompanyNotFoundException(CompanyNotFoundException exception) {
        ExceptionType exceptionType = ExceptionType.COMPANY_NOT_FOUND;
        return new ResponseEntity<>(ExceptionResponse.builder()
                .exceptionCode(exceptionType.getCode())
                .exceptionMessage(exception.getMessage())
                .httpStatus(exceptionType.getHttpStatus().name())
                .build(), exceptionType.getHttpStatus());
    }

}

