package com.example.factura.strategy;

public class CalculoMontoCasa implements  CalculoMontoStrategy{

    private boolean isPuntual;
    private double flatPrice;

    public CalculoMontoCasa(boolean isPuntual, double flatPrice){
        this.isPuntual = isPuntual;
        this.flatPrice = flatPrice;
    }

    @Override
    public double calcularImporte(int cantidad, double precio) {

        if(isPuntual)
            return flatPrice;

        else
            return cantidad * precio;
    }
}
