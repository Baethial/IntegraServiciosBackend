package com.techforge.integraservicios.dao;

import com.techforge.integraservicios.entidad.Reserva;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReservaDAOImpl implements ReservaDAO{

    EntityManager entityManager;

    @Autowired
    public ReservaDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Reserva> findAll() {
        TypedQuery<Reserva> typedQuery = entityManager.createQuery("FROM Reserva ", Reserva.class);
        List<Reserva> reservaList = typedQuery.getResultList();
        return reservaList;
    }

    @Override
    public Reserva findById(int id) {
        return entityManager.find(Reserva.class, id);
    }

    @Override
    public Reserva save(Reserva reserva) {
        Reserva dbReserva = entityManager.merge(reserva); // Si el id es cero guarda, en otro caso actualiza
        return dbReserva;
    }

    @Override
    public void deleteById(int id) {
        Reserva reserva = findById(id);
        entityManager.remove(reserva);
    }
}
