package com.coche.service.controlador;

import com.coche.service.entidades.Coche;
import com.coche.service.servicio.CocheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coche")
public class CocheController {
    @Autowired
    private CocheService cocheService;

    @GetMapping
    public ResponseEntity<List<Coche>> listarCoches() {
        List<Coche> coches = cocheService.getAll();
        if (coches.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(coches);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coche> obtenerCoche(@PathVariable("id") int id) {
        Coche coche = cocheService.getCocheById(id);
        if (coche == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(coche);
    }

    @PostMapping
    public ResponseEntity<Coche> guardarCoche(@RequestBody Coche coche) {
        Coche nuevoCoche = cocheService.save(coche);
        return ResponseEntity.ok(nuevoCoche);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity <List<Coche>> listarCochesPorUsuario(@PathVariable("usuarioId") int id) {
        List<Coche> coches = cocheService.byUsuarioId(id);
        if (coches.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(coches);
    }
}

