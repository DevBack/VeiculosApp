package br.com.trendcode.service;

import java.util.List;

import br.com.trendcode.model.Usuario;

public interface UsuarioService {

	List<Usuario> findAll();
	Usuario findById(long id);
	Usuario save(Usuario usuario);
	Usuario delete(Usuario usuario);
	List<Usuario> find(String cpf);
	List<Usuario> findByNome(String nome);
}
