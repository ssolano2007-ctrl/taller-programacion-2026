package com.umb.taller.domain.validation;

@FunctionalInterface
public interface Validador<T> {

    boolean validar(T valor);
}