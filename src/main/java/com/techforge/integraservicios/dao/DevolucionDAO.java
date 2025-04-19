package com.techforge.integraservicios.dao;

import com.techforge.integraservicios.entidad.Devolucion;

import java.util.List;

public interface DevolucionDAO {

    List<Devolucion> findAll();

    Devolucion findById(int id);

    Devolucion save(Devolucion devolucion);

    void deleteById(int id);
}
