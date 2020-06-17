package com.example.factura.template;

import com.example.factura.model.Cliente;
import com.example.factura.model.DetailsFactura;

import java.util.List;

public class FacturaPlana extends Factura {

    public FacturaPlana(Cliente cliente, List<DetailsFactura> detalles) {
        super(cliente,detalles);
    }

    @Override
    public void buildHeader() {
        System.out.println("Header - Building Factura Plana");
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
        System.out.println("Body - Building Factura Plana");
        body = BodyFactura
                .builder()
                .detalles(detalles)
                .mantenimientos(4.0f)
                .cargosFijos(2.5f)
                .alumbrado(5.0f)
                .build();
    }


    @Override
    public void buildFooter() {
        System.out.println("Footer - Building Factura Plana");
        footer = FooterFactura
                .builder()
                .fechaVencimiento(header.getFechaEmision().plusDays(10))
                .ajustes(0.04f)
                .importeTotal(body.getSubTotal())
                .build();
    }
}
