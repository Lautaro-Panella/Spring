/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controllers;

import com.example.demo.models.UsuarioModelo;
import com.example.demo.services.UsuarioServicio;
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

/** 
 * Para testear el correcto funcionamiento de la API Rest usaremos la herramienta PostMan para realizar peticiones HTTP, 
 * y si bien los métodos Save, Update y Delete podrían ser de tipo Void, haremos que retornen los objetos 
 * Guardados/Actualizados o un mensaje para el caso de los Eliminados, para visualizarlos en el panel de respuesta de PostMan.
 */

@RestController
@RequestMapping("/usuario") // Ruta principal.
public class UsuarioControlador {
    
    @Autowired
    UsuarioServicio usuarioServicio;
    
    @GetMapping() // Al hacer una petición con la ruta principal y el método GET, el controller nos devuelve todos los usuarios.
    public List<UsuarioModelo> getUsuarios() {
        return usuarioServicio.getUsuarios();
    }
    
    @GetMapping(path = "/{id}") // Al hacer una petición con la ruta principal/id y el método GET, el controller nos devuelve el usuario con el Id indicado.
    public Optional<UsuarioModelo> getUsuarioPorId(@PathVariable("id") Long id) {
        return usuarioServicio.getUsuarioPorId(id);
    }
    
    @GetMapping("/consulta") // Al hacer una petición con la ruta principal/consulta?nombre=valorNombre y el método GET, el controller nos devuelve el/los usuario/s con el Nombre indicado.
    public List<UsuarioModelo> getUsuariosPorNombre(@RequestParam("nombre") String nombre) {
        return usuarioServicio.getUsuariosPorNombre(nombre);
    }
    
    @PostMapping() // Al hacer una petición con la ruta principal y el método POST, pasando en el body, en formato JSON el objeto a guardar/actualizar, el controller guarda el usuario (si no especificamos Id), o actualiza el usuario (si especificamos Id).
    public UsuarioModelo saveUpdateUsuario(@RequestBody UsuarioModelo usuario) {
        return usuarioServicio.saveUpdateUsuario(usuario);
    }
    
    @PutMapping() // Al hacer una petición con la ruta principal y el método PUT, pasando en el body, en formato JSON el objeto a actualizar, el controller actualiza el usuario indicado.
    public UsuarioModelo updateUsuario(@RequestBody UsuarioModelo usuario) {
        return usuarioServicio.updateUsuario(usuario);
    }
    
    @DeleteMapping(path = "/{id}") // Al hacer una petición con la ruta principal/id y el método DELETE, el controller elimina el usuario con el Id indicado y nos devuelve un mensaje de confirmación. En caso que el usuario no exista, nos devuelve un mensaje de operación fallida.
    public String deleteUsuario(@PathVariable("id") Long id) {
        boolean eliminado = usuarioServicio.deleteUsuario(id);
        if (eliminado) {
            return "Se eliminó el usuario con id: " + id;
        }
        else {
            return "No se encontró el usuario con id: " + id;
        }
    }
    
}
