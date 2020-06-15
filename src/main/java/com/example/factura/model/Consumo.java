package com.example.factura.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity(name = "Consumo")
@Table(name="cliente_consumo")
public class Consumo implements Serializable {

    private static final long serialVersionUID = 3090356645132056363L;

    @Id
    @Column(name = "id",unique = true,nullable = false)
    private Long id;
    @Column(name = "fechaInicio",columnDefinition = "TIMESTAMP",nullable = false)
    private LocalDateTime fechaInicio;
    @Column(name = "fechaFin",columnDefinition = "TIMESTAMP",nullable = false)
    private LocalDateTime fechaFin;
    @Column(name = "consumo",nullable = false)
    private int consumoKW;
    @ManyToOne
    @JoinColumn(name = "nro_documento")
    private Cliente cliente;

    public Consumo(){}

    public Consumo(LocalDateTime fechaInicio,LocalDateTime fechaFin,int consumoKW){
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.consumoKW = consumoKW;
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

    public int getConsumoKW() {
        return consumoKW;
    }

    public void setConsumoKW(int consumoKW) {
        this.consumoKW = consumoKW;
    }

    @Override
    public String toString() {
        return "Consumo{" +
                "fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", consumoKW=" + consumoKW +
                '}';
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


}
