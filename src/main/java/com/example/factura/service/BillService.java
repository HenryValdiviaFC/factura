package com.example.factura.service;

import com.example.factura.model.Bill;
import com.example.factura.template.Factura;
import org.springframework.http.ResponseEntity;

public interface BillService {
    public Bill getBillByClientIdAndPeriod(String nroDocumento, String codPeriodo);
    public ResponseEntity<Factura> buildAndCreateBuildFromClientAndPeriod(String nroDocumento, String codPeriodo);
}
