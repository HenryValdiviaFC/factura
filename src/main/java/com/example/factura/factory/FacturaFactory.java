package com.example.factura.factory;

import com.example.factura.model.Cliente;
import com.example.factura.model.DetailsFactura;
import com.example.factura.template.Factura;
import com.example.factura.template.FacturaCasa;
import com.example.factura.template.FacturaOficina;
import com.example.factura.template.FacturaPlana;

import java.util.List;

public class FacturaFactory {

    private Cliente cliente;
    private List<DetailsFactura> detalles;

    public FacturaFactory (Cliente cliente, List<DetailsFactura> detalles){
        this.cliente = cliente;
        this.detalles = detalles;
    }

    public Factura getFactura(String tipoFacturacion){

        if(tipoFacturacion.equalsIgnoreCase("CASA")){
            return new FacturaCasa(cliente,detalles);
        }

        if(tipoFacturacion.equalsIgnoreCase("OFICINA")){
            return new FacturaOficina(cliente,detalles);
        }

        if(tipoFacturacion.equalsIgnoreCase("PLANA")){
            return new FacturaPlana(cliente,detalles);
        }

        else
            throw new IllegalArgumentException("No existe el tipo de factura a crear");
    }
}
