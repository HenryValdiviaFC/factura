package com.example.factura.service;

import com.example.factura.exception.NotFoundException;
import com.example.factura.model.Cliente;
import com.example.factura.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClientRepository repository;

    @Override
    public Cliente findClienteByID(String nroDocumento) {

        Cliente cliente = repository
                .findById(nroDocumento)
                .orElseThrow(() -> new NotFoundException("Cliente no existe"));

        return cliente;
        /*
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNombre("Henry Valdivia");
        cliente.setCiudad("Lima");
        cliente.setTipoFacturacion("CASA");

        List<Consumo> consumo = new ArrayList<>();

        Consumo c1 = new Consumo(LocalDateTime.now().minusMonths(1),LocalDateTime.now(),30);
        Consumo c2 = new Consumo(LocalDateTime.now(),LocalDateTime.now().plusMonths(1),30);
        Consumo c3 = new Consumo(LocalDateTime.now().plusMonths(1), LocalDateTime.now().plusMonths(2).plusMonths(1),30);

        consumo.add(c1);
        consumo.add(c2);
        consumo.add(c3);

        cliente.setConsumo(consumo);

        return cliente;
         */
    }
}
