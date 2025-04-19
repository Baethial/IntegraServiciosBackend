package com.techforge.integraservicios.rest;

import com.techforge.integraservicios.entidad.Devolucion;
import com.techforge.integraservicios.entidad.Prestamo;
import com.techforge.integraservicios.servicio.DevolucionServicio;
import com.techforge.integraservicios.servicio.PrestamoServicio;
import com.techforge.integraservicios.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class devolucionControladorRest {

    DevolucionServicio devolucionServicio;
    UsuarioServicio usuarioServicio;
    PrestamoServicio prestamoServicio;

    @Autowired
    public devolucionControladorRest(DevolucionServicio devolucionServicio, UsuarioServicio usuarioServicio, PrestamoServicio prestamoServicio) {
        this.devolucionServicio = devolucionServicio;
        this.usuarioServicio = usuarioServicio;
        this.prestamoServicio = prestamoServicio;
    }

    @GetMapping("/devoluciones")
    public List<Devolucion> findAll() {
        return devolucionServicio.findAll();
    }

    @GetMapping("/devoluciones/{id}")
    public Devolucion findById(@PathVariable int id) {
        return devolucionServicio.findById(id);
    }

    @PostMapping("/devoluciones")
    public Devolucion registerDevolucion(@RequestBody Devolucion devolucion) {
        devolucion.setId(0);

        // Ensure prestamo is fully loaded
        if (devolucion.getPrestamo() != null && devolucion.getPrestamo().getId() > 0) {
            Prestamo prestamo = prestamoServicio.findById(devolucion.getPrestamo().getId());
            if (prestamo == null) {
                throw new RuntimeException("Prestamo with id " + devolucion.getPrestamo().getId() + " not found.");
            }
            devolucion.setPrestamo(prestamo);
        }

//        // Ensure empleado is fully loaded
//        if (devolucion.getEmpleado() != null && devolucion.getEmpleado().getId() > 0) {
//            Usuario empleado = usuarioServicio.findById(devolucion.getEmpleado().getId());
//            if (empleado == null) {
//                throw new RuntimeException("Prestamo with id " + devolucion.getPrestamo().getId() + " not found.");
//            }
//            devolucion.setEmpleado(empleado);
//        }

        Devolucion dbDevolucion = devolucionServicio.save(devolucion);
        return dbDevolucion;
    }

    @PutMapping("/devoluciones/{id}")
    public Devolucion modificarDevolucion(@RequestBody Devolucion devolucion, @PathVariable int id) {

        Devolucion dbDevolucion = devolucionServicio.findById(id);

        // Ensure prestamo is fully loaded
        if (devolucion.getPrestamo() != null && devolucion.getPrestamo().getId() > 0) {
            Prestamo prestamo = prestamoServicio.findById(devolucion.getPrestamo().getId());
            if (prestamo == null) {
                throw new RuntimeException("Prestamo with id " + devolucion.getPrestamo().getId() + " not found.");
            }
            dbDevolucion.setPrestamo(prestamo);
        }

//        // Ensure empleado is fully loaded
//        if (devolucion.getEmpleado() != null && devolucion.getEmpleado().getId() > 0) {
//            Usuario empleado = usuarioServicio.findById(devolucion.getEmpleado().getId());
//            if (empleado == null) {
//                throw new RuntimeException("Prestamo with id " + devolucion.getPrestamo().getId() + " not found.");
//            }
//            dbDevolucion.setEmpleado(empleado);
//        }

        if (devolucion.getFechaDevolucionReal() != null) {
            dbDevolucion.setFechaDevolucionReal(devolucion.getFechaDevolucionReal());
        }

        if (devolucion.getCondicion() != null) {
            dbDevolucion.setCondicion(devolucion.getCondicion());
        }

        if ((Integer) devolucion.getDevolucionTardia() != null) {
            dbDevolucion.setDevolucionTardia(devolucion.getDevolucionTardia());
        }

        devolucionServicio.save(dbDevolucion);
        return dbDevolucion;
    }

    @DeleteMapping("/devoluciones/{id}")
    public void borrarDevolucion(@PathVariable int id) {
        Devolucion dbDevolucion = devolucionServicio.findById(id);
        if(dbDevolucion == null) {
            throw new RuntimeException("Devolucion id not found - " + id);
        }
        devolucionServicio.deleteById(id);
    }

}
