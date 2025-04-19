package com.techforge.integraservicios.rest;

import com.techforge.integraservicios.dto.UsuarioDTO;
import com.techforge.integraservicios.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioControladorRest {

    private final UsuarioServicio usuarioServicio;

    @Autowired
    public UsuarioControladorRest(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }

    @GetMapping
    public List<UsuarioDTO> findAll() {
        return usuarioServicio.findAll();
    }

    @GetMapping("/{id}")
    public UsuarioDTO findById(@PathVariable int id) {
        return usuarioServicio.findById(id);
    }

    @PostMapping
    public UsuarioDTO addUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        return usuarioServicio.save(usuarioDTO);
    }

    @PutMapping("/{id}")
    public UsuarioDTO modifyUsuario(@RequestBody UsuarioDTO usuarioDTO, @PathVariable int id) {
        return usuarioServicio.update(id, usuarioDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable int id) {
        usuarioServicio.deleteById(id);
    }
}
