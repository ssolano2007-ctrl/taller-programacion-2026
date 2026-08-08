package com.umb.taller.domain.pricing;

public class TarifaTenis implements PoliticaTarifa {

    @Override
    public double calcularTarifa() {
        return 30000;
    }
}