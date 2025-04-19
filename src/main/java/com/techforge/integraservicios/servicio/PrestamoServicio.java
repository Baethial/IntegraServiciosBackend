package com.techforge.integraservicios.servicio;

import com.techforge.integraservicios.entidad.Prestamo;

import java.util.List;

public interface PrestamoServicio {

    List<Prestamo> findAll();

    Prestamo findById(int id);

    Prestamo save(Prestamo prestamo);

    void deleteById(int id);
}
