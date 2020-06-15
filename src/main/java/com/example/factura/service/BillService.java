package com.example.factura.service;

import com.example.factura.model.Bill;

public interface BillService {
    public Bill getBillByClientIdAndPeriod(String nroDocumento, String codPeriodo);
}
