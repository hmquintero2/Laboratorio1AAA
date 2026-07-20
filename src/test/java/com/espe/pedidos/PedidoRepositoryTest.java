package com.espe.pedidos;

import com.espe.pedidos.model.Pedido;
import com.espe.pedidos.repository.PedidoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class PedidoRepositoryTest {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Test
    void should_find_pedidos_by_estado() {
        // Arrange: guarda 2 pedidos PENDIENTE y 1 pedido PAGADO
        pedidoRepository.save(new Pedido("Ana", 25.0, "PENDIENTE"));
        pedidoRepository.save(new Pedido("Luis", 40.0, "PENDIENTE"));
        pedidoRepository.save(new Pedido("Marco", 15.0, "PAGADO"));

        // Act: invoca pedidoRepository.findByEstado("PENDIENTE")
        List<Pedido> resultado = pedidoRepository.findByEstado("PENDIENTE");

        // Assert: verifica que el resultado contenga exactamente 2 pedidos
        assertThat(resultado).hasSize(2);
        assertThat(resultado)
                .extracting(Pedido::getEstado)
                .containsOnly("PENDIENTE");
    }
}