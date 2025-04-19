package com.techforge.integraservicios.dao;

import com.techforge.integraservicios.entidad.TipoRecurso;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TipoRecursoDAOImpl implements TipoRecursoDAO{

    EntityManager entityManager;

    @Autowired
    public TipoRecursoDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<TipoRecurso> findAll() {
        TypedQuery<TipoRecurso> typedQuery = entityManager.createQuery("FROM TipoRecurso ", TipoRecurso.class);
        List<TipoRecurso> recursoList = typedQuery.getResultList();
        return recursoList;
    }

    @Override
    public TipoRecurso findById(int id) {
        TipoRecurso recurso = entityManager.find(TipoRecurso.class, id);
        return recurso;
    }

    @Override
    public TipoRecurso save(TipoRecurso tipoRecurso) {
        TipoRecurso dbRecurso = entityManager.merge(tipoRecurso);
        return dbRecurso;
    }

    @Override
    public void deleteById(int id) {
        TipoRecurso dbRecurso = findById(id);
        entityManager.remove(dbRecurso);
    }
}
