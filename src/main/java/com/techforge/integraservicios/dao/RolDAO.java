package com.techforge.integraservicios.dao;

import com.techforge.integraservicios.entidad.Rol;

import java.util.List;

public interface RolDAO {

    List<Rol> findAll();

    Rol findById(int id);

    Rol save(Rol rol);

    void deleteById(int id);
}
