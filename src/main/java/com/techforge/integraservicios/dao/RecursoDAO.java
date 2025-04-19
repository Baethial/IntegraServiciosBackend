package com.techforge.integraservicios.dao;

import com.techforge.integraservicios.entidad.Recurso;

import java.util.List;

public interface RecursoDAO {

    List<Recurso> findAll();

    Recurso findById(int id);

    Recurso save(Recurso recurso);

    void deleteById(int id);
}
