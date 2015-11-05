package br.gov.sp.fatec.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.sp.fatec.entity.Pedido;

@Repository
public interface PedidoDao extends JpaRepository<Pedido, Long> {

}
