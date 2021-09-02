/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yobel.controlador;

import com.yobel.dao.ClienteFacade;
import com.yobel.entidad.Cliente;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author UsuarioLVD
 */
@Stateless
@LocalBean
public class ControladorCliente {

    @EJB
    private ClienteFacade clienteFacade;
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public List<Cliente> mostrarTodosClientes(){
        return clienteFacade.findAll();
    }
    
    public void guardarCliente(Cliente cliente){
        clienteFacade.create(cliente);
    }
    
    public Cliente consultarClientePorEntidad(Cliente cliente){
        return clienteFacade.consultarClienteporEntidad(cliente);
    }
    
    public void actualizarClienteporEntidad(Cliente c){
        clienteFacade.edit(c);
    }
    
    public void eliminarClienteporEntidad(Cliente c){
        clienteFacade.remove(c);
    }
}
