package com.example.factura.model;


import java.util.Date;

public class Factura {

    private final String id;
    private final Date fechaEmision;
    private final Cliente cliente;

    private Factura(FacturaBuilder builder){
        this.id = builder.id;
        this.fechaEmision = builder.fechaEmision;
        this.cliente = builder.cliente;
    }

    public static class FacturaBuilder{
        private String id;
        private Date fechaEmision;
        private Cliente cliente;

        public FacturaBuilder id(String id){
            this.id = id;
            return this;
        }

        public FacturaBuilder fechaEmision(Date FechaEmision){
            this.fechaEmision = fechaEmision;
            return this;
        }

        public FacturaBuilder cliente(Cliente cliente){
            this.cliente = cliente;
            return this;
        }

        public Factura build(){
            return new Factura(this);
        }
    }
}
