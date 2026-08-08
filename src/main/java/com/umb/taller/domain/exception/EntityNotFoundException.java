package com.umb.taller.domain.exception;

/**
 * Excepción utilizada cuando una entidad solicitada
 * no puede ser encontrada dentro del sistema.
 *
 * Puede utilizarse, por ejemplo, cuando se intenta consultar
 * una reserva, un usuario o un espacio deportivo inexistente.
 */
public class EntityNotFoundException extends DomainException {

    /**
     * Crea la excepción indicando la entidad que no fue encontrada.
     *
     * @param message descripción de la entidad o recurso no encontrado
     */
    public EntityNotFoundException(String message) {
        super(message);
    }
}