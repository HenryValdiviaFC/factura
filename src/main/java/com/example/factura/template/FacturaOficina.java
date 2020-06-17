package com.example.factura.template;

import com.example.factura.model.Cliente;
import com.example.factura.model.DetailsFactura;

import java.util.List;

public class FacturaOficina extends Factura {


    public FacturaOficina(Cliente cliente, List<DetailsFactura> detalles) {
        super(cliente,detalles);
    }

    @Override
    public void buildHeader() {
        System.out.println("Header - Building Factura Oficina");
        header = HeaderFactura
                .builder()
                .tipo(cliente.getTipoFacturacion())
                .direccion(cliente.getDireccion())
                .nombreCliente(cliente.getNombre())
                .nroCliente(cliente.getId())
                .build();

        System.out.println(header.toString());


    }

    @Override
    public void buildBody() {
        System.out.println("Body - Building Factura Oficina");
        body = BodyFactura
                .builder()
                .detalles(detalles)
                .mantenimientos(15.0f)
                .cargosFijos(9.5f)
                .alumbrado(16.0f)
                .build();
        System.out.println(body.toString());
    }

    @Override
    public void buildFooter() {
        System.out.println("Footer - Building Factura Plana");

        footer = FooterFactura
                .builder()
                .fechaVencimiento(header.getFechaEmision().plusDays(10))
                .ajustes(0.10f)
                .importeTotal(body.getSubTotal())
                .build();
    }
}
