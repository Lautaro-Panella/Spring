/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entidad.Cliente;
import java.util.List;

/**
 *
 * @author hp
 */

public interface clienteDAO {
    public List<Cliente> getClientes();
    
    public Cliente getCliente(int id);
    
    public void insertaActualizaCliente(Cliente cliente);
    
    public void eliminaCliente(int id);
    
}
