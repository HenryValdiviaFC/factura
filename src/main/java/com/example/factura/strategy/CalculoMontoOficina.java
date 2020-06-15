package com.example.factura.strategy;

public class CalculoMontoOficina implements CalculoMontoStrategy {

    @Override
    public double calcularImporte(int cantidad, double precio) {
        return cantidad * precio * 2;
    }
}
