package com.example.factura.template;

import com.example.factura.model.DetailsFactura;
import lombok.Builder;
import lombok.Singular;
import lombok.ToString;

import java.util.List;

@Builder
@ToString
public class BodyFactura {

    @Builder.Default
    private float cargosFijos = 0;
    @Builder.Default
    private float mantenimientos = 0;
    @Builder.Default
    private float alumbrado = 0;
    @Builder.Default
    private double igv = 0;
    @Builder.Default
    private double subTotal = 0;
    @Singular(value = "detalle")
    private List<DetailsFactura> detalles;

    public float getCargosFijos() {
        return cargosFijos;
    }

    public void setCargosFijos(float cargosFijos) {
        this.cargosFijos = cargosFijos;
    }

    public float getMantenimientos() {
        return mantenimientos;
    }

    public void setMantenimientos(float mantenimientos) {
        this.mantenimientos = mantenimientos;
    }

    public float getAlumbrado() {
        return alumbrado;
    }

    public void setAlumbrado(float alumbrado) {
        this.alumbrado = alumbrado;
    }

    public double getIgv() {

        double importe = 0;

        for(DetailsFactura item:detalles){
            importe = importe + item.getPrecioConsumo();
        }
        return 0.18 * importe;
    }

    public double getSubTotal() {

        double importe = 0;

        for(DetailsFactura item:detalles){
            importe = importe + item.getPrecioConsumo();
        }

        return importe + getAlumbrado() + getCargosFijos() + getIgv() + getMantenimientos();
    }


    public List<DetailsFactura> getDetalle() {
        return detalles;
    }

    public void setDetalle(List<DetailsFactura> detalle) {
        this.detalles = detalle;
    }

}
