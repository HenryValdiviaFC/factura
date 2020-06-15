package com.example.factura.controller;

import com.example.factura.aspect.Authorization;
import com.example.factura.model.*;
import com.example.factura.service.ClienteService;
import com.example.factura.service.PeriodoService;
import com.example.factura.service.TarifarioService;
import com.example.factura.strategy.CalculoMontoCasa;
import com.example.factura.strategy.CalculoMontoOficina;
import com.example.factura.strategy.CalculoMontoStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/bill")
public class FacturaController {

    @Autowired
    private ClienteService serviceClient;

    @Autowired
    private TarifarioService serviceTarifario;

    @Autowired
    private PeriodoService servicePeriodo;

    @PostMapping("/{idCliente}/{codPeriodo}")
    @Authorization
    public ResponseEntity<String> buildFacturaCliente(
            @PathVariable("idCliente") String nroDocumento
            , @PathVariable("codPeriodo") String codPeriodo){

        //Obtener datos del periodo
        Periodo periodo = servicePeriodo.findPeriodoByCodigo(codPeriodo);

        // Obtener datos del cliente
        Cliente cliente = serviceClient.findClienteByID(nroDocumento);
        System.out.println("Consumos iniciales: "+cliente.getConsumo().size());

        //Tarifas de acuerdo a la info del cliente
        List<Archivo> listTarifarios = serviceTarifario.getTarifarioByClientData(cliente);
        System.out.println("Tarifas iniciales: "+listTarifarios.size());

        //Filtramos los consumos que correspondan al periodo
        List<Consumo> validConsumos = cliente.getConsumo().stream()
                .filter(
                        x -> !x.getFechaInicio().isBefore(periodo.getFechaInicio())
                                && !x.getFechaInicio().isAfter(periodo.getFechaFin())
                                && !x.getFechaFin().isBefore(periodo.getFechaInicio())
                                && !x.getFechaFin().isAfter(periodo.getFechaFin())
                        )
                .collect(Collectors.toList());

        System.out.println("Consumos filtrados: "+validConsumos.size());

        //Filtramos las tarifas que correspondan al periodo
        List<Archivo> validTarifas = listTarifarios.stream()
                .filter(
                        x -> !x.getFechaInicio().isBefore(periodo.getFechaInicio())
                        && !x.getFechaInicio().isAfter(periodo.getFechaFin())
                        && !x.getFechaFin().isBefore(periodo.getFechaInicio())
                        && !x.getFechaFin().isAfter(periodo.getFechaFin())
                        )
                .collect(Collectors.toList());

        System.out.println("Tarifas filtradas: "+validTarifas.size());

        double importeTotal = 0;

        for(Archivo tarifa :validTarifas){
            for(Consumo consumo: validConsumos){
                if(
                        consumo.getFechaInicio().isEqual(tarifa.getFechaInicio())
                        && consumo.getFechaFin().isEqual(tarifa.getFechaFin())
                  )
                {
                    importeTotal = importeTotal + (consumo.getConsumoKW() * tarifa.getPrecio());
                    break;
                }

            }
        }

        //cliente.;
        /*
        CalculoMontoStrategy strategy;

        System.out.println("generacion factura inicio");
        //Obtener lista de tarifas
        List<Tarifario> listaTarifas = serviceTarifario.findListaTarifas();

        // Obtener datos del cliente
        Cliente cliente = serviceClient.findClienteByID(idCliente);

        //determino el precio segun el consumo realizado en cada periodo
        double importeTotal = 0;

        for(Tarifario tarifa: listaTarifas){
            for(Consumo consumo: cliente.getConsumo()){
                if
                (
                        tarifa.getCiudad().equals(cliente.getCiudad()) &&
                        tarifa.getFechaInicio().isEqual(consumo.getFechaInicio()) &&
                        tarifa.getFechaFin().isEqual(consumo.getFechaFin())
                )
                {
                    if(cliente.getTipoFacturacion().equals("CASA")){

                        strategy = new CalculoMontoCasa(false,200);
                        importeTotal = importeTotal + strategy.calcularImporte(consumo.getConsumoKW(),tarifa.getPrecio());
                    }

                    else if (cliente.getTipoFacturacion().equals("OFICINA")){
                        strategy = new CalculoMontoOficina();
                        importeTotal = importeTotal + strategy.calcularImporte(consumo.getConsumoKW(),tarifa.getPrecio());
                    }

                    else if(cliente.getTipoFacturacion().equals("PLANA")){
                        strategy = new CalculoMontoCasa(true,tarifa.getPrecio());
                        importeTotal = importeTotal + strategy.calcularImporte(consumo.getConsumoKW(),tarifa.getPrecio());
                    }
                }

            }
        }

        Factura factura = new Factura();
        factura.setId(UUID.randomUUID().toString());
        factura.setFechaEmision(LocalDateTime.now());
        factura.setCliente(cliente);
        factura.setImporteTotal(importeTotal);

        return factura;

         */
        return new ResponseEntity<String>("Importe Total: "+importeTotal,HttpStatus.CREATED);
    }


}
