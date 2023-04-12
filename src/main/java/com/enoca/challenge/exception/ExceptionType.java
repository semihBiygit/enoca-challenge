package com.enoca.challenge.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;


import static org.springframework.http.HttpStatus.NOT_FOUND;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ExceptionType {

    /**
     * Entity errors.
     */
    EMPLOYEE_NOT_FOUND(404, "Employee is not found", NOT_FOUND),
    COMPANY_NOT_FOUND(404, "Company is not found", NOT_FOUND);

    private int code;
    private String message;
    private HttpStatus httpStatus;
}
