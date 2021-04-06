package com.api.rest;

import com.api.rest.model.Carro;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarroDto {
	
	private Long id;
	private String nome;
	private String modelo;
	
	public CarroDto() {}
	
	public CarroDto(String nome,String modelo) {
		this.nome=nome;
		this.modelo=modelo;
	}
	
	public CarroDto(Carro carro) {
		this.id=carro.getId();
		this.nome=carro.getNome();
		this.modelo=carro.getModelo();
	}

	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getModelo() {
		return modelo;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

}
