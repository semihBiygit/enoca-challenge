package com.enoca.challenge.exception.custom;

import jakarta.persistence.EntityNotFoundException;

public class EmployeeNotFoundException extends EntityNotFoundException {

    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
