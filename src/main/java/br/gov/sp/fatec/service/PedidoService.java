package br.gov.sp.fatec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.dao.PedidoDao;
import br.gov.sp.fatec.entity.Pedido;

@Service
public class PedidoService {

	@Autowired
	private PedidoDao dao;

	public List<Pedido> findAll() {
		return dao.findAll();
	}

	public void save(Pedido pedido) {
		dao.save(pedido);
	}

	public Pedido getOne(long id) {
		return dao.getOne(id);
	}

	public void delete(long pedido) {
		dao.delete(pedido);
	}
}
