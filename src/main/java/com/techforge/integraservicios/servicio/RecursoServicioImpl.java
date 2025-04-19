package com.techforge.integraservicios.servicio;

import com.techforge.integraservicios.dao.RecursoDAO;
import com.techforge.integraservicios.entidad.Recurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RecursoServicioImpl implements RecursoServicio{

    RecursoDAO recursoDAO;

    @Autowired
    public RecursoServicioImpl(RecursoDAO recursoDAO) {
        this.recursoDAO = recursoDAO;
    }

    @Override
    public List<Recurso> findAll() {
        return recursoDAO.findAll();
    }

    @Override
    public Recurso findById(int id) {
        return recursoDAO.findById(id);
    }

    @Transactional
    @Override
    public Recurso save(Recurso recurso) {
        return recursoDAO.save(recurso);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        recursoDAO.deleteById(id);
    }
}
