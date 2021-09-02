/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yobel.dao;

import com.yobel.entidad.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author UsuarioLVD
 */
@Stateless
public class ClienteFacade extends AbstractFacade<Cliente> {

    @PersistenceContext(unitName = "PedidosYobel-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClienteFacade() {
        super(Cliente.class);
    }
    
    public Cliente consultarClienteporEntidad(Cliente c){
        
        Cliente c1=new Cliente();
        List<Cliente> listaCliente= new ArrayList<>();
        Query q=em.createQuery("select C FROM Cliente C where C.idcliente=:idcliente");
        q.setParameter("idcliente", c.getIdcliente());
        listaCliente=q.getResultList();
        
        if(!listaCliente.isEmpty()){
            c1=listaCliente.get(0);
        }
        
        return c1;
    }
            
    
}
