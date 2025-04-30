package com.techforge.integraservicios.dto;

import com.techforge.integraservicios.entidad.Rol;
import com.techforge.integraservicios.entidad.TipoRecurso;

public class TipoRecursoDTO {

    private int id;
    private String nombre;
    private String descripcion;

    public TipoRecursoDTO() {
    }

    public TipoRecursoDTO(int id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    // Convert from Entity to DTO
    public static TipoRecursoDTO fromEntity(TipoRecurso tipoRecurso) {
        return new TipoRecursoDTO(
                tipoRecurso.getId(),
                tipoRecurso.getNombre(),
                tipoRecurso.getDescripcion()
        );
    }

    // Convert from DTO to Entity
    public TipoRecurso toEntity() {
        TipoRecurso tipoRecurso = new TipoRecurso();
        tipoRecurso.setId(this.id);
        tipoRecurso.setNombre(this.nombre);
        tipoRecurso.setDescripcion(this.descripcion);
        return tipoRecurso;
    }

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
