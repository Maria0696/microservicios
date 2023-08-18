package com.coche.service.servicios;

import java.util.List;

import com.coche.service.entidades.Coche;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coche.service.repositorio.CocheRepository;

@Service
public class CocheService {

	@Autowired
	private CocheRepository cocheRepository;
	
	public List<Coche> getAll(){
		return cocheRepository.findAll();
	}
	
	public Coche getCarroById(int id) {
		return cocheRepository.findById(id).orElse(null);
	}
	
	public Coche save(Coche coche) {
		Coche nuevoCoche = cocheRepository.save(coche);
		return nuevoCoche;
	}
	
	public List<Coche> byUsuarioId(int usuarioId){
		return cocheRepository.findByUsuarioId(usuarioId);
	}
}
