package com.techforge.integraservicios.servicio;

import com.techforge.integraservicios.dao.RolDAO;
import com.techforge.integraservicios.entidad.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RolServicioImpl implements RolServicio{

    RolDAO rolDAO;

    @Autowired
    public RolServicioImpl(RolDAO rolDAO) {
        this.rolDAO = rolDAO;
    }

    @Override
    public List<Rol> findAll() {
        return rolDAO.findAll();
    }

    @Override
    public Rol findById(int id) {
        return rolDAO.findById(id);
    }

    @Override
    @Transactional
    public Rol save(Rol rol) {
        return rolDAO.save(rol);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        rolDAO.deleteById(id);
    }

}
