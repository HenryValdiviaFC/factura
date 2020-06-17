package com.example.factura.model;

import java.time.LocalDateTime;

public class DetailsFactura {

    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private int consumoKW;
    private double precioUnitario;
    private double precioConsumo;

    public DetailsFactura(LocalDateTime fechaInicio, LocalDateTime fechaFin, int consumoKW, double precioUnitario) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.consumoKW = consumoKW;
        this.precioUnitario = precioUnitario;
        this.precioConsumo = 0;
    }


    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getConsumoKW() {
        return consumoKW;
    }

    public void setConsumoKW(int consumoKW) {
        this.consumoKW = consumoKW;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getPrecioConsumo() {
        return precioUnitario * consumoKW;
    }


}
