package com.example.factura.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name="periodo")
public class Periodo implements Serializable {

    private static final long serialVersionUID = 3090356645132056363L;

    @Id
    @Column(name = "codigo",unique = true,nullable = false)
    private String codigo;

    @Column(name = "nombre",nullable = false)
    private String nombre;

    @Column(name = "fechaInicio",columnDefinition = "TIMESTAMP",nullable = false)
    private LocalDateTime fechaInicio;

    @Column(name = "fechaFin",columnDefinition = "TIMESTAMP",nullable = false)
    private LocalDateTime fechaFin;


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Periodo{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                '}';
    }
}
