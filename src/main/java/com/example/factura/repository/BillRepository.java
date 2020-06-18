package com.example.factura.repository;

import com.example.factura.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<Bill,String> {
    Bill findByNroDocumentoAndPeriodo(String nroDocumento, String codPeriodo);
}
