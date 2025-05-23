package com.techforge.integraservicios.dao;

import com.techforge.integraservicios.entidad.Rol;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RolDAOImpl implements RolDAO{

    EntityManager entityManager;

    @Autowired
    public RolDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Rol> findAll() {

        TypedQuery<Rol> typedQuery = entityManager.createQuery("FROM Rol", Rol.class);

        List<Rol> userList = typedQuery.getResultList();

        return userList;
    }

    @Override
    public Rol findById(int id) {
        return entityManager.find(Rol.class, id);
    }

    @Override
    public Rol save(Rol rol) {

        Rol dbUsuario = entityManager.merge(rol); // Si el id es cero guarda, en otro caso actualiza

        return dbUsuario;
    }

    @Override
    public void deleteById(int id) {

        Rol rol = findById(id);

        entityManager.remove(rol);
    }

}
