/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import entidad.Cliente;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author hp
 */

@Repository
public class clienteDAOclase implements clienteDAO {
    
    @Autowired
    SessionFactory sessionFactory;
    
    @Override
    @Transactional
    public List<Cliente> getClientes() {
        Session session = sessionFactory.getCurrentSession();
        List<Cliente> clientes = session.createQuery("FROM Cliente", Cliente.class).getResultList();
        return clientes;
    }
    
    @Override
    @Transactional
    public Cliente getCliente(int id) {
        Session session = sessionFactory.getCurrentSession();
        Cliente cliente = session.createQuery("FROM Cliente WHERE id="+id, Cliente.class).getSingleResult();
        return cliente;
    }

    @Override
    @Transactional
    public void insertaActualizaCliente(Cliente cliente) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(cliente);
    }
    
    @Override
    @Transactional
    public void eliminaCliente(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("DELETE Cliente WHERE id="+id).executeUpdate();
    }
    
}
