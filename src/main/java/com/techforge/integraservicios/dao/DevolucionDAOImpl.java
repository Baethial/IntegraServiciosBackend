package com.techforge.integraservicios.dao;

import com.techforge.integraservicios.entidad.Devolucion;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DevolucionDAOImpl implements DevolucionDAO{

    EntityManager entityManager;

    @Autowired
    public DevolucionDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Devolucion> findAll() {
        TypedQuery<Devolucion> typedQuery = entityManager.createQuery("FROM Devolucion ", Devolucion.class);
        List<Devolucion> devolucionList = typedQuery.getResultList();
        return devolucionList;
    }

    @Override
    public Devolucion findById(int id) {
        return entityManager.find(Devolucion.class, id);
    }

    @Override
    public Devolucion save(Devolucion devolucion) {
        return entityManager.merge(devolucion);
    }

    @Override
    public void deleteById(int id) {
        Devolucion dbDevolucion = entityManager.find(Devolucion.class, id);
        entityManager.remove(dbDevolucion);
    }
}
