/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 *
 * @author DAGA
 */

import Modelo.ClsConexion;
import Modelo.ClsCategoria;
import DAO.DaoGenerico;
import com.google.gson.Gson;
import javax.swing.table.DefaultTableModel;

public class CtlCategoria {
    ClsConexion conexion = new ClsConexion();
    String tabla="categorias";
    public CtlCategoria() {
    }
    
    public String convertirGson (ClsCategoria categoria){
        Gson gson = new Gson();
        String objeto = gson.toJson(categoria);
        return objeto;
    }
    
    public boolean SolicitudGuardar(int idCategoria, int valorMensual, String nombreCategoria) {
        
        ClsCategoria categoria = new ClsCategoria(idCategoria, valorMensual, nombreCategoria);
        DaoGenerico categoriaDAO = new DaoGenerico();
        String objeto = convertirGson(categoria);
        return categoriaDAO.guardar(objeto,tabla);
    }

//    public ClsCategoria SolicitudBuscar(int idCategoria) {
//        DaoGenerico categoriaDAO = new DaoGenerico();
//        return categoriaDAO.buscar(idCategoria);
//    }
//
//    public boolean SolicitudModificar(int idCategoria, int valorMensual, String nombreCategoria) {
//        ClsCategoria categoria = new ClsCategoria(idCategoria, valorMensual, nombreCategoria);
//        DaoGenerico categoriaDAO = new DaoGenerico();
//        return categoriaDAO.modificar(categoria);
//    }
//
//    public boolean solicitudEliminar(int idCategoria) {
//        DaoGenerico categoriaDAO = new DaoGenerico();
//        return categoriaDAO.eliminar(idCategoria);
//    }
//
//    public DefaultTableModel SolicitudListar() {
//        DaoGenerico categoriaDAO = new DaoGenerico();
//        return categoriaDAO.listar();        
//    }
}
