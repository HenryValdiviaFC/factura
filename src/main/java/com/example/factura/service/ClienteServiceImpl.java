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
    }
}
