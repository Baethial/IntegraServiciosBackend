package com.techforge.integraservicios.dao;

import com.techforge.integraservicios.entidad.Incidente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class IncidenteDAOImpl implements IncidenteDAO{

    EntityManager entityManager;

    @Autowired
    public IncidenteDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Incidente> findAll() {
        TypedQuery<Incidente> typedQuery = entityManager.createQuery("FROM Incidente ", Incidente.class);
        List<Incidente> incidenteList = typedQuery.getResultList();
        return incidenteList;
    }

    @Override
    public Incidente findById(int id) {
        return entityManager.find(Incidente.class, id);
    }

    @Override
    public Incidente save(Incidente incidente) {
        return entityManager.merge(incidente);
    }

    @Override
    public void deleteById(int id) {
        Incidente dbIncidente = findById(id);
        entityManager.remove(dbIncidente);
    }
}
