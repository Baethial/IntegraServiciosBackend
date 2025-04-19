package com.techforge.integraservicios.dao;

import com.techforge.integraservicios.entidad.TipoRecurso;

import java.util.List;

public interface TipoRecursoDAO {

    List<TipoRecurso> findAll();

    TipoRecurso findById(int id);

    TipoRecurso save(TipoRecurso tipoRecurso);

    void deleteById(int id);
}
