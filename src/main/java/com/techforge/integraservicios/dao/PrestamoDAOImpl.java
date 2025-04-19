package com.techforge.integraservicios.dao;

import com.techforge.integraservicios.entidad.Prestamo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PrestamoDAOImpl implements PrestamoDAO{

    EntityManager entityManager;

    @Autowired
    public PrestamoDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Prestamo> findAll() {
        TypedQuery<Prestamo> typedQuery = entityManager.createQuery("FROM Prestamo ", Prestamo.class);
        List<Prestamo> prestamoList = typedQuery.getResultList();
        return prestamoList;
    }

    @Override
    public Prestamo findById(int id) {
        return entityManager.find(Prestamo.class, id);
    }

    @Override
    public Prestamo save(Prestamo prestamo) {
        Prestamo dbPrestamo = entityManager.merge(prestamo);
        return dbPrestamo;
    }

    @Override
    public void deleteById(int id) {
        Prestamo dbPrestamo = findById(id);
        entityManager.remove(dbPrestamo);
    }
}
