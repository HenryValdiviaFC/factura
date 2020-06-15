package com.example.factura.service;

import com.example.factura.model.Cliente;

public interface ClienteService {
    public Cliente findClienteByID(String nroDocumento);
}
