package com.techforge.integraservicios.entidad;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "incidente")
public class Incidente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_incidente")
    private int id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_recurso")
    private Recurso recurso;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_prestamo")
    private Prestamo prestamo;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_empleado")
    private Usuario empleado;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_reportada")
    private Date fechaReportada;

    @Column(name = "descripcion")
    private String descripcion;

    enum EstadoResolucion {
        PENDIENTE, RESUELTO
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_resolucion")
    private EstadoResolucion estadoResolucion;

    public Incidente() {
    }

    public Incidente(Recurso recurso, Prestamo prestamo, Usuario empleado, Date fechaReportada, String descripcion, EstadoResolucion estadoResolucion) {
        this.recurso = recurso;
        this.prestamo = prestamo;
        this.empleado = empleado;
        this.fechaReportada = fechaReportada;
        this.descripcion = descripcion;
        this.estadoResolucion = estadoResolucion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Recurso getRecurso() {
        return recurso;
    }

    public void setRecurso(Recurso recurso) {
        this.recurso = recurso;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    public Usuario getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Usuario empleado) {
        this.empleado = empleado;
    }

    public Date getFechaReportada() {
        return fechaReportada;
    }

    public void setFechaReportada(Date fechaReportada) {
        this.fechaReportada = fechaReportada;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public EstadoResolucion getEstadoResolucion() {
        return estadoResolucion;
    }

    public void setEstadoResolucion(EstadoResolucion estadoResolucion) {
        this.estadoResolucion = estadoResolucion;
    }

    @Override
    public String toString() {
        return "Incidente{" +
                "id=" + id +
                ", recurso=" + recurso +
                ", prestamo=" + prestamo +
                ", empleado=" + empleado +
                ", fechaReportada=" + fechaReportada +
                ", descripcion='" + descripcion + '\'' +
                ", estadoResolucion=" + estadoResolucion +
                '}';
    }

}
