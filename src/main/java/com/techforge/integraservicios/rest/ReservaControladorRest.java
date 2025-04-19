package com.techforge.integraservicios.rest;

import com.techforge.integraservicios.entidad.Reserva;
import com.techforge.integraservicios.servicio.ReservaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReservaControladorRest {

    ReservaServicio reservaServicio;

    @Autowired
    public ReservaControladorRest(ReservaServicio reservaServicio) {
        this.reservaServicio = reservaServicio;
    }

    @GetMapping("/reservas")
    public List<Reserva> findAll() {
        return reservaServicio.findAll();
    }

    @GetMapping("/reservas/{id}")
    public Reserva findById(@PathVariable int id) {
        return  reservaServicio.findById(id);
    }

    @PostMapping("/reservas")
    public Reserva addReserva(@RequestBody Reserva reserva) {
        reserva.setId(0);
        Reserva dbReserva = reservaServicio.save(reserva);
        return dbReserva;
    }

    @PutMapping("/reservas/{id}")
    public Reserva modifyReserva(@RequestBody Reserva reserva, @PathVariable int id) {
        reserva.setId(id);
        reserva.setFechaCreacion(reservaServicio.findById(id).getFechaCreacion());
        Reserva dbReserva = reservaServicio.save(reserva);
        return dbReserva;
    }

    @DeleteMapping("/reservas/{id}")
    public void delete(@PathVariable int id) {
        Reserva dbReserva = findById(id);
        if(dbReserva == null) {
            throw new RuntimeException(("Reserva id not found - " + id));
        }
        reservaServicio.deleteById(id);
    }


}
