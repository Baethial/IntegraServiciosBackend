package com.techforge.integraservicios.servicio;

import com.techforge.integraservicios.dao.IncidenteDAO;
import com.techforge.integraservicios.entidad.Incidente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IncidenteServicioImpl implements IncidenteServicio {

    IncidenteDAO incidenteDAO;

    @Autowired
    public IncidenteServicioImpl(IncidenteDAO incidenteDAO) {
        this.incidenteDAO = incidenteDAO;
    }

    @Override
    public List<Incidente> findAll() {
        return incidenteDAO.findAll();
    }

    @Override
    public Incidente findById(int id) {
        return incidenteDAO.findById(id);
    }

    @Override
    @Transactional
    public Incidente save(Incidente incidente) {
        return incidenteDAO.save(incidente);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        incidenteDAO.deleteById(id);
    }
}
