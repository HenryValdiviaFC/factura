package com.example.factura.service;

import com.example.factura.factory.FacturaFactory;
import com.example.factura.model.*;
import com.example.factura.repository.BillRepository;
import com.example.factura.template.Factura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BillServiceImpl implements BillService{

    @Autowired
    private BillRepository repository;

    @Autowired
    private ClienteService serviceClient;

    @Autowired
    private TarifarioService serviceTarifario;

    @Autowired
    private PeriodoService servicePeriodo;

    @Override
    public Bill getBillByClientIdAndPeriod(String nroDocumento, String codPeriodo) {
        return repository.findByNroDocumentoAndPeriodo(nroDocumento,codPeriodo);
    }

    @Override
    public ResponseEntity<Factura> buildAndCreateBuildFromClientAndPeriod(String nroDocumento, String codPeriodo) {
        //Obtener datos del periodo
        Periodo periodo = servicePeriodo.findPeriodoByCodigo(codPeriodo);

        // Obtener datos del cliente
        Cliente cliente = serviceClient.findClienteByID(nroDocumento);

        //Tarifas de acuerdo a la info del cliente
        List<Archivo> listTarifarios = serviceTarifario.getTarifarioByClientData(cliente);

        //Filtramos los consumos que correspondan al periodo
        List<Consumo> validConsumos = cliente.getConsumo().stream()
                .filter(
                        x -> !x.getFechaInicio().isBefore(periodo.getFechaInicio())
                                && !x.getFechaInicio().isAfter(periodo.getFechaFin())
                                && !x.getFechaFin().isBefore(periodo.getFechaInicio())
                                && !x.getFechaFin().isAfter(periodo.getFechaFin())
                )
                .collect(Collectors.toList());


        //Filtramos las tarifas que correspondan al periodo
        List<Archivo> validTarifas = listTarifarios.stream()
                .filter(
                        x -> !x.getFechaInicio().isBefore(periodo.getFechaInicio())
                                && !x.getFechaInicio().isAfter(periodo.getFechaFin())
                                && !x.getFechaFin().isBefore(periodo.getFechaInicio())
                                && !x.getFechaFin().isAfter(periodo.getFechaFin())
                )
                .collect(Collectors.toList());


        List<DetailsFactura> detalle = new ArrayList<>();

        for(Archivo tarifa :validTarifas){
            for(Consumo consumo: validConsumos){
                if(
                        consumo.getFechaInicio().isEqual(tarifa.getFechaInicio())
                                && consumo.getFechaFin().isEqual(tarifa.getFechaFin())
                ) {
                    DetailsFactura detalleItem = new DetailsFactura(consumo.getFechaInicio(),consumo.getFechaFin(),consumo.getConsumoKW(),tarifa.getPrecio());
                    detalle.add(detalleItem);
                    break;
                }
            }
        }

        FacturaFactory factory = new FacturaFactory(cliente,detalle);
        Factura factura = factory.getFactura(cliente.getTipoFacturacion());
        factura.buildFactura();


        return new ResponseEntity<>(factura, HttpStatus.CREATED);
    }
}
