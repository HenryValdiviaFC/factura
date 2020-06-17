package com.example.factura.template;


import com.example.factura.model.Cliente;
import com.example.factura.model.DetailsFactura;

import java.util.List;

public class FacturaCasa extends Factura {

    public FacturaCasa(Cliente cliente, List<DetailsFactura> detalles) {
        super(cliente, detalles);
    }

    @Override
    public void buildHeader() {
        System.out.println("Header - Building Factura Casa");
        header = HeaderFactura
                .builder()
                .tipo(cliente.getTipoFacturacion())
                .direccion(cliente.getDireccion())
                .nombreCliente(cliente.getNombre())
                .nroCliente(cliente.getId())
                .build();
    }

    @Override
    public void buildBody() {
        System.out.println("Body - Building Factura Casa");
        body = BodyFactura
                .builder()
                .detalles(detalles)
                .mantenimientos(10.0f)
                .cargosFijos(4.5f)
                .alumbrado(10.0f)
                .build();
    }


    @Override
    public void buildFooter() {
        System.out.println("Footer - Building Factura Casa");
        footer = FooterFactura
                .builder()
                .fechaVencimiento(header.getFechaEmision().plusDays(10))
                .ajustes(0.06f)
                .importeTotal(body.getSubTotal())
                .build();
    }
}
