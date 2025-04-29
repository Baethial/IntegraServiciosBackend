package com.techforge.integraservicios.servicio;

import com.techforge.integraservicios.dto.RolDTO;
import com.techforge.integraservicios.entidad.Rol;

import java.util.List;

public interface RolServicio {

    List<RolDTO> findAll();

    RolDTO findById(int id);

    RolDTO findByName(String name);

    // create or update
    RolDTO save(RolDTO rol);

    RolDTO update(int id, RolDTO rol);

    void deleteById(int id);
}
