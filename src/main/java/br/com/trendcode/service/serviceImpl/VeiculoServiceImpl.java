package br.com.trendcode.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.trendcode.model.Veiculo;
import br.com.trendcode.repository.VeiculoRepository;
import br.com.trendcode.service.VeiculoService;

@Service
public class VeiculoServiceImpl implements VeiculoService {

	@Autowired
	VeiculoRepository veiculoRepository;
	
	@Override
	public List<Veiculo> findAll() {
		return veiculoRepository.findAll();
	}

	@Override
	public Veiculo findById(long id) {
		return veiculoRepository.findById(id).get();
	}

	@Override
	public Veiculo save(Veiculo veiculo) {	
		return veiculoRepository.save(veiculo);
	}

	@Override
	public Veiculo delete(Veiculo veiculo) {
		veiculoRepository.delete(veiculo);
		return null;
	}

	@Override
	public List<Veiculo> find(String placa) {
		return veiculoRepository.findByPlacaContainingIgnoreCase(placa);
	}

	
}
