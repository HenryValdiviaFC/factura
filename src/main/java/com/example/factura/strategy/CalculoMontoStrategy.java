package com.example.factura.strategy;

public interface CalculoMontoStrategy {
    double calcularImporte(int cantidad, double precio);
}
