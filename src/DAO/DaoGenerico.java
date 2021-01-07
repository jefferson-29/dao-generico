/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.ClsUsuario;
import Modelo.ClsConexion;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import java.awt.List;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author David
 */
public class DaoGenerico extends ClsConexion {

    ClsUsuario dao = new ClsUsuario();

    public boolean guardar(String objeto, String tabla) {
        System.out.println(objeto);

        JsonParser parser = new JsonParser();
        JsonObject jobject = parser.parse(objeto).getAsJsonObject();
        Set<String> keys = jobject.keySet();

        ArrayList<String> listCampos = new ArrayList(keys);
        ArrayList<String> listValores = new ArrayList();
        for (int i = 0; i < listCampos.size(); i++) {
            System.out.println(listCampos.get(i));
            listValores.add(jobject.get(listCampos.get(i)).getAsString());
        }
         for (int i = 0; i < listValores.size(); i++) {
            System.out.println(listValores.get(i));
        }
        String consulta = "insert into " + tabla + "(";
        Iterator<String> itrCampos = listCampos.iterator();

        while (itrCampos.hasNext()) {
            Object atributo = itrCampos.next();
            consulta = consulta + "" + atributo.toString().toLowerCase();
            if(itrCampos.hasNext()){
                consulta = consulta + ",";
            }else{
                consulta = consulta + ") values (";
            }
            
        }
        Iterator<String> itrValores = listValores.iterator();
        while (itrValores.hasNext()) {
            Object valor = itrValores.next();
            consulta = consulta + "'" + valor ;
            if(itrValores.hasNext()){
                consulta = consulta + "',";
            }else{
                consulta = consulta + "');";
            }
            
        }
        System.out.println(consulta);
        
        return super.ejecutar(consulta);
    }

//    public ClsUsuario buscar(int cedula) {
//        String consulta = "select cedula,nombre,apellido,edad from usuario where cedula='" + cedula + "'";
//        super.ejecutarRetorno(consulta);
//        try {
//            if (resultadoDB.next()) {
//                dao.setCedula(resultadoDB.getInt("cedula"));
//                dao.setNombre(resultadoDB.getString("nombre"));
//                dao.setApellido(resultadoDB.getString("apellido"));
//                dao.setEdad(resultadoDB.getInt("edad"));
//            }
//        } catch (SQLException ex) {
//            System.out.println("Esto se tosto");
//        }
//        return dao;
//    }
//
//    public boolean modificar(ClsUsuario usuDAO) {
//        String consulta = "update usuario set nombre='" + usuDAO.getNombre() + "',apellido='" + usuDAO.getApellido() + "'," + "edad=" + usuDAO.getEdad() + " where cedula=" + usuDAO.getCedula();
//        return super.ejecutar(consulta);
//    }
//
//    public boolean eliminar(int cedula) {
//        String consulta = "delete from usuario where cedula=" + cedula;
//        return super.ejecutar(consulta);
//    }
//
//    public DefaultTableModel listarUsuario() {
//
//        DefaultTableModel modelTabla;
//        String nombreColumnas[] = {"Cedula", "Nombre", "Apellido", "Edad"};
//        modelTabla = new DefaultTableModel(new Object[][]{}, nombreColumnas);
//
//        String consulta = "select cedula,nombre,apellido,edad from usuario";
//        super.ejecutarRetorno(consulta);
//
//        try {
//            while (resultadoDB.next()) {
//                modelTabla.addRow(new Object[]{
//                    resultadoDB.getInt("cedula"),
//                    resultadoDB.getString("nombre"),
//                    resultadoDB.getString("apellido"),
//                    resultadoDB.getInt("edad")});
//            }
//        } catch (SQLException ex) {
//            System.out.println("Esto se tosto");
//        }
//        return modelTabla;
//    }
}
