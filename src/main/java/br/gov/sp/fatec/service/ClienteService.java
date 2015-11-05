package br.gov.sp.fatec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.dao.ClienteDao;
import br.gov.sp.fatec.entity.Cliente;

@Service
public class ClienteService {
	@Autowired
	private ClienteDao dao;

	public List<Cliente> findAll() {
		return dao.findAll();
	}
}
