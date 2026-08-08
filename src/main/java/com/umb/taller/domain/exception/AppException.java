package com.umb.taller.domain.exception;

/**
 * Excepción base de la aplicación SportBooking.
 *
 * Sirve como clase padre para las excepciones propias del sistema,
 * permitiendo diferenciar los errores del dominio de otras excepciones
 * generales de Java.
 */
public abstract class AppException extends RuntimeException {

    /**
     * Crea una excepción con un mensaje descriptivo.
     *
     * @param message mensaje que explica la causa de la excepción
     */
    public AppException(String message) {
        super(message);
    }

    /**
     * Crea una excepción con un mensaje y una causa original.
     *
     * @param message mensaje que explica la causa de la excepción
     * @param cause excepción original que provocó el error
     */
    public AppException(String message, Throwable cause) {
        super(message, cause);
    }
}