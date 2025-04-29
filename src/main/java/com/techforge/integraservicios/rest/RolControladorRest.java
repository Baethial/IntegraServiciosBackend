package com.techforge.integraservicios.rest;

import com.techforge.integraservicios.dto.RolDTO;
import com.techforge.integraservicios.entidad.Rol;
import com.techforge.integraservicios.servicio.RolServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RolControladorRest {

    RolServicio rolServicio;

    @Autowired
    public RolControladorRest(RolServicio rolServicio) {
        this.rolServicio = rolServicio;
    }

    @GetMapping("/roles")
    public List<RolDTO> findAll() {
        return rolServicio.findAll();
    }

    @GetMapping("/roles/{id}")
    public RolDTO findById(@PathVariable int id) {

        RolDTO rolDTO = rolServicio.findById(id);

        if (rolDTO == null) {
            throw new RuntimeException("Rol id not found - " + id);
        }

        return rolDTO;
    }

    @PostMapping("/roles")
    public RolDTO addRol(@RequestBody RolDTO rolDTO) {

        rolDTO.setId(0);
        RolDTO dbRol = rolServicio.save(rolDTO);
        return dbRol;
    }

    @PutMapping("/roles/{id}")
    public RolDTO modifyRol(@RequestBody RolDTO rolDTO, @PathVariable int id) {

        rolDTO.setId(id);
        RolDTO dbRol = rolServicio.update(id, rolDTO);
        return dbRol;
    }

    @DeleteMapping("/roles/{id}")
    public void delete(@PathVariable int id) {

        RolDTO dbRol = findById(id);
        rolServicio.deleteById(id);
    }
}
