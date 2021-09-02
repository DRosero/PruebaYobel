/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yobel.controlador;

import com.yobel.dao.PedidoFacade;
import com.yobel.entidad.Pedido;
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
public class ControladorPedido {

    @EJB
    private PedidoFacade pedidoFacade;
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    
    public List<Pedido> mostrarTodosPedidos(){
        return pedidoFacade.findAll();
    }
    
    public void guardarPedido(Pedido pedido){
        pedidoFacade.create(pedido);
    }
    
    public void eliminarPedido(Pedido p){
        pedidoFacade.remove(p);
    }
    
    public Pedido consultarPedidoPorEntidad(Pedido pedido){
        return pedidoFacade.consultarPedidoporEntidad(pedido);
    }
    
    public void actualizarporEntidad(Pedido pedido){
        pedidoFacade.edit(pedido);
    }
            
    
    
}
