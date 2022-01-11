package br.com.trendcode.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_VEICULO")
public class Veiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@javax.validation.constraints.NotNull
	private String placa;
	
	@javax.validation.constraints.NotNull
	private String chassi;
	
	@javax.validation.constraints.NotNull
	private String renavan;
	
	@javax.validation.constraints.NotNull
	private String modelo;
	
	@javax.validation.constraints.NotNull
	private String cor;
	
	@javax.validation.constraints.NotNull
	private String proprietario;
	
	@javax.validation.constraints.NotNull
	private String cnpj;
	
	
	public Veiculo() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public String getRenavan() {
		return renavan;
	}

	public void setRenavan(String renavan) {
		this.renavan = renavan;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getProprietario() {
		return proprietario;
	}

	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	
}
