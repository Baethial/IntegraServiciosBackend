package com.techforge.integraservicios.servicio;

import com.techforge.integraservicios.dao.TipoRecursoDAO;
import com.techforge.integraservicios.entidad.TipoRecurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TipoRecursoServicioImpl implements TipoRecursoServicio{

    TipoRecursoDAO tipoRecursoDAO;

    @Autowired
    public TipoRecursoServicioImpl(TipoRecursoDAO tipoRecursoDAO) {
        this.tipoRecursoDAO = tipoRecursoDAO;
    }

    @Override
    public List<TipoRecurso> findAll() {
        return tipoRecursoDAO.findAll();
    }

    @Override
    public TipoRecurso findById(int id) {
        return tipoRecursoDAO.findById(id);
    }

    @Override
    @Transactional
    public TipoRecurso save(TipoRecurso tipoRecurso) {
        return tipoRecursoDAO.save(tipoRecurso);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        tipoRecursoDAO.deleteById(id);
    }
}
