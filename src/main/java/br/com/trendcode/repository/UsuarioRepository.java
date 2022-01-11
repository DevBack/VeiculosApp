package br.com.trendcode.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.trendcode.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	public List<Usuario> findByNomeContainingIgnoreCase(String nome);
	public List<Usuario> findByCpf(String cpf); 
}
