package com.example.factura.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="cliente")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 3090356645132056363L;

    @Id
    @Column(name = "nroDocumento",unique = true,nullable = false)
    private String nroDocumento;
    @Column(name = "nombre",nullable = false)
    private String nombre;
    @Column(name = "ciudad",nullable = false)
    private String ciudad;
    @Column(name = "tipoFacturacion",nullable = false)
    private String tipoFacturacion;
    @OneToMany(mappedBy = "cliente")
    private List<Consumo> consumo;

    public Cliente(){}

    public Cliente(String nroDocumento, String nombre, String ciudad, String tipoFacturacion) {
        this.nroDocumento = nroDocumento;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.tipoFacturacion = tipoFacturacion;
        this.consumo = new ArrayList<>();
    }


    public String getId() {
        return nroDocumento;
    }

    public void setId(String id) {
        this.nroDocumento = nroDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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


    public List<Consumo> getConsumo() {
        return consumo;
    }


    public void setConsumo(List<Consumo> consumo) {
        this.consumo = consumo;
    }


    @Override
    public String toString() {
        return "Cliente{" +
                "nroDocumento='" + nroDocumento + '\'' +
                ", nombre='" + nombre + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", tipoFacturacion='" + tipoFacturacion + '\'' +
                '}';
    }
}
