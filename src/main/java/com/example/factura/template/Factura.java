package com.example.factura.template;

import com.example.factura.model.Cliente;
import com.example.factura.model.DetailsFactura;
import com.example.factura.strategy.GenerateBillCodeStrategy;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

import java.util.List;

@Getter
public abstract class Factura {

    protected HeaderFactura header;
    protected BodyFactura body;
    protected FooterFactura footer;
    @JsonIgnore
    protected Cliente cliente;
    @JsonIgnore
    protected List<DetailsFactura> detalles;
    @JsonIgnore
    protected GenerateBillCodeStrategy strategy;

    public abstract void buildHeader();
    public abstract void buildBody();
    public abstract void buildFooter();

    public Factura(){}

    public Factura(Cliente cliente,List<DetailsFactura> detalles,GenerateBillCodeStrategy strategy){
        this.cliente = cliente;
        this.detalles = detalles;
        this.strategy = strategy;
    }

    public final void buildFactura(){
        buildHeader();
        buildBody();
        buildFooter();
    }

}
