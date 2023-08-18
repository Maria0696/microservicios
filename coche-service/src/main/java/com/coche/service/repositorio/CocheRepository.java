package com.coche.service.repositorio;

import java.util.List;

import com.coche.service.entidades.Coche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CocheRepository extends JpaRepository<Coche, Integer>{

	List<Coche> findByUsuarioId(int usuarioId);
	
}
