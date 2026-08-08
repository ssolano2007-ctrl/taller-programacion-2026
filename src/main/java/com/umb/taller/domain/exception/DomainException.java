package com.umb.taller.domain.exception;

/**
 * Representa los errores relacionados con las reglas
 * y operaciones del dominio de SportBooking.
 *
 * Esta clase funciona como base para excepciones más específicas
 * como validaciones, reglas de negocio y entidades no encontradas.
 */
public class DomainException extends AppException {

    /**
     * Crea una excepción de dominio con un mensaje descriptivo.
     *
     * @param message mensaje que describe el problema presentado
     */
    public DomainException(String message) {
        super(message);
    }

    /**
     * Crea una excepción de dominio indicando también su causa original.
     *
     * @param message mensaje que describe el problema presentado
     * @param cause excepción que originó el problema
     */
    public DomainException(String message, Throwable cause) {
        super(message, cause);
    }
}