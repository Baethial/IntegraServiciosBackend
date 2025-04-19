package com.techforge.integraservicios.dao;

import com.techforge.integraservicios.entidad.Usuario;

import java.util.List;

public interface UsuarioDAO {

    List<Usuario> findAll();

    Usuario findById(int id);

    Usuario save(Usuario usuario);

    void deleteById(int id);
}
