package com.techforge.integraservicios.dao;

import com.techforge.integraservicios.entidad.Incidente;

import java.util.List;

public interface IncidenteDAO {

    List<Incidente> findAll();

    Incidente findById(int id);

    Incidente save(Incidente incidente);

    void deleteById(int id);
}
