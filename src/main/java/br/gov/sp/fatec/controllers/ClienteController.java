package br.gov.sp.fatec.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.gov.sp.fatec.entity.Cliente;
import br.gov.sp.fatec.service.ClienteService;

@Controller
@RequestMapping(value = "/cliente")
public class ClienteController {

	@Autowired
	private ClienteService service;

	@RequestMapping(value = "")
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("cliente-lista");
		List<Cliente> clientes = service.findAll();
		modelAndView.addObject("clientes", clientes);
		return modelAndView;
	}

	@RequestMapping(value = "/new")
	public ModelAndView iniciarCadastro() {
		ModelAndView modelAndView = new ModelAndView("cliente-edicao");
		Cliente cliente = new Cliente();
		modelAndView.addObject("cliente", cliente);
		return modelAndView;
	}

	@RequestMapping(value = "/edit/{id}")
	public ModelAndView iniciarCadastro(@PathVariable long id) {
		ModelAndView modelAndView = new ModelAndView("cliente-edicao");
		Cliente cliente = service.getOne(id);
		modelAndView.addObject("cliente", cliente);
		return modelAndView;
	}

	@RequestMapping(value = "/delete/{id}")
	public ModelAndView deletar(@PathVariable long id) {
		service.delete(id);
		return new ModelAndView("redirect:/cliente");
	}

	@RequestMapping(value = "/save")
	public ModelAndView salvar(@ModelAttribute Cliente cliente) {
		service.save(cliente);
		return new ModelAndView("redirect:/cliente");
	}
}
