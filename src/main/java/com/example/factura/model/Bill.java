package com.example.factura.model;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="factura")
public class Bill implements Serializable {

    private static final long serialVersionUID = 3090356645132056363L;


    @Id
    @Column(name = "id",unique = true,nullable = false)
    private String id;

    @Column(name = "nroDocumento",nullable = false)
    private String nroDocumento;

    @Column(name = "periodo",nullable = false)
    private String periodo;

}
