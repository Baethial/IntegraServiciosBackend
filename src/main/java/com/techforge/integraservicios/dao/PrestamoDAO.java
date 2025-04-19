package com.techforge.integraservicios.dao;

import com.techforge.integraservicios.entidad.Prestamo;

import java.util.List;

public interface PrestamoDAO {

    List<Prestamo> findAll();

    Prestamo findById(int id);

    Prestamo save(Prestamo prestamo);

    void deleteById(int id);

}
