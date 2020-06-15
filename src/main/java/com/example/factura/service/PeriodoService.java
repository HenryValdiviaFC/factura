package com.example.factura.service;

import com.example.factura.model.Periodo;

import java.util.List;

public interface PeriodoService {
    List<Periodo> findAllPeriodos();
    Periodo findPeriodoByCodigo(String codigo);
}
