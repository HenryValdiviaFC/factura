package com.example.factura.template;

import com.example.factura.model.Cliente;
import com.example.factura.model.DetailsFactura;
import com.example.factura.strategy.GenerateBillCodeStrategy;

import java.util.List;
import java.util.Random;

public class FacturaOficina extends Factura {


    public FacturaOficina(Cliente cliente, List<DetailsFactura> detalles, GenerateBillCodeStrategy strategy) {
        super(cliente,detalles,strategy);
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
                .NroRecibo(strategy.generateCode("OFICINA"+new Random(100).nextInt() + 1))
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
