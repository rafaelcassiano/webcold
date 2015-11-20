package br.gov.sp.fatec.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.gov.sp.fatec.entity.Cliente;
import br.gov.sp.fatec.entity.Tecnico;
import br.gov.sp.fatec.service.ClienteService;
import br.gov.sp.fatec.service.TecnicoService;

@Controller
@RequestMapping(value = "/tecnico")
public class TecnicoController {

	@Autowired
	private TecnicoService service;

	@RequestMapping(value = "")
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("tecnico-lista");
		List<Tecnico> tecnicos = service.findAll();
		modelAndView.addObject("tecnicos", tecnicos);
		return modelAndView;
	}

	@RequestMapping(value = "/new")
	public ModelAndView iniciarCadastro() {
		ModelAndView modelAndView = new ModelAndView("tecnico-edicao");
		Tecnico tecnico = new Tecnico();
		modelAndView.addObject("tecnico", tecnico);
		return modelAndView;
	}

	@RequestMapping(value = "/edit/{id}")
	public ModelAndView iniciarCadastro(@PathVariable long id) {
		ModelAndView modelAndView = new ModelAndView("tecnico-edicao");
		Tecnico tecnico = service.getOne(id);
		modelAndView.addObject("tecnico", tecnico);
		return modelAndView;
	}

	@RequestMapping(value = "/delete/{id}")
	public ModelAndView deletar(@PathVariable long id) {
		service.delete(id);
		return new ModelAndView("redirect:/tecnico");
	}

	@RequestMapping(value = "/save")
	public ModelAndView salvar(@ModelAttribute Tecnico tecnico) {
		service.save(tecnico);
		return new ModelAndView("redirect:/tecnico");
	}
}
