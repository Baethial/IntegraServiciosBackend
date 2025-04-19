package com.techforge.integraservicios.servicio;

import com.techforge.integraservicios.entidad.Devolucion;

import java.util.List;

public interface DevolucionServicio {

    List<Devolucion> findAll();

    Devolucion findById(int id);

    Devolucion save(Devolucion devolucion);

    void deleteById(int id);
}
