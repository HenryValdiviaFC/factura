package com.example.factura.factory;

import com.example.factura.model.Cliente;
import com.example.factura.model.DetailsFactura;
import com.example.factura.strategy.BillCodeCasa;
import com.example.factura.strategy.BillCodeOficina;
import com.example.factura.strategy.BillCodePlana;
import com.example.factura.strategy.GenerateBillCodeStrategy;
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
            BillCodeCasa strategy = new BillCodeCasa();
            return new FacturaCasa(cliente,detalles,strategy);
        }

        if(tipoFacturacion.equalsIgnoreCase("OFICINA")){
            BillCodeOficina strategy = new BillCodeOficina();
            return new FacturaOficina(cliente,detalles,strategy);
        }

        if(tipoFacturacion.equalsIgnoreCase("PLANA")){
            BillCodePlana strategy = new BillCodePlana();
            return new FacturaPlana(cliente,detalles,strategy);
        }

        else
            throw new IllegalArgumentException("No existe el tipo de factura a crear");
    }
}
