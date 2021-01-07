/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ClsConexion;
import Modelo.ClsUsuario;
import DAO.DaoGenerico;
import Modelo.ClsCategoria;
import com.google.gson.Gson;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author David
 */
public class CtlUsuario {

    ClsConexion conexion = new ClsConexion();
    String tabla = "usuarios";

    public CtlUsuario() {

    }
    
      public String convertirGson (ClsUsuario usuario){
        Gson gson = new Gson();
        String objeto = gson.toJson(usuario);
        return objeto;
    }
    public boolean SolicitudGuardar(int cedula, String nombre, String apellido, int edad) {
       
        ClsUsuario usuario = new ClsUsuario(cedula, nombre, apellido, edad);
        DaoGenerico usuarioDAO = new DaoGenerico();
        String objeto = convertirGson(usuario);
        return usuarioDAO.guardar(objeto,tabla);
    }

    /*public ClsUsuario SolicitudBuscar(int cedula) {
        DaoGenerico usuDAO = new DaoGenerico();
        return usuDAO.buscarUsuario(cedula);
    }

    public boolean SolicitudModificar(int cedula, String nombre, String apellido, int edad) {
        ClsUsuario usuario = new ClsUsuario(cedula, nombre, apellido, edad);
        DaoGenerico usuDAO = new DaoGenerico();
        return usuDAO.modificarUsuario(usuario);
    }

    public boolean solicitudEliminar(int cedula) {
        DaoGenerico usuDAO = new DaoGenerico();
        return usuDAO.eliminarUsuario(cedula);
    }

    public DefaultTableModel SolicitudListar() {
        DaoGenerico usuDAO = new DaoGenerico();
        return usuDAO.listarUsuario();        
    }*/
 /*public boolean SolicitudGuardar(int cedula, String nombre, String apellido, int edad) {
        ClsUsuario usuario = new ClsUsuario(cedula, nombre, apellido, edad);
        DaoGenerico usuDAO = new DaoGenerico();
        return usuDAO.guardarUsuario(usuario);
    }

    public ClsUsuario SolicitudBuscar(int cedula) {
        DaoGenerico usuDAO = new DaoGenerico();
        return usuDAO.buscarUsuario(cedula);
    }

    public boolean SolicitudModificar(int cedula, String nombre, String apellido, int edad) {
        ClsUsuario usuario = new ClsUsuario(cedula, nombre, apellido, edad);
        DaoGenerico usuDAO = new DaoGenerico();
        return usuDAO.modificarUsuario(usuario);
    }

    public boolean solicitudEliminar(int cedula) {
        DaoGenerico usuDAO = new DaoGenerico();
        return usuDAO.eliminarUsuario(cedula);
    }

    public DefaultTableModel SolicitudListar() {
        DaoGenerico usuDAO = new DaoGenerico();
        return usuDAO.listarUsuario();        
    }*/
}
