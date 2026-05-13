package com.universidad.refactoring_u11.service;

import com.universidad.refactoring_u11.domain.Pedido;
import com.universidad.refactoring_u11.domain.Producto;
import com.universidad.refactoring_u11.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired // Code Smell: inyeccion en campo
    private PedidoRepository repo;

    // Long Method: valida, calcula, notifica y persiste en un solo metodo
    public String procesarPedido(Long clienteId, String clienteNombre,
                                 String clienteEmail, String clienteTelefono,
                                 String clienteDireccion, String clienteCiudad,
                                 String clienteCodigoPostal, List<Long> productosIds,
                                 List<Integer> cantidades, String metodoPago,
                                 boolean esUrgente, String codigoDescuento) {

        // Validacion del cliente (deberia ser metodo separado)
        if (clienteId == null || clienteNombre == null
                || clienteNombre.isBlank() || clienteEmail == null
                || !clienteEmail.contains("@")) {
            return "ERROR_CLIENTE";
        }

        // Calculo de total (Long Method smell)
        double total = 0;
        for (int i = 0; i < productosIds.size(); i++) {
            Producto p = repo.findProductoById(productosIds.get(i));
            if (p == null) return "ERROR_PRODUCTO";
            total += p.getPrecio() * cantidades.get(i);
        }

        // Descuento (logica de negocio mezclada)
        if (codigoDescuento != null && codigoDescuento.equals("VIP10")) {
            total = total * 0.90;
        } else if (codigoDescuento != null && codigoDescuento.equals("NEW20")) {
            total = total * 0.80;
        }

        // Notificacion (responsabilidad ajena)
        System.out.println("Enviando email a: " + clienteEmail);
        System.out.println("Pedido urgente: " + esUrgente);

        Pedido pedido = new Pedido(clienteId, clienteNombre, total);
        return "OK_" + repo.save(pedido).getId();
    }
}