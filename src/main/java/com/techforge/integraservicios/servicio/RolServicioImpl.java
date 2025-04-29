package com.techforge.integraservicios.servicio;

import com.techforge.integraservicios.dao.RolDAO;
import com.techforge.integraservicios.dto.RolDTO;
import com.techforge.integraservicios.dto.UsuarioDTO;
import com.techforge.integraservicios.entidad.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RolServicioImpl implements RolServicio{

    RolDAO rolDAO;

    @Autowired
    public RolServicioImpl(RolDAO rolDAO) {
        this.rolDAO = rolDAO;
    }

    @Override
    public List<RolDTO> findAll() {

        return rolDAO.findAll().stream()
                .map(entity -> RolDTO.fromEntity(entity))
                .collect(Collectors.toList());
    }

    @Override
    public RolDTO findById(int id) {
        Rol rol = rolDAO.findById(id);
        if (rol == null) {
            throw new RuntimeException("Rol con ID " + id + " no encontrado.");
        }
        return RolDTO.fromEntity(rol);
    }

    @Override
    public RolDTO findByName(String name) {
        Rol rol = rolDAO.findByName(name);
        return RolDTO.fromEntity(rol);
    }

    @Override
    @Transactional
    public RolDTO save(RolDTO rolDTO) {
        Rol rol = rolDTO.toEntity();
        Rol savedRol = rolDAO.save(rol);
        return RolDTO.fromEntity(savedRol);
    }

    @Override
    @Transactional
    public RolDTO update(int id, RolDTO rolDTO) {

        Rol dbRol = rolDAO.findById(id);

        if (dbRol == null) {
            throw new RuntimeException("Rol con id " + id + " no encontrado.");
        }

        // Only update provided fields
        if (rolDTO.getNombre() != null) {
            dbRol.setNombre(rolDTO.getNombre());
        }

        Rol updatedRol = rolDAO.save(dbRol);
        return RolDTO.fromEntity(updatedRol);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        rolDAO.deleteById(id);
    }

}
