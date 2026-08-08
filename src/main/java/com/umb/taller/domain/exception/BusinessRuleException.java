package com.umb.taller.domain.exception;

/**
 * Excepción utilizada cuando una operación viola
 * una regla de negocio definida en SportBooking.
 *
 * Por ejemplo, se utiliza cuando se intenta confirmar
 * una reserva cancelada o finalizar una reserva
 * que todavía se encuentra pendiente.
 */
public class BusinessRuleException extends DomainException {

    /**
     * Crea una excepción asociada a una regla de negocio.
     *
     * @param message descripción de la regla de negocio incumplida
     */
    public BusinessRuleException(String message) {
        super(message);
    }
}