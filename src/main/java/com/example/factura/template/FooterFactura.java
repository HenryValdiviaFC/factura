package com.example.factura.template;

import lombok.Builder;
import lombok.ToString;

import java.time.LocalDateTime;

@Builder
@ToString
public class FooterFactura {

    @Builder.Default
    private double importeTotal = 0;
    @Builder.Default
    private float ajustes = 0;
    @Builder.Default
    private LocalDateTime fechaVencimiento = LocalDateTime.now();

    public double getImporteTotal() {
        return importeTotal + ajustes;
    }

    public void setImporteTotal(double importeTotal) {
        this.importeTotal = importeTotal;
    }
    public LocalDateTime getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDateTime fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public float getAjustes() {
        return ajustes;
    }

    public void setAjustes(float ajustes) {
        this.ajustes = ajustes;
    }


}
