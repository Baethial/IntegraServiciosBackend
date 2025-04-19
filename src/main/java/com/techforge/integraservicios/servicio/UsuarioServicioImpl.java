package com.techforge.integraservicios.servicio;

import com.techforge.integraservicios.dao.RolDAO;
import com.techforge.integraservicios.dao.UsuarioDAO;
import com.techforge.integraservicios.dto.UsuarioDTO;
import com.techforge.integraservicios.entidad.Rol;
import com.techforge.integraservicios.entidad.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UsuarioServicioImpl implements UsuarioServicio{

    private final UsuarioDAO usuarioDAO;
    private final RolDAO rolDAO;

    @Autowired
    public UsuarioServicioImpl(UsuarioDAO usuarioDAO, RolDAO rolDAO) {
        this.usuarioDAO = usuarioDAO;
        this.rolDAO = rolDAO;
    }

    @Override
    public List<UsuarioDTO> findAll() {
        return usuarioDAO.findAll().stream().map(UsuarioDTO::fromEntity).collect(Collectors.toList());
    }

    @Override
    public UsuarioDTO findById(int id) {
        Usuario usuario = usuarioDAO.findById(id);
        return UsuarioDTO.fromEntity(usuario);
    }

    @Override
    @Transactional
    public UsuarioDTO save(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioDTO.toEntity(rolDAO); // Pass rolDAO to convert role IDs to entities
        usuario.setFechaRegistro(new java.sql.Timestamp(System.currentTimeMillis())); // Set registration date
        Usuario savedUsuario = usuarioDAO.save(usuario);
        return UsuarioDTO.fromEntity(savedUsuario);
    }

    @Override
    @Transactional
    public UsuarioDTO update(int id, UsuarioDTO usuarioDTO) {
        Usuario dbUsuario = usuarioDAO.findById(id);

        // Preserve existing fields if the new ones are null
        if (usuarioDTO.getNombre() != null) dbUsuario.setNombre(usuarioDTO.getNombre());
        if (usuarioDTO.getApellido() != null) dbUsuario.setApellido(usuarioDTO.getApellido());
        if (usuarioDTO.getCorreo() != null) dbUsuario.setCorreo(usuarioDTO.getCorreo());
        if (usuarioDTO.getContrasena() != null) dbUsuario.setContrasena(usuarioDTO.getContrasena());
        if (usuarioDTO.getEstado() != null) {
            dbUsuario.setEstado(Usuario.getEstadoFromString(usuarioDTO.getEstado()));
        }
        if (usuarioDTO.getRoles() != null) {
            Set<Rol> existingRoles = new HashSet<>();
            for (Integer roleId : usuarioDTO.getRoles()) {
                Rol existingRol = rolDAO.findById(roleId);
                existingRoles.add(existingRol);
            }
            dbUsuario.setRoles(existingRoles);
        }

        Usuario updatedUsuario = usuarioDAO.save(dbUsuario);
        return UsuarioDTO.fromEntity(updatedUsuario);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        usuarioDAO.deleteById(id);
    }
}
