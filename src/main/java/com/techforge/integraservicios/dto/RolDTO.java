package com.techforge.integraservicios.dto;

import com.techforge.integraservicios.entidad.Rol;

public class RolDTO {

    private int id;
    private String nombre;

    // Constructors
    public RolDTO() {}

    public RolDTO(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // Convert from Entity to DTO
    public static RolDTO fromEntity(Rol rol) {
        return new RolDTO(
                rol.getId(),
                rol.getNombre()
        );
    }

    // Convert from DTO to Entity
    public Rol toEntity() {
        Rol rol = new Rol();
        rol.setId(this.id);
        rol.setNombre(this.nombre);
        return rol;
    }

    // Getters and Setters
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
}
