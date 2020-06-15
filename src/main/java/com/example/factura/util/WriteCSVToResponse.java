package com.example.factura.util;

import com.example.factura.model.Archivo;
import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.PrintWriter;
import java.util.List;

public class WriteCSVToResponse {

    public static void writeRate(PrintWriter writer, List<Archivo> tarifas) {

        try {

            ColumnPositionMappingStrategy<Archivo> mapStrategy
                    = new ColumnPositionMappingStrategy<>();

            mapStrategy.setType(Archivo.class);

            String[] columns = new String[]{"Ciudad", "tipoFacturacion", "fechaInicio","fechaFin","precio"};
            mapStrategy.setColumnMapping(columns);

            StatefulBeanToCsv<Archivo> btcsv = new StatefulBeanToCsvBuilder<Archivo>(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .withMappingStrategy(mapStrategy)
                    .withSeparator(',')
                    .build();

            btcsv.write(tarifas);

        } catch (CsvException ex) {
            System.err.println("Error mapping Bean to CSV"+ ex.getMessage());
        }
    }
}
