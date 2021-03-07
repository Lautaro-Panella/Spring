/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.services;

import com.example.demo.models.DireccionModelo;
import com.example.demo.repositories.DireccionRepositorio;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @Panella Lautaro
 */

@Service
public class DireccionServicio {
    
    @Autowired
    private DireccionRepositorio direccionRepositorio;
    
    public List<DireccionModelo> getDirecciones() {
        return (ArrayList<DireccionModelo>) direccionRepositorio.findAll(); // Encontrar todos los registros.
    }
    
    public Optional<DireccionModelo> getDireccionPorId(Long id) { // Encontrar registro por Id.
        return direccionRepositorio.findById(id);
    }
    
    public List<DireccionModelo> getDireccionesPorIdUsuario(Long id) { // Encontrar registros asociados a un Id de Usuario.
        List<DireccionModelo> direcciones = new ArrayList<>();
        for (DireccionModelo direccion : direccionRepositorio.findAll()) {
            if (Objects.equals(direccion.getUsuario().getId(), id)) {
                direcciones.add(direccion);
            }
        }
        return direcciones;
    }
    
    public List<DireccionModelo> getDireccionesPorTipo(String tipo) { // Encontrar registros por Tipo.
        return direccionRepositorio.findByTipo(tipo);
    }
    
    public DireccionModelo saveUpdateDireccion(DireccionModelo direccion) { // Guardar/Actualizar registro.
        return direccionRepositorio.save(direccion);
    }
    
    public DireccionModelo updateDireccion(DireccionModelo direccion) { // Actualizar registro.
        return direccionRepositorio.save(direccion);
    }
    
    public boolean deleteDireccion(Long id) { // Eliminar registro por Id.
        try {
            direccionRepositorio.deleteById(id);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
