package br.com.trendcode.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.trendcode.model.Veiculo;
import br.com.trendcode.service.VeiculoService;

@Controller
public class VeiculoController {

	@Autowired
	VeiculoService veiculoService;
	
	@RequestMapping(value = "/veiculos", method = RequestMethod.GET)
	public ModelAndView getVeiculos() {
		ModelAndView modelAndView = new ModelAndView("veiculos");
		List<Veiculo> veiculos = veiculoService.findAll();
		modelAndView.addObject("veiculos", veiculos);
		return modelAndView;
	}
	
	@RequestMapping(value = "/veiculos/{id}", method = RequestMethod.GET)
	public ModelAndView getVeiculoDetails(@PathVariable("id") long id) {
		ModelAndView modelAndView = new ModelAndView("detalhes");
		Veiculo veiculo = veiculoService.findById(id);
		modelAndView.addObject("veiculo", veiculo);
		return modelAndView;
	}
	
	@RequestMapping(value = "/inserir", method = RequestMethod.GET)
	public ModelAndView getForm() {
		ModelAndView modelAndView = new ModelAndView("formulario");
		modelAndView.addObject("veiculo", new Veiculo());
		return modelAndView;
	}
	
	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public ModelAndView insertVeiculo(@Valid Veiculo veiculo) {
		ModelAndView modelAndView = new ModelAndView("redirect:/veiculos");
		veiculoService.save(veiculo);
		return modelAndView;
	}
	
	@RequestMapping(value = "/editar/{id}", method = RequestMethod.GET)
	public ModelAndView alterarVeiculo(@PathVariable("id") long id) {
		ModelAndView modelAndView = new ModelAndView("formularioEditar");
		Veiculo veiculo = veiculoService.findById(id);
		modelAndView.addObject("veiculo", veiculo);
		return modelAndView;
	}
	
	@RequestMapping(value = "/alterar", method = RequestMethod.POST)
	public ModelAndView alterarVeiculo(Veiculo veiculo) {
		ModelAndView modelAndView = new ModelAndView("redirect:/veiculos");
		veiculoService.save(veiculo);
		return modelAndView;
	}
	
	@RequestMapping(value = "/excluir/{id}", method = RequestMethod.GET)
	public ModelAndView excluirVeiculo(@PathVariable("id") long id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/veiculos");
		Veiculo veiculo = veiculoService.findById(id);
		veiculoService.delete(veiculo);
		return modelAndView;
	}
	
	@RequestMapping(value = "/buscar", method = RequestMethod.GET)
	public ModelAndView getVeiculo(Veiculo veiculo) {
		ModelAndView modelAndView = new ModelAndView("pesquisa");
		modelAndView.addObject("veiculo", new Veiculo());
		return modelAndView;
	}
	
	@RequestMapping(value = "/buscarVeiculo", method = RequestMethod.POST)
	public ModelAndView getVeiculoByPlaca(Veiculo veiculo) {
		ModelAndView modelAndView = new ModelAndView("pesquisa");
		List<Veiculo> veiculos;
		if(veiculo.getPlaca() == null || veiculo.getPlaca().trim().isEmpty()) {
			veiculos = veiculoService.findAll();
		}else {
			veiculos = veiculoService.find(veiculo.getPlaca());
		}
		veiculoService.findAll();
		modelAndView.addObject("veiculos", veiculos);
		return modelAndView;
	}
}
