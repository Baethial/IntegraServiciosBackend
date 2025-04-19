package com.techforge.integraservicios.rest;

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
    public List<Rol> findAll() {
        return rolServicio.findAll();
    }

    @GetMapping("/roles/{id}")
    public Rol findById(@PathVariable int id) {

        Rol rol = rolServicio.findById(id);

        if (rol == null) {
            throw new RuntimeException("Rol id not found - " + id);
        }

        return rol;
    }

    @PostMapping("/roles")
    public Rol addUsuario(@RequestBody Rol rol) {

        rol.setId(0);
        Rol dbRol = rolServicio.save(rol);
        return dbRol;
    }

    @PutMapping("/roles/{id}")
    public Rol modifyUsuario(@RequestBody Rol rol, @PathVariable int id) {

        rol.setId(id);
        Rol dbRol = rolServicio.save(rol);
        return dbRol;
    }

    @DeleteMapping("/roles/{id}")
    public void delete(@PathVariable int id) {

        Rol dbRol = findById(id);

        if (dbRol == null) {
            throw new RuntimeException(("Rol id not found - " + id));
        }
        rolServicio.deleteById(id);
    }
}
