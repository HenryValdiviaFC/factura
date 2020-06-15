package com.example.factura.service;

import com.example.factura.exception.NotFoundException;
import com.example.factura.model.Periodo;
import com.example.factura.repository.PeriodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeriodoServiceImpl implements PeriodoService {

    @Autowired
    private PeriodoRepository repository;

    @Override
    public List<Periodo> findAllPeriodos() {
        return repository.findAll();
    }

    @Override
    public Periodo findPeriodoByCodigo(String codigo) {
        return repository
                .findById(codigo)
                .orElseThrow(() -> new NotFoundException("Periodo no existe"));
    }
}
