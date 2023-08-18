package com.coche.service.controladores;

import java.util.List;

import com.coche.service.entidades.Coche;
import com.coche.service.servicios.CocheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carro")
public class CocheController {

	@Autowired
	private CocheService cocheService;
	
	@GetMapping
	public ResponseEntity<List<Coche>> listarCarros(){
		List<Coche> coches = cocheService.getAll();
		if(coches.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(coches);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Coche> obtenerCarro(@PathVariable("id") int id){
		Coche coche = cocheService.getCarroById(id);
		if(coche == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(coche);
	}
	
	@PostMapping
	public ResponseEntity<Coche> guardarCarro(@RequestBody Coche coche){
		Coche nuevoCoche = cocheService.save(coche);
		return ResponseEntity.ok(nuevoCoche);
	}
	
	@GetMapping("/usuario/{usuarioId}")
	public ResponseEntity<List<Coche>> listarCarrosPorUsuarioId(@PathVariable("usuarioId") int id){
		List<Coche> coches = cocheService.byUsuarioId(id);
		if(coches.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(coches);
	}
}