package com.techforge.integraservicios.dao;

import com.techforge.integraservicios.entidad.Reserva;

import java.util.List;

public interface ReservaDAO {

    List<Reserva> findAll();

    Reserva findById(int id);

    Reserva save(Reserva reserva);

    void deleteById(int id);
}
