package com.example.factura.template;


import java.time.LocalDateTime;
import java.util.UUID;

public class FacturaCasa extends FacturaBuilderTemplate {
    @Override
    public void buildHeader() {
        System.out.println("Header - Building Factura Casa");
        empresa = "ACME SAC";
        NroRecibo = UUID.randomUUID().toString();
        fechaEmision = LocalDateTime.now();
        tipo = "DOMICILARIO";
    }

    @Override
    public void buildBody() {
        System.out.println("Body - Building Factura Casa");
    }

    @Override
    public void buildFooter() {
        System.out.println("Footer - Building Factura Casa");
    }
}
