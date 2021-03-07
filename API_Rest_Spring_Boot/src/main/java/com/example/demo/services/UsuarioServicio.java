/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.services;

import com.example.demo.models.UsuarioModelo;
import com.example.demo.repositories.UsuarioRepositorio;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @Panella Lautaro
 */

@Service
public class UsuarioServicio {
    
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    
    public List<UsuarioModelo> getUsuarios() {
        return (ArrayList<UsuarioModelo>) usuarioRepositorio.findAll(); // Encontrar todos los registros.
    }
    
    public Optional<UsuarioModelo> getUsuarioPorId(Long id) { // Encontrar registro por Id.
        return usuarioRepositorio.findById(id);
    }
    
    public List<UsuarioModelo> getUsuariosPorNombre(String nombre) { // Encontrar registros por Nombre.
        return usuarioRepositorio.findByNombre(nombre);
    }
    
    public UsuarioModelo saveUpdateUsuario(UsuarioModelo usuario) { // Guardar/Actualizar registro.
        return usuarioRepositorio.save(usuario);
    }
    
    public UsuarioModelo updateUsuario(UsuarioModelo usuario) { // Actualizar registro.
        return usuarioRepositorio.save(usuario);
    }
    
    public boolean deleteUsuario(Long id) { // Eliminar registro por Id.
        try {
            usuarioRepositorio.deleteById(id);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
