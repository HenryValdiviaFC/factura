package com.example.factura.template;

import java.time.LocalDateTime;
import java.util.UUID;

public class FacturaOficina extends FacturaBuilderTemplate {
    @Override
    public void buildHeader() {
        System.out.println("Header - Building Factura Oficina");
        empresa = "ACME SAC";
        NroRecibo = UUID.randomUUID().toString();
        fechaEmision = LocalDateTime.now();
        tipo = "OFICINA";
    }

    @Override
    public void buildBody() {
        System.out.println("Body - Building Factura Oficina");
    }

    @Override
    public void buildFooter() {
        System.out.println("Footer - Building Factura Plana");
    }
}
