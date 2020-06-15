package com.example.factura.template;

import java.time.LocalDateTime;
import java.util.UUID;

public class FacturaPlana extends FacturaBuilderTemplate {

    @Override
    public void buildHeader() {
        System.out.println("Header - Building Factura Plana");
        empresa = "ACME SAC";
        NroRecibo = UUID.randomUUID().toString();
        fechaEmision = LocalDateTime.now();
        tipo = "TARIFA PLANA";
    }

    @Override
    public void buildBody() {
        System.out.println("Body - Building Factura Plana");
    }

    @Override
    public void buildFooter() {
        System.out.println("Footer - Building Factura Plana");
    }
}
