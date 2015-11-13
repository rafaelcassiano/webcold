package br.gov.sp.fatec.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.gov.sp.fatec.entity.Cliente;
import br.gov.sp.fatec.entity.Pedido;
import br.gov.sp.fatec.entity.Tecnico;
import br.gov.sp.fatec.service.ClienteService;
import br.gov.sp.fatec.service.PedidoService;
import br.gov.sp.fatec.service.TecnicoService;

@Controller
@RequestMapping(value = "/pedido")
public class PedidoController {

	@Autowired
	private PedidoService service;
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private TecnicoService tecnicoService;

	@RequestMapping(value = "")
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("pedido-lista");
		List<Pedido> pedidos = service.findAll();
		modelAndView.addObject("pedidos", pedidos);
		return modelAndView;
	}

	@RequestMapping(value = "/new")
	public ModelAndView iniciarCadastro() {
		ModelAndView modelAndView = new ModelAndView("pedido-edicao");
		Pedido pedido = new Pedido();
		modelAndView.addObject("pedido", pedido);
		popularListas(modelAndView);
		return modelAndView;
	}

	@RequestMapping(value = "/edit/{id}")
	public ModelAndView iniciarCadastro(@PathVariable long id) {
		ModelAndView modelAndView = new ModelAndView("pedido-edicao");
		Pedido pedido = service.getOne(id);
		modelAndView.addObject("pedido", pedido);
		popularListas(modelAndView);
		return modelAndView;
	}

	@RequestMapping(value = "/delete/{id}")
	public ModelAndView deletar(@PathVariable long id) {
		service.delete(id);
		return new ModelAndView("redirect:/pedido");
	}

	@RequestMapping(value = "/save")
	public ModelAndView salvar(@ModelAttribute Pedido pedido) {
		service.save(pedido);
		return new ModelAndView("redirect:/pedido");
	}

	private void popularListas(ModelAndView mav) {
		List<Cliente> clientes = clienteService.findAll();
		List<Tecnico> tecnicos = tecnicoService.findAll();
		mav.addObject("clientes", clientes);
		mav.addObject("tecnicos", tecnicos);
	}
}
