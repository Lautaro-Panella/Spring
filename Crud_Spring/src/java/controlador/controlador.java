/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import entidad.Cliente;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author hp
 */

@Controller
@RequestMapping("/cliente")
public class controlador {
    
    @RequestMapping("/listaClientes")
    public String listaClientes(Model modelo) {
        
        List<Cliente> clientes = clienteDAO.getClientes();
        modelo.addAttribute("clientes", clientes);
        return "listaClientes";
    }
    
    @RequestMapping("/agregaCliente")
    public String agregaCliente(Model modelo) {
        Cliente cliente = new Cliente();
        modelo.addAttribute("cliente", cliente);
        return "agregaCliente";
    }
    
    @PostMapping("/procesaCliente")
    public String procesaCliente(@ModelAttribute("cliente") Cliente cliente) {
        clienteDAO.insertaActualizaCliente(cliente);
        return "redirect:/cliente/listaClientes";
    }
    
    @GetMapping("/actualizaCliente")
    public String actualizaCliente(@RequestParam("idCliente") int id, Model modelo) {
        Cliente cliente = clienteDAO.getCliente(id);
        modelo.addAttribute("cliente", cliente);
        return "agregaCliente";
    }
    
    @GetMapping("/eliminaCliente")
    public String eliminaCliente(@RequestParam("idCliente") int id) {
        clienteDAO.eliminaCliente(id);
        return "redirect:/cliente/listaClientes";
    }
    
    @Autowired
    private clienteDAO clienteDAO;
}
