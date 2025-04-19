package com.techforge.integraservicios.servicio;

import com.techforge.integraservicios.dao.DevolucionDAO;
import com.techforge.integraservicios.entidad.Devolucion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DevolucionServicioImpl implements DevolucionServicio{

    DevolucionDAO devolucionDAO;

    @Autowired
    public DevolucionServicioImpl(DevolucionDAO devolucionDAO) {
        this.devolucionDAO = devolucionDAO;
    }

    @Override
    public List<Devolucion> findAll() {
        return devolucionDAO.findAll();
    }

    @Override
    public Devolucion findById(int id) {
        return devolucionDAO.findById(id);
    }

    @Override
    @Transactional
    public Devolucion save(Devolucion devolucion) {
        return devolucionDAO.save(devolucion);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        devolucionDAO.deleteById(id);
    }
}
