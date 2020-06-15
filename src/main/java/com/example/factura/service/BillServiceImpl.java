package com.example.factura.service;

import com.example.factura.model.Bill;
import com.example.factura.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillServiceImpl implements BillService{

    @Autowired
    private BillRepository repository;

    @Override
    public Bill getBillByClientIdAndPeriod(String nroDocumento, String codPeriodo) {
        return repository.findByNroDocumentoAndPeriodo(nroDocumento,codPeriodo);
    }
}
