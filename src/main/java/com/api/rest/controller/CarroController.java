package com.api.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.CarroDto;
import com.api.rest.service.CarroService;

import lombok.AllArgsConstructor;
@RestController
@RequestMapping("/carros")
@AllArgsConstructor
public class CarroController {
	
	@Autowired
	private CarroService carroService ;
	
	@GetMapping
	public List<CarroDto> findAll(){
		List<CarroDto> allCarroDto=carroService.findAll();
		return allCarroDto;
	}
	
	@PostMapping("/insercao")
	public CarroDto createDto(@RequestBody  CarroDto  carroDto) {
		CarroDto dtoCreate=carroService.create(carroDto);
		return dtoCreate;
	}
	
	@PutMapping("/{id}/atualizacao")
	public CarroDto update(@PathVariable Long id, @RequestBody CarroDto carroDto) {
		 CarroDto updateCarro=carroService.update(id, carroDto);
		 return updateCarro;
	}
	
	@DeleteMapping("/{id}/exclusao")
	public CarroDto delete(@PathVariable Long id) {
		CarroDto carroExcluido=carroService.delete(id);
		return carroExcluido;
	}

}
