package com.umb.taller.domain.pricing;

public class TarifaFutbol implements PoliticaTarifa {

    @Override
    public double calcularTarifa() {
        return 50000;
    }
}