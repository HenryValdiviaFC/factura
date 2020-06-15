package com.example.factura.model;

import java.time.LocalDateTime;
import java.util.Date;

public class Tarifario {

    private String ciudad;
    private String tipoFacturacion;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private float precio;

    public Tarifario(String ciudad,String tipoFacturacion, LocalDateTime fechaInicio, LocalDateTime fechaFin,float precio){
        this.ciudad = ciudad;
        this.tipoFacturacion = tipoFacturacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.precio = precio;
    }


    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTipoFacturacion() {
        return tipoFacturacion;
    }

    public void setTipoFacturacion(String tipoFacturacion) {
        this.tipoFacturacion = tipoFacturacion;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }


}

