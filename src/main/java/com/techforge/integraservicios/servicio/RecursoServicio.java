package com.techforge.integraservicios.servicio;

import com.techforge.integraservicios.entidad.Recurso;

import java.util.List;

public interface RecursoServicio {

    List<Recurso> findAll();

    Recurso findById(int id);

    // create or update
    Recurso save(Recurso recurso);

    void deleteById(int id);
}
