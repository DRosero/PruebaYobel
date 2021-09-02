/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yobel.bean;

import com.yobel.controlador.ControladorCliente;
import com.yobel.controlador.ControladorPedido;
import com.yobel.entidad.Cliente;
import com.yobel.entidad.Pedido;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

/**
 *
 * @author UsuarioLVD
 */
@Named(value = "pedidoBean")
@SessionScoped
public class PedidoBean implements Serializable {

    @EJB
    private ControladorCliente controladorCliente;

    @EJB
    private ControladorPedido controladorPedido;

    private Pedido pedido;
    private Cliente cliente;
    private String mensajeValidacion;

    /**
     * Creates a new instance of PedidoBean
     */
    public PedidoBean() {
        pedido = new Pedido();
        cliente = new Cliente();
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Pedido> mostrarTodosPedidosBN() {
        return controladorPedido.mostrarTodosPedidos();
    }

    public List<Cliente> mostrarTodosClientesBN() {
        return controladorCliente.mostrarTodosClientes();
    }

    public List<SelectItem> listaClienteCombobox() {
        List<SelectItem> comboClientes = new ArrayList<>();
        Map<Integer, String> clientesMapa = new TreeMap<Integer, String>();
        comboClientes.clear();
        for (Cliente cliente : mostrarTodosClientesBN()) {
            clientesMapa.put(cliente.getIdcliente(), cliente.getNombrecliente());
        }
        Iterator iterator = clientesMapa.keySet().iterator();
        while (iterator.hasNext()) {
            Integer clave = (Integer) iterator.next();
            SelectItem itemMapaClientes = new SelectItem(clave, clientesMapa.get(clave));
            comboClientes.add(itemMapaClientes);
        }
        return comboClientes;
    }

    public void guardarPedidoBN() {
        mensajeValidacion="";
        try {
            if (pedido.getFechapedido() != null && pedido.getCodigopedido() != null) {
                pedido.setIdcliente(cliente);

                controladorPedido.guardarPedido(pedido);
                mensajeValidacion = "Pedido creado correctamente";
                pedido = new Pedido();
                cliente = new Cliente();
            } else {
                mensajeValidacion = "Favor ingrese todos los datos";
            }

        } catch (Exception e) {
            mensajeValidacion = "Error guardar pedido " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(mensajeValidacion);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);

    }

    public void eliminarPedidoBN(Pedido p) {
        mensajeValidacion="";

        try {
            controladorPedido.eliminarPedido(p);
            mensajeValidacion = "Pedido eliminado correctamente";
        } catch (Exception e) {
            mensajeValidacion = "Error al eliminar Pedido " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(mensajeValidacion);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);

    }

    public void cargarEntidadPorEntidadBN(Pedido p) {
        cliente.setIdcliente(p.getIdcliente().getIdcliente());
        pedido = p;
    }

    public void actualizarPedidoporEntidadBN() {
        mensajeValidacion="";
        try {
            if (pedido.getFechapedido() != null && pedido.getCodigopedido() != null ) {
                pedido.setIdcliente(cliente);
                controladorPedido.actualizarporEntidad(pedido);
                mensajeValidacion = "Pedido actualizado correctamente";
                pedido = new Pedido();
            } else {
                mensajeValidacion = "Favor ingrese todos los datos";
            }
        } catch (Exception e) {
            mensajeValidacion = "Error actualizar pedido " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(mensajeValidacion);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);

    }

}
