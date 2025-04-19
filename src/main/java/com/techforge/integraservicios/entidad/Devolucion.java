package com.techforge.integraservicios.entidad;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "devolucion")
public class Devolucion {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "id_devolucion")
    private int id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_prestamo")
    private Prestamo prestamo;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_empleado")
    private Usuario empleado;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_devolucion_real")
    private Date fechaDevolucionReal;

    enum Condicion {
        BUENO, DANADO
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "condicion")
    private Condicion condicion;

    @Column(name = "devolucion_tardia")
    private int devolucionTardia;

    public Devolucion() {
    }

    public Devolucion(Prestamo prestamo, Usuario empleado, Date fechaDevolucionReal, Condicion condicion, int devolucionTardia) {
        this.prestamo = prestamo;
        this.empleado = empleado;
        this.fechaDevolucionReal = fechaDevolucionReal;
        this.condicion = condicion;
        this.devolucionTardia = devolucionTardia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getFechaDevolucionReal() {
        return fechaDevolucionReal;
    }

    public void setFechaDevolucionReal(Date fechaDevolucionReal) {
        this.fechaDevolucionReal = fechaDevolucionReal;
    }

    public Condicion getCondicion() {
        return condicion;
    }

    public void setCondicion(Condicion condicion) {
        this.condicion = condicion;
    }

    public int getDevolucionTardia() {
        return devolucionTardia;
    }

    public void setDevolucionTardia(int devolucionTardia) {
        this.devolucionTardia = devolucionTardia;
    }

    @Override
    public String toString() {
        return "Devolucion{" +
                "id=" + id +
                ", prestamo=" + prestamo +
                ", empleado=" + empleado +
                ", fechaDevolucionReal=" + fechaDevolucionReal +
                ", condicion=" + condicion +
                ", devolucionTardia=" + devolucionTardia +
                '}';
    }
}
