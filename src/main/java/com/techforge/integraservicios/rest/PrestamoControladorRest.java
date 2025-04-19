package com.techforge.integraservicios.rest;

import com.techforge.integraservicios.entidad.Prestamo;
import com.techforge.integraservicios.entidad.Reserva;
import com.techforge.integraservicios.servicio.PrestamoServicio;
import com.techforge.integraservicios.servicio.ReservaServicio;
import com.techforge.integraservicios.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PrestamoControladorRest {

    PrestamoServicio prestamoServicio;
    ReservaServicio reservaServicio;

    UsuarioServicio usuarioServicio;

    @Autowired
    public PrestamoControladorRest(PrestamoServicio prestamoServicio, ReservaServicio reservaServicio, UsuarioServicio usuarioServicio) {
        this.prestamoServicio = prestamoServicio;
        this.reservaServicio = reservaServicio;
        this.usuarioServicio = usuarioServicio;
    }

    @GetMapping("/prestamos")
    public List<Prestamo> findAll() {
        return prestamoServicio.findAll();
    }

    @GetMapping("/prestamos/{id}")
    public Prestamo findById(@PathVariable int id) {
        Prestamo dbPrestamo = prestamoServicio.findById(id);
        if(dbPrestamo == null) {
            throw new RuntimeException("Prestamo id not found - " + id);
        }
        return dbPrestamo;
    }

    @PostMapping("/prestamos")
    public Prestamo addPrestamo(@RequestBody Prestamo prestamo) {

        // Retrieve fully loaded empleado from database
//        Usuario empleado = usuarioServicio.findById(prestamo.getEmpleado().getId());
//        if (empleado == null) {
//            throw new RuntimeException("Usuario con ID " + prestamo.getEmpleado().getId() + " no existe.");
//        }
//        prestamo.setEmpleado(empleado);

        // Retrieve fully loaded Reserva from database
        Reserva reserva = reservaServicio.findById(prestamo.getReserva().getId());
        if (reserva == null) {
            throw new RuntimeException("Reserva con ID " + prestamo.getReserva().getId() + " no existe.");
        }
        prestamo.setReserva(reserva);

        // Assign dates based on the retrieved reserva
        prestamo.setFechaPrestamo(reserva.getFechaInicio());
        prestamo.setFechaDevolucion(reserva.getFechaFin());

        // Ensure the prestamo ID is 0 (so Hibernate treats it as a new entity)
        prestamo.setId(0);

        // Save the new Prestamo entity
        return prestamoServicio.save(prestamo);
    }

    @PutMapping("/prestamos/{id}")
    public Prestamo modifyPrestamo(@RequestBody Prestamo prestamo, @PathVariable int id) {

        Prestamo dbPrestamo = prestamoServicio.findById(id);

        if(prestamo.getEmpleado() != null) {
            dbPrestamo.setEmpleado(prestamo.getEmpleado());
        }

        if(prestamo.getReserva() != null) {
            dbPrestamo.setReserva(prestamo.getReserva());
            // Assign dates based on the retrieved reserva
            dbPrestamo.setFechaPrestamo(prestamo.getReserva().getFechaInicio());
            dbPrestamo.setFechaDevolucion(prestamo.getReserva().getFechaFin());
        }

        // Ensure the prestamo ID is 0 (so Hibernate treats it as a new entity)
        prestamo.setId(id);

        // Save the new Prestamo entity
        return prestamoServicio.save(prestamo);
    }

    @DeleteMapping("/prestamos/{id}")
    public void delete(@PathVariable int id) {
        Prestamo dbPrestamo = prestamoServicio.findById(id);
        if(dbPrestamo == null) {
            throw new RuntimeException("Prestamo id not found - " + id);
        }
        prestamoServicio.deleteById(id);
    }
}
