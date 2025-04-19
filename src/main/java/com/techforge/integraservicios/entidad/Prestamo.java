package com.techforge.integraservicios.entidad;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "prestamo")
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prestamo")
    private int id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_reserva", nullable = false)
    private Reserva reserva;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_empleado", nullable = false)
    private Usuario empleado;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_prestamo", nullable = false)
    private Date fechaPrestamo;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_devolucion", nullable = false)
    private Date fechaDevolucion;

    public Prestamo() {
    }

    public Prestamo(Reserva reserva, Usuario empleado) {
        this.reserva = reserva;
        this.empleado = empleado;
        this.fechaPrestamo = reserva.getFechaInicio();
        this.fechaDevolucion = reserva.getFechaFin();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public Usuario getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Usuario usuario) {
        this.empleado = usuario;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "id=" + id +
                ", reserva=" + reserva +
                ", usuario=" + empleado +
                ", fechaPrestamo=" + fechaPrestamo +
                ", fechaDevolucion=" + fechaDevolucion +
                '}';
    }
}
