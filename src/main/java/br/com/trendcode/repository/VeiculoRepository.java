package br.com.trendcode.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.trendcode.model.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long>{

	public List<Veiculo> findByPlacaContainingIgnoreCase(String placa);
}
