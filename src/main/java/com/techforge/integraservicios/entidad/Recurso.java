package com.techforge.integraservicios.entidad;

import jakarta.persistence.*;

@Entity
@Table(name = "recurso")
public class Recurso {

    //
    // Attributes & Mapping
    //
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recurso")
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_tipo")
    private TipoRecurso tipoRecurso;

    @Column(name = "ubicacion")
    private String ubicacion;

    enum EstadoRecurso {
        DISPONIBLE, EN_USO, EN_MANTENIMIENTO
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private EstadoRecurso estadoRecurso;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "agregado_por")
    private Usuario agregadoPor;

    //
    // Constructors
    //
    public Recurso() {
    }

    public Recurso(String nombre, TipoRecurso tipoRecurso, String ubicacion, EstadoRecurso estadoRecurso, Usuario agregadoPor) {
        this.nombre = nombre;
        this.tipoRecurso = tipoRecurso;
        this.ubicacion = ubicacion;
        this.estadoRecurso = estadoRecurso;
        this.agregadoPor = agregadoPor;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoRecurso getTipoRecurso() {
        return tipoRecurso;
    }

    public void setTipoRecurso(TipoRecurso tipoRecurso) {
        this.tipoRecurso = tipoRecurso;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public EstadoRecurso getEstadoRecurso() {
        return estadoRecurso;
    }

    public void setEstadoRecurso(EstadoRecurso estadoRecurso) {
        this.estadoRecurso = estadoRecurso;
    }

    public Usuario getAgregadoPor() {
        return agregadoPor;
    }

    public void setAgregadoPor(Usuario agregadoPor) {
        this.agregadoPor = agregadoPor;
    }

    //
    // toString() method
    //

    @Override
    public String toString() {
        return "Recurso{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", tipoRecurso=" + tipoRecurso +
                ", ubicacion='" + ubicacion + '\'' +
                ", estadoRecurso=" + estadoRecurso +
                ", usuario=" + agregadoPor +
                '}';
    }
}
