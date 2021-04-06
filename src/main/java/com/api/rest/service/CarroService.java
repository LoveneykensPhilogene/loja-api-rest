package com.api.rest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.rest.dto.CarroDto;
import com.api.rest.model.Carro;
import com.api.rest.repository.CarroRepository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Service
@AllArgsConstructor
@Getter
@Setter
public class CarroService {
	@Autowired
	private CarroRepository CarroJpaRepository ;
	
	public CarroDto create(CarroDto carroDto) {
	     Carro car=CarroJpaRepository.save(createCarro(carroDto));
	     return createCarroDto(car);
	     
			}
	public List<CarroDto> findAll(){
		List<Carro> listaDeCarro= CarroJpaRepository.findAll();
		 List<CarroDto> listaDeCarroDto=new ArrayList<>();
		for(int i=0;i<listaDeCarro.size();i++) {
		
			boolean listaDto=listaDeCarroDto.add(new CarroDto(listaDeCarro.get(i)));
		}
		return listaDeCarroDto;
	}
	
	public CarroDto update(Long id, CarroDto  carroDto) {
		Optional<Carro> optionalCarro=CarroJpaRepository.findById(id);
		Carro carro=optionalCarro.get();
		carro.setModelo(carroDto.getNome());
		carro.setModelo(carroDto.getModelo());
		Carro carroUpdate=CarroJpaRepository.save(carro);
		 CarroDto carroDtoUpdate=new CarroDto(carroUpdate);
		 return carroDtoUpdate;
		
	}
	
	public CarroDto delete(Long id) {
		Optional<Carro> find=CarroJpaRepository.findById(id);
		CarroJpaRepository.deleteById(id);
		return new CarroDto(find.get());
	}
	
	
	
		public Carro createCarro(CarroDto dtoCarro) {
		Carro carro= new Carro();
		carro.setId(dtoCarro.getId());
		carro.setNome(dtoCarro.getNome());
		carro.setModelo(dtoCarro.getModelo());
	return carro;
		
	}
	
	public CarroDto createCarroDto(Carro carro) {
		CarroDto carDto=new CarroDto();
		carDto.setId(carro.getId());
		carDto.setNome(carro.getNome());
		carDto.setModelo(carro.getModelo());
		return carDto;
		
	}
	
	

}
