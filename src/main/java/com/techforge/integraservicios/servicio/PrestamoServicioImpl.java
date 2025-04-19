package com.techforge.integraservicios.servicio;

import com.techforge.integraservicios.dao.PrestamoDAO;
import com.techforge.integraservicios.entidad.Prestamo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PrestamoServicioImpl implements PrestamoServicio{

    PrestamoDAO prestamoDAO;

    @Autowired
    public PrestamoServicioImpl(PrestamoDAO prestamoDAO) {
        this.prestamoDAO = prestamoDAO;
    }

    @Override
    public List<Prestamo> findAll() {
        return prestamoDAO.findAll();
    }

    @Override
    public Prestamo findById(int id) {
        return prestamoDAO.findById(id);
    }

    @Override
    @Transactional
    public Prestamo save(Prestamo prestamo) {
        return prestamoDAO.save(prestamo);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        prestamoDAO.deleteById(id);
    }
}
