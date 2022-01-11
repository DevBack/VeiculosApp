package br.com.trendcode.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.trendcode.model.Usuario;
import br.com.trendcode.service.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView loginView() {
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}
	
	@RequestMapping(value = "/inserirUsuario", method = RequestMethod.GET)
	public ModelAndView getForm() {
		ModelAndView modelAndView = new ModelAndView("usuarioForm");
		modelAndView.addObject("usuario", new Usuario());
		return modelAndView;
	}
	
	@RequestMapping(value = "/usuarios", method = RequestMethod.GET)
	public ModelAndView getUsuarios() {
		ModelAndView modelAndView = new ModelAndView("usuarios");
		List<Usuario> usuarios = usuarioService.findAll();
		modelAndView.addObject("usuarios", usuarios);
		return modelAndView;
	}
	
	@RequestMapping(value = "/usuarios/{id}", method = RequestMethod.GET)
	public ModelAndView getUsuarioDetails(@PathVariable("id") long id) {
		ModelAndView modelAndView = new ModelAndView("detalhesUsuario");
		Usuario usuario = usuarioService.findById(id);
		modelAndView.addObject("usuario", usuario);
		return modelAndView;
	}
	
	@RequestMapping(value = "/salvarUsuario", method = RequestMethod.POST)
	public ModelAndView insertUsuario(@Valid Usuario usuario) {
		ModelAndView modelAndView = new ModelAndView("redirect:/usuarios");
		usuarioService.save(usuario);
		return modelAndView;
	}
	
	@RequestMapping(value = "/editarUsuario/{id}", method = RequestMethod.GET)
	public ModelAndView editUser(@PathVariable("id") long id) {
		ModelAndView modelAndView = new ModelAndView("formEditarUsuario");
		Usuario usuario = usuarioService.findById(id);
		modelAndView.addObject("usuario", usuario);
		return modelAndView;
	}
	
}