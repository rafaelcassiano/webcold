package br.gov.sp.fatec.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.gov.sp.fatec.entity.Pedido;
import br.gov.sp.fatec.service.PedidoService;

@Controller
@RequestMapping(value="/pedido")
public class PedidoController {

	@Autowired
	private PedidoService service;

	@RequestMapping(value = "/listar")
	public ModelAndView listOfStrategies() {
		ModelAndView modelAndView = new ModelAndView("pedido-lista");
		List<Pedido> pedidos = service.findAll();
		modelAndView.addObject("pedidos", pedidos);
		return modelAndView;
	}
}
