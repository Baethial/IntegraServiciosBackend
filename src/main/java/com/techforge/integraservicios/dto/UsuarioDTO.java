package com.techforge.integraservicios.dto;

import com.techforge.integraservicios.dao.RolDAO;
import com.techforge.integraservicios.entidad.Rol;
import com.techforge.integraservicios.entidad.Usuario;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class UsuarioDTO {

    private int id;
    private String nombre;
    private String apellido;
    private String correo;
    private String contrasena;
    private String estado;
    private Set<Integer> roles;

    public UsuarioDTO() {}

    public UsuarioDTO(int id, String nombre, String apellido, String correo, String contrasena, String estado, Set<Integer> roles) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contrasena = contrasena;
        this.estado = estado;
        this.roles = roles;
    }

    // Convert from Entity to DTO
    public static UsuarioDTO fromEntity(Usuario usuario) {
        return new UsuarioDTO(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getApellido(),
                usuario.getCorreo(),
                usuario.getContrasena(),
                String.valueOf(usuario.getEstado()),

                usuario.getRoles().stream().map(rol -> rol.getId()).collect(Collectors.toSet())
        );
    }

    // Convert DTO -> Entity with role conversion
    public Usuario toEntity(RolDAO rolDAO) {
        Usuario usuario = new Usuario();
        usuario.setId(this.id);
        usuario.setNombre(this.nombre);
        usuario.setApellido(this.apellido);
        usuario.setCorreo(this.correo);

        if (this.estado != null) {
            usuario.setEstado(Usuario.getEstadoFromString(this.estado)); // Convert String to Enum
        }

        // Convert role IDs to Role entities
        if (this.roles != null && !this.roles.isEmpty()) {
            Set<Rol> roleEntities = new HashSet<>();
            for (Integer roleId : this.roles) {
                Rol existingRol = rolDAO.findById(roleId);
                if (existingRol != null) {
                    roleEntities.add(existingRol);
                }
            }
            usuario.setRoles(roleEntities);
        }

        return usuario;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Set<Integer> getRoles() {
        return roles;
    }

    public void setRoles(Set<Integer> roles) {
        this.roles = roles;
    }
}
