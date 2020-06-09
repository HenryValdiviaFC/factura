package com.example.factura.controller;

import com.example.factura.model.Cliente;
import com.example.factura.model.Factura;

import java.util.Date;
import java.util.UUID;

public class FacturaController {

    public Factura getFactura(int idCliente){
        //BUSCAR CLIENTE POR ID
        Cliente clienteEncontrado = new Cliente();
        //Construir Factura EN BASE AL PATRON BUILDER
        Factura factura;
        factura = new Factura.FacturaBuilder()
                  .id("Fac"+UUID.randomUUID().toString())
                  .cliente(clienteEncontrado)
                  .fechaEmision(new Date())
                  .build();
        return null;
    }
}