package com.techforge.integraservicios.dao;

import com.techforge.integraservicios.entidad.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsuarioDAOImpl implements UsuarioDAO{

    EntityManager entityManager;

    @Autowired
    public UsuarioDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Usuario> findAll() {
        TypedQuery<Usuario> typedQuery = entityManager.createQuery("FROM Usuario", Usuario.class);
        List<Usuario> userList = typedQuery.getResultList();
        return userList;
    }

    @Override
    public Usuario findById(int id) {
        return entityManager.find(Usuario.class, id);
    }

    @Override
    public Usuario save(Usuario usuario) {
        Usuario dbUsuario = entityManager.merge(usuario); // Si el id es cero guarda, en otro caso actualiza
        return dbUsuario;
    }

    @Override
    public void deleteById(int id) {
        Usuario usuario = findById(id);
        entityManager.remove(usuario);
    }
}
