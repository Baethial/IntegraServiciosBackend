package com.techforge.integraservicios.rest;

import com.techforge.integraservicios.dto.TipoRecursoDTO;
import com.techforge.integraservicios.entidad.TipoRecurso;
import com.techforge.integraservicios.servicio.TipoRecursoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipo-recurso")
public class TipoRecursoControladorRest {

    TipoRecursoServicio tipoRecursoServicio;

    @Autowired
    public TipoRecursoControladorRest(TipoRecursoServicio tipoRecursoServicio) {
        this.tipoRecursoServicio = tipoRecursoServicio;
    }

    @GetMapping
    public List<TipoRecursoDTO> findAll() {
        return tipoRecursoServicio.findAll();
    }

    @GetMapping("/{id}")
    public TipoRecursoDTO findById(@PathVariable int id) {
        TipoRecursoDTO dbTipoRecursoDTO = tipoRecursoServicio.findById(id);
        return dbTipoRecursoDTO;
    }

    @PostMapping
    public TipoRecursoDTO addTipoRecurso(@RequestBody TipoRecursoDTO tipoRecursoDTO) {
        tipoRecursoDTO.setId(0);
        TipoRecursoDTO dbTipoRecursoDTO = tipoRecursoServicio.save(tipoRecursoDTO);
        return dbTipoRecursoDTO;
    }

    @PutMapping("/{id}")
    public TipoRecursoDTO modifyTipoRecurso(@RequestBody TipoRecursoDTO tipoRecursoDTO, @PathVariable int id) {
        tipoRecursoDTO.setId(id);
        TipoRecursoDTO dbTipoRecursoDTO = tipoRecursoServicio.update(id, tipoRecursoDTO);
        return dbTipoRecursoDTO;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        TipoRecursoDTO dbTipoRecursoDTO = tipoRecursoServicio.findById(id);
        if(dbTipoRecursoDTO ==  null) {
            throw new RuntimeException("TipoRecurso con ID " + id + " no encontrado");
        }
        tipoRecursoServicio.deleteById(id);
    }

}
