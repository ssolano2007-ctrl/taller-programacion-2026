package com.umb.taller.domain.exception;

/**
 * Excepción utilizada cuando los datos recibidos
 * no cumplen con las condiciones necesarias para ser válidos.
 *
 * Ejemplos de uso incluyen horarios incorrectos,
 * identificadores inválidos o información obligatoria faltante.
 */
public class ValidationException extends DomainException {

    /**
     * Crea una excepción de validación.
     *
     * @param message descripción del dato o condición inválida
     */
    public ValidationException(String message) {
        super(message);
    }
}