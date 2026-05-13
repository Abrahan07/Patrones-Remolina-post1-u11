package com.universidad.refactoring_u11.service;

import com.universidad.refactoring_u11.domain.DatosCliente;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class NotificacionService {

    private static final Logger log =
            LoggerFactory.getLogger(NotificacionService.class);

    public void notificarPedido(DatosCliente cliente, boolean urgente) {
        log.info("Enviando confirmacion de pedido a: {}", cliente.getEmail());
        if (urgente) {
            log.info("Pedido urgente para cliente: {}", cliente.getNombre());
        }
    }
}