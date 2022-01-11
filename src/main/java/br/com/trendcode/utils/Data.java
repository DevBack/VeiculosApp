package br.com.trendcode.utils;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.trendcode.model.Veiculo;
import br.com.trendcode.repository.VeiculoRepository;

@Component
public class Data {

	@Autowired
	VeiculoRepository veiculoRepository;
	
	//@PostConstruct
	public void salvarVeiculos() {
		
		List<Veiculo> veiculos = new ArrayList<>();
		
		Veiculo veiculo1 = new Veiculo();
		veiculo1.setPlaca("JFH2059");
		veiculo1.setChassi("73K272fmcAplc528273K272fmcAplc5282");
		veiculo1.setRenavan("95533480570");
		veiculo1.setModelo("CORSA HATCH 4P");
		veiculo1.setCor("PRATA");
		veiculo1.setProprietario("JOSENILDO GOMES DA SILVA LIMA");
		veiculo1.setCnpj("68290125000109");
		
		Veiculo veiculo2 = new Veiculo();
		veiculo2.setPlaca("OYR7717");
		veiculo2.setChassi("73K272fmcAplc528273K272fwfsrdlc4563");
		veiculo2.setRenavan("95533009597");
		veiculo2.setModelo("GOL G5 4P");
		veiculo2.setCor("BRANCO");
		veiculo2.setProprietario("LOCAVEL SERVIÇOS LTDA");
		veiculo2.setCnpj("63798490001881");
		
		veiculos.add(veiculo1);
		veiculos.add(veiculo2);
		
		for(Veiculo veiculo : veiculos) {
			Veiculo veiculoSalvo = veiculoRepository.save(veiculo);
			System.out.println(veiculoSalvo.getId());
		}
	}
}
