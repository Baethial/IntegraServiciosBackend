package com.techforge.integraservicios.servicio;

import com.techforge.integraservicios.dto.TipoRecursoDTO;
import com.techforge.integraservicios.entidad.TipoRecurso;

import java.util.List;

public interface TipoRecursoServicio {

    List<TipoRecursoDTO> findAll();

    TipoRecursoDTO findById(int id);

    TipoRecursoDTO save(TipoRecursoDTO tipoRecursoDTO);

    TipoRecursoDTO update(int id, TipoRecursoDTO tipoRecursoDTO);

    void deleteById(int id);
}
