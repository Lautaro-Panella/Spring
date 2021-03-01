/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repositories;

import com.example.demo.models.UsuarioModelo;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @Panella Lautaro
 */

@Repository
public interface UsuarioRepositorio extends CrudRepository<UsuarioModelo, Long> {
    
    // Métodos Save/Update, Find y Delete, son heredados de la clase CrudRepository.
    
    // Método personalizado.
    public abstract List<UsuarioModelo> findByNombre(String nombre);
    
}
