package com.example.factura.controller;

import com.example.factura.model.Archivo;
import com.example.factura.model.Periodo;
import com.example.factura.service.PeriodoService;
import com.example.factura.service.TarifarioService;
import com.example.factura.util.WriteCSVToResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResponseErrorHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/rate")
public class TarifarioController {

    @Autowired
    private TarifarioService serviceTarifario;

    @Autowired
    private PeriodoService servicePeriodo;

    @PutMapping("/update/{codPeriodo}")
    public ResponseEntity<String> updateBatchTarifario(@PathVariable("codPeriodo") String codPeriodo){
        try {
            //Obtener datos del periodo
            Periodo periodo = servicePeriodo.findPeriodoByCodigo(codPeriodo);
            String fileName = periodo.getCodigo()+".csv";
            return serviceTarifario.updateProcessTarifario(fileName);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping(value = "/create/{codPeriodo}",produces = "text/csv")
    public void exportCSV(HttpServletResponse response,@PathVariable("codPeriodo") String codPeriodo) throws IOException {

        //Obtener datos del periodo
        Periodo periodo = servicePeriodo.findPeriodoByCodigo(codPeriodo);

        List<Archivo> listData =  serviceTarifario.getDataCSV(periodo.getFechaInicio(),periodo.getFechaFin());
        String archivo = periodo.getCodigo()+".csv";

        response.setContentType("text/csv");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + archivo + "\"");

        WriteCSVToResponse.writeRate(response.getWriter(),listData);
    }

}
