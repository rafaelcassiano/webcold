package br.gov.sp.fatec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.dao.TecnicoDao;
import br.gov.sp.fatec.entity.Tecnico;

@Service
public class TecnicoService {

	@Autowired
	private TecnicoDao dao;

	public List<Tecnico> findAll() {
		return dao.findAll();
	}

	public void delete(long id) {
		dao.delete(id);
	}

	public Tecnico getOne(long id) {
		return dao.getOne(id);
	}

	public void save(Tecnico tecnico) {
		dao.save(tecnico);
	}
}
