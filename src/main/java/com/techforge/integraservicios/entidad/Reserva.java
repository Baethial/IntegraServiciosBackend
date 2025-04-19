package com.techforge.integraservicios.entidad;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Entity
@Table(name = "reserva")
public class Reserva {

    //
    // Attributes & Mapping
    //
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private int id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_recurso")
    private Recurso recurso;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_inicio")
    private Date fechaInicio;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_fin")
    private Date fechaFin;

    enum EstadoReserva {
        CONFIRMADA, CANCELADA
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private EstadoReserva estadoReserva;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creado_en")
    private Date fechaCreacion;

    //
    // Constructors
    //
    public Reserva() {
    }

    public Reserva(Usuario usuario, Recurso recurso, Date fechaInicio) {
        this.usuario = usuario;
        this.recurso = recurso;
        this.fechaInicio = fechaInicio;

        // Convert Date to LocalDateTime
        LocalDateTime fechaInicioLocal = fechaInicio.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();

        // Add 2 hours
        LocalDateTime fechaFinLocal = fechaInicioLocal.plusHours(2);

        // Convert back to Date
        //this.fechaFin = Date.from(fechaFinLocal.atZone(ZoneId.systemDefault()).toInstant());
        // Convert back to Timestamp
        this.fechaFin =Timestamp.valueOf(fechaFinLocal);

        this.estadoReserva = EstadoReserva.CONFIRMADA;
        this.fechaCreacion = new Timestamp(System.currentTimeMillis());
    }

    @PrePersist
    protected void onCreate() {
        if (this.fechaCreacion == null) {
            this.fechaCreacion = new Timestamp(System.currentTimeMillis());
        }
    }

    //
    // Getters & Setters
    //
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Recurso getRecurso() {
        return recurso;
    }

    public void setRecurso(Recurso recurso) {
        this.recurso = recurso;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public EstadoReserva getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(EstadoReserva estadoReserva) {
        this.estadoReserva = estadoReserva;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    //
    // toString() method
    //
    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", usuario=" + usuario +
                ", recurso=" + recurso +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", estadoReserva=" + estadoReserva +
                ", fechaCreacion=" + fechaCreacion +
                '}';
    }
}
