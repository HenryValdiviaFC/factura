package com.example.factura.template;

import lombok.Builder;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@ToString
public class HeaderFactura {

    //HEADER
    @Builder.Default
    private String empresa = "ACME SAC";
    @Builder.Default
    private String NroRecibo = UUID.randomUUID().toString();
    @Builder.Default
    private LocalDateTime fechaEmision = LocalDateTime.now();
    private String nroCliente;
    private String nombreCliente;
    private String tipo;
    private String direccion;

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getNroRecibo() {
        return NroRecibo;
    }

    public void setNroRecibo(String nroRecibo) {
        NroRecibo = nroRecibo;
    }

    public LocalDateTime getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDateTime fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getNroCliente() {
        return nroCliente;
    }

    public void setNroCliente(String nroCliente) {
        this.nroCliente = nroCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }



}
