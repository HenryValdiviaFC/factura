package com.example.factura.model;


import javax.persistence.*;
import java.util.List;

public class Cliente {

    private Long id;
    private String nombre;
    private String ciudad;
    private String tipoFacturacion;
    private List<Consumo> consumo;
}
