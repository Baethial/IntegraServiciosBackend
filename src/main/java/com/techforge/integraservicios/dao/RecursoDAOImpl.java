package com.techforge.integraservicios.dao;

import com.techforge.integraservicios.entidad.Recurso;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RecursoDAOImpl implements RecursoDAO{

    EntityManager entityManager;

    @Autowired
    public RecursoDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Recurso> findAll() {
        TypedQuery<Recurso> typedQuery = entityManager.createQuery("FROM Recurso ", Recurso.class);
        List<Recurso> recursoList = typedQuery.getResultList();
        return recursoList;
    }

    @Override
    public Recurso findById(int id) {
        return entityManager.find(Recurso.class, id);
    }

    @Override
    public Recurso save(Recurso recurso) {
        Recurso dbRecurso = entityManager.merge(recurso);
        return dbRecurso;
    }

    @Override
    public void deleteById(int id) {
        Recurso dbRecurso = findById(id);
        entityManager.remove(dbRecurso);
    }
}
