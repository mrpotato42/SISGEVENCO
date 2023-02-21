/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Conexion.Conexion;
import Modelo.SubLineaProducto;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author DANIEL
 */
public class CtrlSubLinea {
    
     public ArrayList<SubLineaProducto> listadoSubLinea() {
        ArrayList<SubLineaProducto> listado = new ArrayList();
        String sql;
        sql = "Select * from sublineaproducto order by sublineaDescripcion ASC";
        Conexion conectar = new Conexion();//utilizo mi clase conexion
        ResultSet rs;
        try {// excepciones 
            rs = conectar.consultar(sql);
            while (rs.next()) {//recorre el resultset 
                SubLineaProducto objSlp = new SubLineaProducto();
                objSlp.setIdSubLinea(rs.getInt("idSublinea"));
                objSlp.setSubLineaDescripcion(rs.getString("sublineaDescripcion"));
                objSlp.setIdLinea(rs.getInt("idLinea"));
                listado.add(objSlp);//en cada ciclo llenamos el arraylist con el obj
            }//fin while
        } catch (Exception e) {
            System.out.println("Error en la consulta: " + e);

        }
        return listado;
    }
    
    public void cargarCB(javax.swing.JComboBox jcbx) {
        DefaultComboBoxModel value = new DefaultComboBoxModel();//Construye un objeto DefaultComboBoxModel vacío.
        //jcbx.removeAllItems();//deja el combobox vacio listo para cargar lo que viene de la BD, en este caso no hace falta
        //abajo con setModel se setea los valores del comobox, asi en la ventana aparezca item1,item2...
        jcbx.setModel(value);//Establece el modelo de datos que JComboBox utiliza para obtener la lista de elementos.
        SubLineaProducto slp;//creo una referencia de tipoDocumento
        int tam=listadoSubLinea().size();
        for (int i = 0; i < tam; i++) {
            slp = new SubLineaProducto();//instancio el objeto sublineaproducto
            slp.setIdSubLinea(listadoSubLinea().get(i).getIdSubLinea());
            slp.setSubLineaDescripcion(listadoSubLinea().get(i).getSubLineaDescripcion());
            value.addElement(slp);
        }
    }
    
    
    public ArrayList<SubLineaProducto> listadoSubLineaCondicionado(int idLinea) {
        ArrayList<SubLineaProducto> listado = new ArrayList();
        String sql;
        sql = "Select * from sublineaproducto where idLinea="+idLinea+" order by sublineaDescripcion ASC";
        Conexion conectar = new Conexion();//utilizo mi clase conexion
        ResultSet rs;
        try {// excepciones 
            rs = conectar.consultar(sql);
            while (rs.next()) {//recorre el resultset 
                SubLineaProducto objSlp = new SubLineaProducto();
                objSlp.setIdSubLinea(rs.getInt("idSublinea"));
                objSlp.setSubLineaDescripcion(rs.getString("sublineaDescripcion"));
                objSlp.setIdLinea(rs.getInt("idLinea"));
                listado.add(objSlp);//en cada ciclo llenamos el arraylist con el obj
            }//fin while
        } catch (Exception e) {
            System.out.println("Error en la consulta: " + e);

        }
        return listado;
    }
    
    public void cargarCBcondicionado(javax.swing.JComboBox jcbx,int idLinea) {//COMBOBOX CONDICIONADO EN FORMARTICULOGUI
        DefaultComboBoxModel value = new DefaultComboBoxModel();//Construye un objeto DefaultComboBoxModel vacío.
        //jcbx.removeAllItems();//deja el combobox vacio listo para cargar lo que viene de la BD, en este caso no hace falta
        //abajo con setModel se setea los valores del comobox, asi en la ventana aparezca item1,item2...
        jcbx.setModel(value);//Establece el modelo de datos que JComboBox utiliza para obtener la lista de elementos.
        SubLineaProducto slp;//creo una referencia de tipoDocumento
        
        ArrayList<SubLineaProducto> listado=listadoSubLineaCondicionado(idLinea);
        int tam=listado.size();
        
        for (int i = 0; i < tam; i++) {
            slp = new SubLineaProducto();//instancio el objeto sublineaproducto
            slp.setIdSubLinea(listado.get(i).getIdSubLinea());
            slp.setSubLineaDescripcion(listado.get(i).getSubLineaDescripcion());
            value.addElement(slp);
        }
    }
    
    
    //METODOS PARA GESTION SUBLINEAPRODUCTO
    
