package com.techforge.integraservicios.servicio;

import com.techforge.integraservicios.dao.TipoRecursoDAO;
import com.techforge.integraservicios.dto.TipoRecursoDTO;
import com.techforge.integraservicios.entidad.TipoRecurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TipoRecursoServicioImpl implements TipoRecursoServicio{

    TipoRecursoDAO tipoRecursoDAO;

    @Autowired
    public TipoRecursoServicioImpl(TipoRecursoDAO tipoRecursoDAO) {
        this.tipoRecursoDAO = tipoRecursoDAO;
    }

    @Override
    public List<TipoRecursoDTO> findAll() {
        return tipoRecursoDAO.findAll().stream().
                map(entity -> TipoRecursoDTO.fromEntity(entity)).
                collect(Collectors.toList());
    }

    @Override
    public TipoRecursoDTO findById(int id) {
        TipoRecurso tipoRecurso = tipoRecursoDAO.findById(id);
        if (tipoRecurso == null) {
            throw new RuntimeException("Tipo de recurso con ID " + id + " no encontrado.");
        }
        return TipoRecursoDTO.fromEntity(tipoRecurso);
    }

    @Override
    @Transactional
    public TipoRecursoDTO save(TipoRecursoDTO tipoRecursoDTO) {
        TipoRecurso tipoRecurso = tipoRecursoDTO.toEntity();
        TipoRecurso tipoRecursoSaved = tipoRecursoDAO.save(tipoRecurso);
        return TipoRecursoDTO.fromEntity(tipoRecursoSaved);
    }

    @Override
    @Transactional
    public TipoRecursoDTO update(int id, TipoRecursoDTO tipoRecursoDTO) {
        TipoRecurso dbTipoRecurso = tipoRecursoDAO.findById(id);

        if (dbTipoRecurso == null) {
            throw new RuntimeException("Tipo de recurso con id " + id + " no encontrado.");
        }

        // Only update provided fields
        if (tipoRecursoDTO.getNombre() != null) {
            dbTipoRecurso.setNombre(tipoRecursoDTO.getNombre());
            dbTipoRecurso.setDescripcion(tipoRecursoDTO.getDescripcion());
        }

        TipoRecurso tipoRecursoSaved = tipoRecursoDAO.save(dbTipoRecurso);
        return TipoRecursoDTO.fromEntity(tipoRecursoSaved);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        tipoRecursoDAO.deleteById(id);
    }
}
