/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yobel.bean;

import com.yobel.controlador.ControladorCliente;
import com.yobel.entidad.Cliente;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author UsuarioLVD
 */
@Named(value = "clienteBean")
@SessionScoped
public class ClienteBean implements Serializable {

    @EJB
    private ControladorCliente controladorCliente;

    private Cliente cliente;
    private String mensajeValidacion;

    /**
     * Creates a new instance of ClienteBean
     */
    public ClienteBean() {
        cliente = new Cliente();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> mostrarTodosClientesBN() {
        return controladorCliente.mostrarTodosClientes();
    }

    public void guardarClienteBN() {
        mensajeValidacion = "";
        try {
            if (cliente.getDnicliente() != null && cliente.getNombrecliente() != null) {
                cliente.getDnicliente();
                cliente.getNombrecliente();
                controladorCliente.guardarCliente(cliente);
                mensajeValidacion = "Cliente creado correctamente";
                cliente = new Cliente();
            } else {
                mensajeValidacion = "Favor ingrese todos los datos";
            }

        } catch (Exception e) {
            mensajeValidacion = "Error guardar cliente " + e.getMessage();
        }

        FacesMessage mensaje = new FacesMessage(mensajeValidacion);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void cargarClientePorEntidadBN(Cliente c) {
        cliente = c;
    }

    public void actualizarClienteporEntidadBN() {
        mensajeValidacion="";
        try {
            if (cliente.getDnicliente() != null && cliente.getNombrecliente() != null) {
                controladorCliente.actualizarClienteporEntidad(cliente);
                cliente = new Cliente();
                mensajeValidacion = "Cliente actualizado correctamente";
                cliente = new Cliente();
            } else {
                mensajeValidacion = "Favor ingrese todos los datos";
            }
        } catch (Exception e) {
            mensajeValidacion = "Error actualizar cliente " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(mensajeValidacion);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);

    }

    public void eliminarCliente(Cliente c) {
        mensajeValidacion="";
        try {
            controladorCliente.eliminarClienteporEntidad(c);
            mensajeValidacion = "Cliente eliminado correctamente";
        } catch (Exception e) {
            mensajeValidacion = "Error al eliminar cliente " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(mensajeValidacion);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
        
    }

}
