package com.techforge.integraservicios.servicio;

import com.techforge.integraservicios.entidad.Incidente;

import java.util.List;

public interface IncidenteServicio {

    List<Incidente> findAll();

    Incidente findById(int id);

    Incidente save(Incidente incidente);

    void deleteById(int id);
}
