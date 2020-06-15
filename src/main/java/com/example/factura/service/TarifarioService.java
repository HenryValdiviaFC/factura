package com.example.factura.service;

import com.example.factura.model.Archivo;
import com.example.factura.model.Cliente;
import com.example.factura.model.Tarifario;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public interface TarifarioService {
    public ResponseEntity<String> updateProcessTarifario(String file) throws IOException;
    public List<Archivo> getDataCSV(LocalDateTime startPeriod, LocalDateTime endPeriod);
    public List<Archivo> getTarifarioByClientData(Cliente cliente);
}
