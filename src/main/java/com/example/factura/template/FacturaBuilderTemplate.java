package com.example.factura.template;

import java.time.LocalDateTime;

public abstract class FacturaBuilderTemplate {

    //HEADER
    protected String empresa;
    protected String NroRecibo;
    protected LocalDateTime fechaEmision;
    protected String nroCliente;
    protected String nombreCliente;
    protected String tipo;
    protected String direccion;


    //FOOTER
    protected double importeTotal;
    protected LocalDateTime fechaVencimiento;

    public abstract void buildHeader();
    public abstract void buildBody();
    public abstract void buildFooter();

    public final void buildFactura(){
        buildHeader();
        buildBody();
        buildFooter();


    }

}
