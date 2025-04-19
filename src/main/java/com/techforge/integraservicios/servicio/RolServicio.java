package com.techforge.integraservicios.servicio;

import com.techforge.integraservicios.entidad.Rol;

import java.util.List;

public interface RolServicio {

    List<Rol> findAll();

    Rol findById(int id);

    // create or update
    Rol save(Rol rol);

    void deleteById(int id);
}
