package com.techforge.integraservicios.servicio;

import com.techforge.integraservicios.entidad.TipoRecurso;

import java.util.List;

public interface TipoRecursoServicio {

    List<TipoRecurso> findAll();

    TipoRecurso findById(int id);

    TipoRecurso save(TipoRecurso tipoRecurso);

    void deleteById(int id);
}
