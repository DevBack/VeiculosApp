package br.com.trendcode.service;

import java.util.List;

import br.com.trendcode.model.Veiculo;

public interface VeiculoService {

	List<Veiculo> findAll();
	Veiculo findById(long id);
	Veiculo save(Veiculo veiculo);
	Veiculo delete(Veiculo veiculo);
	List<Veiculo> find(String placa);
}
