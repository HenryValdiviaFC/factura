package com.example.factura.model;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name="tarifario")
public class Archivo implements Serializable {
    private static final long serialVersionUID = 3090356645132056363L;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id",unique = true,nullable = false)
    private Long id;

    @CsvBindByPosition(position = 0)
    @Column(name = "ciudad",nullable = false)
    private String ciudad;

    @CsvBindByPosition(position = 1)
    @Column(name = "tipoFacturacion",nullable = false)
    private String tipoFacturacion;

    @CsvBindByPosition(position = 2)
    @CsvDate
    @Column(name = "fechaInicio",columnDefinition = "TIMESTAMP",nullable = false)
    private LocalDateTime fechaInicio;

    @CsvBindByPosition(position = 3)
    @CsvDate
    @Column(name = "fechaFin",columnDefinition = "TIMESTAMP",nullable = false)
    private LocalDateTime fechaFin;

    @CsvBindByPosition(position = 4)
    @Column(name = "precio",nullable = false)
    private double precio;

    public Archivo(){

    }

    public Archivo(String ciudad, String tipoFacturacion, LocalDateTime fechaInicio, LocalDateTime fechaFin, double precio) {
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
