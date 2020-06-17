package com.example.factura.template;

import com.example.factura.model.Cliente;
import com.example.factura.model.DetailsFactura;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Data
public abstract class Factura {

    protected HeaderFactura header;
    protected BodyFactura body;
    protected FooterFactura footer;
    @JsonIgnore
    protected Cliente cliente;
    @JsonIgnore
    protected List<DetailsFactura> detalles;

    public abstract void buildHeader();
    public abstract void buildBody();
    public abstract void buildFooter();

    public Factura(){}

    public Factura(Cliente cliente,List<DetailsFactura> detalles){
        this.cliente = cliente;
        this.detalles = detalles;
    }

    public final void buildFactura(){
        buildHeader();
        buildBody();
        buildFooter();
    }

}
