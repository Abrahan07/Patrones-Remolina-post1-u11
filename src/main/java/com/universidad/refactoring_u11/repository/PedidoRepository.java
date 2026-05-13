package com.universidad.refactoring_u11.repository;

import com.universidad.refactoring_u11.domain.Pedido;
import com.universidad.refactoring_u11.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    Producto findProductoById(Long id);
}