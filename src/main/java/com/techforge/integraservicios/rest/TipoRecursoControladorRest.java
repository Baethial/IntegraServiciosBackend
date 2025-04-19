package com.techforge.integraservicios.rest;

import com.techforge.integraservicios.entidad.TipoRecurso;
import com.techforge.integraservicios.servicio.TipoRecursoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TipoRecursoControladorRest {

    TipoRecursoServicio tipoRecursoServicio;

    @Autowired
    public TipoRecursoControladorRest(TipoRecursoServicio tipoRecursoServicio) {
        this.tipoRecursoServicio = tipoRecursoServicio;
    }

    @GetMapping("/tipo-recurso")
    public List<TipoRecurso> findAll() {
        return tipoRecursoServicio.findAll();
    }

    @GetMapping("/tipo-recurso/{id}")
    public TipoRecurso findById(@PathVariable int id) {
        TipoRecurso dbTipoRecurso = tipoRecursoServicio.findById(id);
        if(dbTipoRecurso ==  null) {
            throw new RuntimeException("TipoRecurso id not found " + id);
        }
        return dbTipoRecurso;
    }

    @PostMapping("/tipo-recurso")
    public TipoRecurso addTipoRecurso(@RequestBody TipoRecurso tipoRecurso) {
        tipoRecurso.setId(0);
        TipoRecurso dbTipoRecurso = tipoRecursoServicio.save(tipoRecurso);
        return dbTipoRecurso;
    }

    @PutMapping("/tipo-recurso/{id}")
    public TipoRecurso modifyTipoRecurso(@RequestBody TipoRecurso tipoRecurso, @PathVariable int id) {
        tipoRecurso.setId(id);
        TipoRecurso dbTipoRecurso = tipoRecursoServicio.save(tipoRecurso);
        return dbTipoRecurso;
    }

    @DeleteMapping("tipo-recurso/{id}")
    public void delete(@PathVariable int id) {
        TipoRecurso dbTipoRecurso = tipoRecursoServicio.findById(id);
        if(dbTipoRecurso ==  null) {
            throw new RuntimeException("TipoRecurso id not found " + id);
        }
        tipoRecursoServicio.deleteById(id);
    }


}
