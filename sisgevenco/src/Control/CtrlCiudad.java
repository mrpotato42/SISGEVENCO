/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Conexion.Conexion;
import Modelo.Ciudad;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Leonardo
 */
public class CtrlCiudad {

    public ArrayList<Ciudad> listadoCiudad() {
        ArrayList<Ciudad> listado = new ArrayList();
        String sql;
        sql = "Select * from ciudad order by nombre ASC";
        Conexion conectar = new Conexion();//utilizo mi clase conexion
        ResultSet rs;
        try {// excepciones 
            rs = conectar.consultar(sql);
            while (rs.next()) {//recorre el resultset 
                Ciudad objC = new Ciudad();
                objC.setCodigoCiudad(rs.getInt("codigoCiudad"));
                objC.setNombre(rs.getString("nombre"));
                objC.setDepartamento(rs.getString("departamento"));
                listado.add(objC);//en cada ciclo llenamos el arraylist con el obj
            }//fin while
        } catch (Exception e) {
            System.out.println("Error en la consulta: " + e);

        }
        return listado;
    }
    
    
    public ArrayList<Ciudad> BusquedaTiempoReal(String texto){
       ArrayList<Ciudad> listado=new ArrayList();
       String sql="";
       
           sql="Select codigoCiudad,nombre,departamento from ciudad"
               + " WHERE UPPER(nombre) LIKE UPPER('%"+texto+"%') OR "
               + "UPPER(departamento) LIKE UPPER('%"+texto+"%')"
               + " order by nombre";           
          
            System.out.println(sql); 
            
       Conexion conectar=new Conexion();//utilizo mi clase conexion
       ResultSet rs;
        try {
          rs=conectar.consultar(sql);
          while(rs.next()){//recorre el resultset
              Ciudad ciu=new Ciudad();
              
              ciu.setCodigoCiudad(rs.getInt("codigoCiudad"));
              ciu.setNombre(rs.getString("nombre"));
              ciu.setDepartamento(rs.getString("departamento"));              
              
              
              listado.add(ciu);//en cada ciclo llenamos el array list con el obj
          }//fin while
        } catch (Exception e) {
            System.out.println("Error en la consulta: "+e);
            
        }
        return listado;
    } 
    
    
    
    public ArrayList<Ciudad> traerUnCiudad(String codigo) {
        ArrayList<Ciudad> listado = new ArrayList();//INVESTIGAR ARRAYLIST
        String sql;
        sql = "Select * from ciudad WHERE codigociudad='" + codigo + "'";

        Conexion conectar = new Conexion();//utilizo mi clase conexion
        ResultSet rs;
        try {
            rs = conectar.consultar(sql);
            while (rs.next()) {//recorre el resultset
                Ciudad objC = new Ciudad();
                objC.setCodigoCiudad(rs.getInt("codigociudad"));
                objC.setNombre(rs.getString("nombre"));
                objC.setDepartamento(rs.getString("departamento"));
                listado.add(objC);//en cada ciclo llenamos el arraylist con el obj
            }//fin while
        } catch (Exception e) {
            System.out.println("Error en la consulta: " + e);

        }
        return listado;
    }

    public boolean guardar(Ciudad objC) {
        boolean var = false;
        Conexion conectar = new Conexion();//utilizo mi clase conexion
        String sql;
        String sqlE;
        sql = "INSERT INTO ciudad(codigociudad,nombre,departamento)"
                + " VALUES ('" + objC.getCodigoCiudad() + "','" + objC.getNombre() + "','" + objC.getDepartamento() + "')";

        try {
            if (conectar.ejecutar(sql)) {
                var = true;
            }
        } catch (Exception e) {
            System.out.println("Error en guardar " + e);
        }

        return var;
    }

    public boolean modificar(Ciudad objC) { //

        boolean var = false;
        Conexion conectar = new Conexion();//utilizo mi clase conexion
        ResultSet rs1;
        String sql = "";
        sql = "UPDATE ciudad SET nombre='" + objC.getNombre() + "', departamento='" + objC.getDepartamento()
                + "' WHERE codigociudad=" + objC.getCodigoCiudad();

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
        sql = "DELETE FROM ciudad WHERE codigociudad='" + codigo + "'";
        try {
            if (conectar.ejecutar(sql)) {
                var = true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return var;
    }

    public void cargarCB(javax.swing.JComboBox jcbx) {
        DefaultComboBoxModel value = new DefaultComboBoxModel();//Construye un objeto DefaultComboBoxModel vacío.
        //jcbx.removeAllItems();//deja el combobox vacio listo para cargar lo que viene de la BD, en este caso no hace falta
        //abajo con setModel se setea los valores del comobox, asi en la ventana aparezca item1,item2...
        jcbx.setModel(value);//Establece el modelo de datos que JComboBox utiliza para obtener la lista de elementos.
        Ciudad ciu;//creo una referencia de tipoDocumento

        for (int i = 0; i < listadoCiudad().size(); i++) {
            ciu = new Ciudad();//instancio el objeto Ciudad
            ciu.setCodigoCiudad(listadoCiudad().get(i).getCodigoCiudad());
            ciu.setNombre(listadoCiudad().get(i).getNombre());
            value.addElement(ciu);
        }
    }

}
