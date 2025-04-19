package com.techforge.integraservicios.rest;

import com.techforge.integraservicios.entidad.Incidente;
import com.techforge.integraservicios.entidad.Prestamo;
import com.techforge.integraservicios.entidad.Recurso;
import com.techforge.integraservicios.servicio.IncidenteServicio;
import com.techforge.integraservicios.servicio.PrestamoServicio;
import com.techforge.integraservicios.servicio.RecursoServicio;
import com.techforge.integraservicios.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class IncidenteControladorRest {

    IncidenteServicio incidenteServicio;
    PrestamoServicio prestamoServicio;
    RecursoServicio recursoServicio;
    UsuarioServicio usuarioServicio;

    @Autowired
    public IncidenteControladorRest(IncidenteServicio incidenteServicio, PrestamoServicio prestamoServicio, RecursoServicio recursoServicio, UsuarioServicio usuarioServicio) {
        this.incidenteServicio = incidenteServicio;
        this.prestamoServicio = prestamoServicio;
        this.recursoServicio = recursoServicio;
        this.usuarioServicio = usuarioServicio;
    }

    @GetMapping("/incidentes")
    public List<Incidente> findAll() {
        return incidenteServicio.findAll();
    }

    @GetMapping("/incidentes/{id}")
    public Incidente findById(@PathVariable int id) {
        return incidenteServicio.findById(id);
    }

    @PostMapping("/incidentes")
    public Incidente addIncidente(@RequestBody Incidente incidente) {
        incidente.setId(0);

        // Ensure prestamo is fully loaded
        if (incidente.getPrestamo() != null && incidente.getPrestamo().getId() > 0) {
            Prestamo prestamo = prestamoServicio.findById(incidente.getPrestamo().getId());
            if (prestamo == null) {
                throw new RuntimeException("Prestamo with id " + incidente.getPrestamo().getId() + " not found.");
            }
            incidente.setPrestamo(prestamo);
        }

        // Ensure recurso is fully loaded
        if (incidente.getRecurso() != null && incidente.getRecurso().getId() > 0) {
            Recurso recurso = recursoServicio.findById(incidente.getRecurso().getId());
            if (recurso == null) {
                throw new RuntimeException("Recurso with id " + incidente.getRecurso().getId() + " not found.");
            }
            incidente.setRecurso(recurso);
        }

        // Ensure empleado is fully loaded
//        if (incidente.getEmpleado() != null && incidente.getEmpleado().getId() > 0) {
//            Usuario empleado = usuarioServicio.findById(incidente.getEmpleado().getId());
//            if (empleado == null) {
//                throw new RuntimeException("Empleado with id " + incidente.getEmpleado().getId() + " not found.");
//            }
//            incidente.setEmpleado(empleado);
//        }

        return incidenteServicio.save(incidente);
    }

    @PutMapping("/incidentes/{id}")
    public Incidente modifyIncidente(@RequestBody Incidente incidente, @PathVariable int id) {
        // Retrieve existing incidente from DB
        Incidente dbIncidente = incidenteServicio.findById(id);
        if (dbIncidente == null) {
            throw new RuntimeException("Incidente con ID " + id + " no encontrado.");
        }

        // Update only provided fields
        // Ensure prestamo is fully loaded
        if (incidente.getPrestamo() != null && incidente.getPrestamo().getId() > 0) {
            Prestamo prestamo = prestamoServicio.findById(incidente.getPrestamo().getId());
            if (prestamo == null) {
                throw new RuntimeException("Prestamo with id " + incidente.getPrestamo().getId() + " not found.");
            }
            dbIncidente.setPrestamo(prestamo);
        }

        // Ensure recurso is fully loaded
        if (incidente.getRecurso() != null && incidente.getRecurso().getId() > 0) {
            Recurso recurso = recursoServicio.findById(incidente.getRecurso().getId());
            if (recurso == null) {
                throw new RuntimeException("Recurso with id " + incidente.getRecurso().getId() + " not found.");
            }
            dbIncidente.setRecurso(recurso);
        }

        // Ensure empleado is fully loaded
//        if (incidente.getEmpleado() != null && incidente.getEmpleado().getId() > 0) {
//            Usuario empleado = usuarioServicio.findById(incidente.getEmpleado().getId());
//            if (empleado == null) {
//                throw new RuntimeException("Empleado with id " + incidente.getEmpleado().getId() + " not found.");
//            }
//            dbIncidente.setEmpleado(empleado);
//        }

        if (incidente.getFechaReportada() != null) {
            dbIncidente.setFechaReportada(incidente.getFechaReportada());
        }

        if (incidente.getDescripcion() != null) {
            dbIncidente.setDescripcion(incidente.getDescripcion());
        }

        if (incidente.getEstadoResolucion() != null) {
            dbIncidente.setEstadoResolucion(incidente.getEstadoResolucion());
        }

        // Save and return updated incidente
        return incidenteServicio.save(dbIncidente);
    }

    @DeleteMapping("/incidentes/{id}")
    public void delete(@PathVariable int id) {
        Incidente dbIncidente = incidenteServicio.findById(id);
        if(dbIncidente == null) {
            throw new RuntimeException("Incidente id not found - " + id);
        }
        incidenteServicio.deleteById(id);
    }
}
