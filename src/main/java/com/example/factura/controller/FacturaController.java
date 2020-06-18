package com.example.factura.controller;

import com.example.factura.aspect.Authorization;
import com.example.factura.service.BillService;
import com.example.factura.template.Factura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/bills")
public class FacturaController {

    @Autowired
    private BillService serviceBill;

    @PostMapping("/{idCliente}/{codPeriodo}")
    @Authorization
    public ResponseEntity<Factura> buildFacturaCliente(
            @PathVariable("idCliente") String nroDocumento
            , @PathVariable("codPeriodo") String codPeriodo){

        return serviceBill.buildAndCreateBuildFromClientAndPeriod(nroDocumento,codPeriodo);
    }


}