    public ArrayList<SubLineaProducto> listadoSubLineaProducto() {
        ArrayList<SubLineaProducto> listado = new ArrayList();
        String sql;
        sql = "Select slp.idSublinea,slp.sublineaDescripcion,slp.idLinea,lp.lineaDescripcion"
           + " from sublineaproducto slp INNER JOIN lineaproducto lp ON slp.idLinea=lp.idLinea"
           + " order by slp.sublineaDescripcion  ASC";
        Conexion conectar = new Conexion();//utilizo mi clase conexion
        ResultSet rs;
        try {// excepciones 
            rs = conectar.consultar(sql);
            while (rs.next()) {//recorre el resultset 
                SubLineaProducto objSlp = new SubLineaProducto();
                objSlp.setIdSubLinea(rs.getInt("idSublinea"));
                objSlp.setSubLineaDescripcion(rs.getString("sublineaDescripcion"));
                objSlp.setIdLinea(rs.getInt("idLinea"));
                objSlp.setDescLineaProd(rs.getString("lineaDescripcion"));
                listado.add(objSlp);//en cada ciclo llenamos el arraylist con el obj
            }//fin while
        } catch (Exception e) {
            System.out.println("Error en la consulta: " + e);

        }
        return listado;
    }
    
    
    public ArrayList<SubLineaProducto> BusquedaTiempoReal(String texto){
       ArrayList<SubLineaProducto> listado=new ArrayList();
       String sql="";
       
           sql="Select slp.idSublinea,slp.sublineaDescripcion,slp.idLinea,lp.lineaDescripcion"
               + " from sublineaproducto slp INNER JOIN lineaproducto lp ON slp.idLinea=lp.idLinea"
               + " WHERE UPPER(slp.sublineaDescripcion) LIKE UPPER('%"+texto+"%') OR "
               + "UPPER(lp.lineaDescripcion) LIKE UPPER('%"+texto+"%')"
               + " order by slp.sublineaDescripcion";           
          
            System.out.println(sql); 
            
       Conexion conectar=new Conexion();//utilizo mi clase conexion
       ResultSet rs;
        try {
          rs=conectar.consultar(sql);
          while(rs.next()){//recorre el resultset
             SubLineaProducto objSlp = new SubLineaProducto();
                objSlp.setIdSubLinea(rs.getInt("idSublinea"));
                objSlp.setSubLineaDescripcion(rs.getString("sublineaDescripcion"));
                objSlp.setIdLinea(rs.getInt("idLinea"));
                objSlp.setDescLineaProd(rs.getString("lineaDescripcion"));
                listado.add(objSlp);//en cada ciclo llenamos el arraylist con el obj
          }//fin while
        } catch (Exception e) {
            System.out.println("Error en la consulta: "+e);
            
        }
        return listado;
    } 
    
    
    
    public ArrayList<SubLineaProducto> traerUnaSubLineaProducto(int codigo) {
        ArrayList<SubLineaProducto> listado = new ArrayList();//INVESTIGAR ARRAYLIST
        String sql;
        sql = "Select slp.idSublinea,slp.sublineaDescripcion,slp.idLinea,lp.lineaDescripcion"
              + " from sublineaproducto slp INNER JOIN lineaproducto lp ON slp.idLinea=lp.idLinea"
              + " WHERE slp.idSublinea="+codigo;

        Conexion conectar = new Conexion();//utilizo mi clase conexion
        ResultSet rs;
        try {
            rs = conectar.consultar(sql);
            while (rs.next()) {//recorre el resultset
                SubLineaProducto objSlp = new SubLineaProducto();
                objSlp.setIdSubLinea(rs.getInt("idSublinea"));
                objSlp.setSubLineaDescripcion(rs.getString("sublineaDescripcion"));
                objSlp.setIdLinea(rs.getInt("idLinea"));
                objSlp.setDescLineaProd(rs.getString("lineaDescripcion"));
                listado.add(objSlp);//en cada ciclo llenamos el arraylist con el obj
            }//fin while
        } catch (Exception e) {
            System.out.println("Error en la consulta: " + e);

        }
        return listado;
    }

    public boolean guardar(SubLineaProducto objSlp) {
        boolean var = false;
        Conexion conectar = new Conexion();//utilizo mi clase conexion
        String sql;
        sql = "INSERT INTO sublineaproducto(sublineaDescripcion,idLinea)"
                + " VALUES ('"+ objSlp.getSubLineaDescripcion() + "'," + objSlp.getIdLinea() + ")";

        try {
            if (conectar.ejecutar(sql)) {
                var = true;
            }
        } catch (Exception e) {
            System.out.println("Error en guardar " + e);
        }

        return var;
    }

    public boolean modificar(SubLineaProducto objSlp) { //

        boolean var = false;
        Conexion conectar = new Conexion();//utilizo mi clase conexion
        ResultSet rs1;
        String sql = "";
        sql = "UPDATE sublineaproducto SET sublineaDescripcion='" + objSlp.getSubLineaDescripcion() + "',idLinea=" + objSlp.getIdLinea()
           +" WHERE idSublinea=" + objSlp.getIdSubLinea();

        try {
            if (conectar.ejecutar(sql)) {
                var = true;
            }
        } catch (Exception e) {
            System.out.println("Error en modificar " + e);
        }

        return var;
    }
    
    public boolean eliminar(int codigo) {
        boolean var = false;
        Conexion conectar = new Conexion();//utilizo mi clase conexion
        ResultSet rs;
        String sql;
        sql = "DELETE FROM sublineaproducto WHERE idSublinea=" + codigo;
        try {
            if (conectar.ejecutar(sql)) {
                var = true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return var;
    }
    
}
