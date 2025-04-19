package com.techforge.integraservicios.servicio;

import com.techforge.integraservicios.dto.UsuarioDTO;

import java.util.List;

public interface UsuarioServicio {

    List<UsuarioDTO> findAll();

    UsuarioDTO findById(int id);

    UsuarioDTO save(UsuarioDTO usuarioDTO);
    UsuarioDTO update(int id, UsuarioDTO usuarioDTO);

    void deleteById(int id);
}
