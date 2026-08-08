package com.umb.taller.domain.exception;

public class DomainException extends AppException {

    public DomainException(String message) {
        super(message);
    }

    public DomainException(String message, Throwable cause) {
        super(message, cause);
    }
}