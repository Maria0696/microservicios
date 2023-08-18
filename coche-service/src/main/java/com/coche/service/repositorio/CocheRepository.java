package com.coche.service.repositorio;

import com.coche.service.entidades.Coche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CocheRepository extends JpaRepository<Coche, Integer> {
    List<Coche> findByUsuarioId(int usuarioId);
}
