/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yobel.dao;

import com.yobel.entidad.Pedido;
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
public class PedidoFacade extends AbstractFacade<Pedido> {

    @PersistenceContext(unitName = "PedidosYobel-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PedidoFacade() {
        super(Pedido.class);
    }
    
    
     public Pedido consultarPedidoporEntidad(Pedido p){
        
        Pedido p1=new Pedido();
        List<Pedido> listaPedido= new ArrayList<>();
        Query q=em.createQuery("select P FROM Pedido P where P.idpedido=:idpedido");
        q.setParameter("idpedido", p.getIdpedido());
        listaPedido=q.getResultList();
        
        if(!listaPedido.isEmpty()){
            p1=listaPedido.get(0);
        }
        
        return p1;
    }
    
}
