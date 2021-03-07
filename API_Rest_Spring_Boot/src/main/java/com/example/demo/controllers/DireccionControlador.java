/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controllers;

import com.example.demo.models.DireccionModelo;
import com.example.demo.services.DireccionServicio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @Panella Lautaro
 */

@RestController
@RequestMapping("/direccion") // Ruta principal.
public class DireccionControlador {
    
    @Autowired
    DireccionServicio direccionServicio;
    
    @GetMapping() // Al hacer una petición con la ruta principal y el método GET, el controller nos devuelve todas las direcciones.
    public List<DireccionModelo> getDirecciones() {
        return direccionServicio.getDirecciones();
    }
    
    @GetMapping(path = "/{id}") // Al hacer una petición con la ruta principal/id y el método GET, el controller nos devuelve la dirección con el Id indicado.
    public Optional<DireccionModelo> getDireccionPorId(@PathVariable("id") Long id) {
        return direccionServicio.getDireccionPorId(id);
    }
    
    @GetMapping("/consulta") // Al hacer una petición con la ruta principal/consulta?usuario=valorId y el método GET, el controller nos devuelve la/las dirección/es con el Id indicado.
    public List<DireccionModelo> getDireccionesPorIdUsuario(@RequestParam("usuario") Long id) {
        return direccionServicio.getDireccionesPorIdUsuario(id);
    }
    
    @GetMapping("/consultaTipo") // Al hacer una petición con la ruta principal/consultaTipo?tipo=valorTipo y el método GET, el controller nos devuelve la/las dirección/es con el Tipo indicado.
    public List<DireccionModelo> getDireccionesPorTipo(@RequestParam("tipo") String tipo) {
        return direccionServicio.getDireccionesPorTipo(tipo);
    }
    
    @PostMapping() // Al hacer una petición con la ruta principal y el método POST, pasando en el body, en formato JSON el objeto a guardar/actualizar, el controller guarda la dirección (si no especificamos Id), o actualiza la dirección (si especificamos Id).
    public DireccionModelo saveUpdateDireccion(@RequestBody DireccionModelo direccion) {
        return direccionServicio.saveUpdateDireccion(direccion);
    }
    
    @PutMapping() // Al hacer una petición con la ruta principal y el método PUT, pasando en el body, en formato JSON el objeto a actualizar, el controller actualiza la dirección indicada.
    public DireccionModelo updateDireccion(@RequestBody DireccionModelo direccion) {
        return direccionServicio.updateDireccion(direccion);
    }
    
    @DeleteMapping(path = "/{id}") // Al hacer una petición con la ruta principal/id y el método DELETE, el controller elimina la dirección con el Id indicado y nos devuelve un mensaje de confirmación. En caso que la dirección no exista, nos devuelve un mensaje de operación fallida.
    public String deleteDireccion(@PathVariable("id") Long id) {
        boolean eliminado = direccionServicio.deleteDireccion(id);
        if (eliminado) {
            return "Se eliminó la dirección con id: " + id;
        }
        else {
            return "No se encontró la dirección con id: " + id;
        }
    }
}
