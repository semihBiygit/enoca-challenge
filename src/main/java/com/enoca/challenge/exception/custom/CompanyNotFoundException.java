package com.enoca.challenge.exception.custom;

import jakarta.persistence.EntityNotFoundException;

public class CompanyNotFoundException extends EntityNotFoundException {

    public CompanyNotFoundException(String message) {
        super(message);
    }
}
