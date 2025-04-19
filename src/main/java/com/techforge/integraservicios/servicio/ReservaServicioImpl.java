package com.techforge.integraservicios.servicio;

import com.techforge.integraservicios.dao.ReservaDAO;
import com.techforge.integraservicios.entidad.Reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReservaServicioImpl implements ReservaServicio{

    ReservaDAO reservaDAO;

    @Autowired
    public ReservaServicioImpl(ReservaDAO reservaDAO) {
        this.reservaDAO = reservaDAO;
    }

    @Override
    public List<Reserva> findAll() {
        return reservaDAO.findAll();
    }

    @Override
    public Reserva findById(int id) {
        return reservaDAO.findById(id);
    }

    @Override
    @Transactional
    public Reserva save(Reserva reserva) {
        return reservaDAO.save(reserva);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        reservaDAO.deleteById(id);
    }
}
