package br.com.trendcode.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.trendcode.model.Usuario;
import br.com.trendcode.repository.UsuarioRepository;
import br.com.trendcode.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario findById(long id) {
		return usuarioRepository.findById(id).get();
	}

	@Override
	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public Usuario delete(Usuario usuario) {
		usuarioRepository.delete(usuario);
		return null;
	}

	@Override
	public List<Usuario> find(String cpf) {
		return usuarioRepository.findByCpf(cpf);
	}

	@Override
	public List<Usuario> findByNome(String nome) {
		return usuarioRepository.findByNomeContainingIgnoreCase(nome);
	}
}
