package com.techforge.integraservicios.rest;

import com.techforge.integraservicios.entidad.Recurso;
import com.techforge.integraservicios.servicio.RecursoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RecursoControladorRest {

    RecursoServicio recursoServicio;

    @Autowired
    public RecursoControladorRest(RecursoServicio recursoServicio) {
        this.recursoServicio = recursoServicio;
    }

    @GetMapping("/recursos")
    public List<Recurso> findAll() {
        return recursoServicio.findAll();
    }

    @GetMapping("/recursos/{id}")
    public Recurso findById(@PathVariable int id) {
        return recursoServicio.findById(id);
    }

    @PostMapping("/recursos")
    public Recurso addRecurso(@RequestBody Recurso recurso) {
        recurso.setId(0);
        Recurso dbRecurso = recursoServicio.save(recurso);
        return dbRecurso;
    }

    @PutMapping("/recursos/{id}")
    public Recurso modifyRecurso(@RequestBody Recurso recurso, @PathVariable int id) {
        recurso.setId(findById(id).getId());
        Recurso dbRecurso = recursoServicio.save(recurso);
        return dbRecurso;
    }

    @DeleteMapping("/recursos/{id}")
    public void delete(@PathVariable int id) {
        Recurso dbRecurso = findById(id);
        if(dbRecurso ==  null) {
            throw new RuntimeException(("Recurso id not found - " + id));
        }
        recursoServicio.deleteById(id);
    }
}
