package com.techforge.integraservicios.servicio;

import com.techforge.integraservicios.entidad.Reserva;

import java.util.List;

public interface ReservaServicio {

    List<Reserva> findAll();

    Reserva findById(int id);

    // create or update
    Reserva save(Reserva reserva);

    void deleteById(int id);
}
