package com.example.factura.service;

import com.example.factura.model.Archivo;
import com.example.factura.model.Cliente;
import com.example.factura.model.Tarifario;
import com.example.factura.repository.TarifarioRepository;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service
public class TarifarioServiceImpl implements TarifarioService {

    @Autowired
    private TarifarioRepository repository;



    @Override
    public ResponseEntity<String> updateProcessTarifario(String file) throws IOException {

        List<Archivo> listTarifario = new ArrayList<>();
        //Obtener el archivo excel de acuerdo al periodo
        String fileName = "E:\\TarifarioExcel\\"+file;

        try (Reader reader = Files.newBufferedReader(Paths.get(fileName));)
        {
            CsvToBean<Archivo> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(Archivo.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            Iterator<Archivo> csvUserIterator = csvToBean.iterator();

            while (csvUserIterator.hasNext()) {
                Archivo csvRates = csvUserIterator.next();
                listTarifario.add(csvRates);
            }
        }

        repository.saveAll(listTarifario);

        return new ResponseEntity<String>("Tarifario actualizado con exito", HttpStatus.CREATED);
    }

    @Override
    public List<Archivo> getDataCSV(LocalDateTime startPeriod, LocalDateTime endPeriod) {
        List<Archivo> listData = new ArrayList<>();
        LocalDateTime start = startPeriod;
        LocalDateTime end = endPeriod;
        String [] cities = {"Lima","Piura", "Arequipa"};
        int priceStart;
        int priceEnd;

        // Generar para tipo CASA
        priceStart = 10;
        priceEnd = 20;

        for(String city : cities){
            double priceRandom = new Random().nextDouble();
            double price = priceStart + (priceRandom * (priceEnd - priceStart));
            Archivo archivo = new Archivo(city,"CASA",start,end,price);
            listData.add(archivo);
        }

        //Generar para tipo OFICINA

        priceStart = 15;
        priceEnd = 25;
        int rangeHourInterval = 8;
        int difStartEndTime = 7;
        int numberIntervals = 3;

        for(String city : cities){
            LocalDateTime tempStartRange = start;
            LocalDateTime tempEndRange = LocalDateTime.of(tempStartRange.getYear(),tempStartRange.getMonth(),tempStartRange.getDayOfMonth(),tempStartRange.getHour() + difStartEndTime,59,59);

            while(!tempEndRange.isAfter(end)){

                int countIntervals = 0;
                tempStartRange = LocalDateTime.of(tempStartRange.getYear(),tempStartRange.getMonth(),tempStartRange.getDayOfMonth(),0,0,0);
                tempEndRange = LocalDateTime.of(tempStartRange.getYear(),tempStartRange.getMonth(),tempStartRange.getDayOfMonth(),tempStartRange.getHour() + difStartEndTime,59,59);

                System.out.println("Inicio:"+ tempStartRange.toString());
                System.out.println("Fin: "+tempEndRange.toString());

                while( countIntervals < numberIntervals){
                    double priceRandom = new Random().nextDouble();
                    double price = priceStart + (priceRandom * (priceEnd - priceStart));
                    Archivo archivo = new Archivo(city,"OFICINA",tempStartRange,tempEndRange,price);
                    listData.add(archivo);
                    tempStartRange = tempStartRange.plusHours(rangeHourInterval);
                    tempEndRange = tempEndRange.plusHours(rangeHourInterval);
                    countIntervals++;
                }

            }



        }

        //Generar para tipo PLANA
        priceStart = 100;
        priceEnd = 200;

        for(String city : cities){
            double priceRandom = new Random().nextDouble();
            double price = priceStart + (priceRandom * (priceEnd - priceStart));
            Archivo archivo = new Archivo(city,"PLANA",start,end,price);
            listData.add(archivo);
        }
        return listData;
    }

    @Override
    public List<Archivo> getTarifarioByClientData(Cliente cliente) {

        List<Archivo> listTarifario = repository.findByCiudadAndTipoFacturacion(cliente.getCiudad(),cliente.getTipoFacturacion());
        return listTarifario;
    }

}
