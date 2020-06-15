package com.example.factura.repository;

import com.example.factura.model.Archivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarifarioRepository extends JpaRepository<Archivo,Long> {
    List<Archivo> findByCiudadAndTipoFacturacion(String ciudad, String tipoFacturacion);
}
