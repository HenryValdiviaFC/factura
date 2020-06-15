package com.example.factura.model;


import java.time.LocalDateTime;

public class Factura {

    private  String id;
    private LocalDateTime fechaEmision;
    private  Cliente cliente;
    private double importeTotal;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDateTime fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(double importeTotal) {
        this.importeTotal = importeTotal;
    }

    /*
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
    }*/
}
