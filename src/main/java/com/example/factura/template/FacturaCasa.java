package com.example.factura.template;


import com.example.factura.model.Cliente;
import com.example.factura.model.DetailsFactura;
import com.example.factura.strategy.GenerateBillCodeStrategy;

import java.util.List;
import java.util.Random;

public class FacturaCasa extends Factura {

    public FacturaCasa(Cliente cliente, List<DetailsFactura> detalles, GenerateBillCodeStrategy strategy) {
        super(cliente, detalles,strategy);
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
                .NroRecibo(strategy.generateCode("CASA"+new Random(100).nextInt() + 1))
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
