package com.example.factura.factory;

import com.example.factura.exception.NotFoundException;
import com.example.factura.template.FacturaBuilderTemplate;
import com.example.factura.template.FacturaCasa;
import com.example.factura.template.FacturaOficina;
import com.example.factura.template.FacturaPlana;

public class FacturaFactory {

    public FacturaBuilderTemplate getFactura(String tipoFacturacion){

        if(tipoFacturacion.equalsIgnoreCase("CASA")){
            return new FacturaCasa();
        }

        if(tipoFacturacion.equalsIgnoreCase("OFICINA")){
            return new FacturaOficina();
        }

        if(tipoFacturacion.equalsIgnoreCase("PLANA")){
            return new FacturaPlana();
        }

        else
            throw new NotFoundException("No existe el tipo de factura a crear");
    }
}
