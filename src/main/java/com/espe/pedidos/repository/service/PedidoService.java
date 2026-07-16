package com.espe.pedidos.repository.service;


import com.espe.pedidos.repository.model.Pedido;
import com.espe.pedidos.repository.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public List<Pedido> obtenerPorEstado(String estado) {
        return pedidoRepository.findByEstado(estado);
    }

    public Pedido crearPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }
}
