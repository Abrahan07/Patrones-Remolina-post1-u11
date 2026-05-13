package com.universidad.refactoring_u11.service;

import com.universidad.refactoring_u11.domain.CodigoDescuento;
import com.universidad.refactoring_u11.domain.DatosCliente;
import com.universidad.refactoring_u11.domain.LineaPedido;
import com.universidad.refactoring_u11.domain.Pedido;
import com.universidad.refactoring_u11.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class PedidoService {

    // Corrección: inyección por constructor
    private final PedidoRepository repo;
    private final NotificacionService notificacion;

    public PedidoService(PedidoRepository repo,
                         NotificacionService notificacion) {
        this.repo = repo;
        this.notificacion = notificacion;
    }

    // Extract Method — método principal reducido a orquestación
    public String procesarPedido(DatosCliente cliente,
                                 LineaPedido[] lineas,
                                 String metodoPago,
                                 boolean esUrgente,
                                 CodigoDescuento descuento) {
        double total = calcularTotal(lineas);
        double totalConDescuento = aplicarDescuento(total, descuento);
        notificacion.notificarPedido(cliente, esUrgente);
        return persistirPedido(cliente, totalConDescuento);
    }

    // Extract Method — calculo del total
    private double calcularTotal(LineaPedido[] lineas) {
        return Arrays.stream(lineas)
                .mapToDouble(l -> l.getPrecioUnitario() * l.getCantidad())
                .sum();
    }

    // Extract Method — aplicacion del descuento
    private double aplicarDescuento(double total, CodigoDescuento descuento) {
        return descuento != null ? total * (1 - descuento.getPorcentaje()) : total;
    }

    // Extract Method — persistencia del pedido
    private String persistirPedido(DatosCliente cliente, double total) {
        Pedido pedido = new Pedido(null, cliente.getNombre(), total);
        return "OK_" + repo.save(pedido).getId();
    }
}