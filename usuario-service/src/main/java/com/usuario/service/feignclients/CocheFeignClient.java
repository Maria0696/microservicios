package com.usuario.service.feignclients;

import com.usuario.service.modelos.Coche;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "coche-service",url = "http://localhost:8002")
@RequestMapping("/coche")
public interface CocheFeignClient {
    @PostMapping()
    public Coche save(@RequestBody Coche coche);

    @GetMapping("/usuario/{usuarioId}")
    public List<Coche> getCoches(@PathVariable("usuarioId") int usuarioId);
}
