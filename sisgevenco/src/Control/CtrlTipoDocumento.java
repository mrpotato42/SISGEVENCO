/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Conexion.Conexion;
import Modelo.TipoDocumento;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Leonardo
 */
public class CtrlTipoDocumento {
    
    public ArrayList<TipoDocumento> traer(){
       ArrayList<TipoDocumento> listado=new ArrayList();
       String sql;
       sql="Select * from tipodocumento";
       Conexion conectar=new Conexion();//utilizo mi clase conexion
       ResultSet rs;
        try {
          rs=conectar.consultar(sql);
          while(rs.next()){//recorre el resultset 
              TipoDocumento td=new TipoDocumento();
              td.setCodigoDocumento(rs.getInt("codigoDocumento"));
              td.setDescripcion(rs.getString("descripcion"));
               listado.add(td);//en cada ciclo llenamos el array list con el obj
          }//fin while
        } catch (Exception e) {
            System.out.println("Error en la consulta: "+e);
            
        }
        return listado;
    }
    
    public ArrayList<TipoDocumento>traerUnTipoIdentidad(String codigo){
       ArrayList<TipoDocumento> listado=new ArrayList();//INVESTIGAR ARRAYLIST
       String sql;
       sql="Select * from tipodocumento WHERE codigoDocumento="+codigo;
       
       Conexion conectar=new Conexion();//utilizo mi clase conexion
       ResultSet rs;
        try {
          rs=conectar.consultar(sql);
          while(rs.next()){//recorre el resultset
              TipoDocumento objTD=new TipoDocumento();
              objTD.setCodigoDocumento(rs.getInt("codigoDocumento"));
              objTD.setDescripcion(rs.getString("descripcion"));
              
              listado.add(objTD);//en cada ciclo llenamos el arraylist con el obj
          }//fin while
        } catch (Exception e) {
            System.out.println("Error en la consulta: "+e);
            
        }
        return listado;
    }
    
    public boolean guardar(TipoDocumento objTD){
        boolean var=false;
        Conexion conectar=new Conexion();//utilizo mi clase conexion
        String sql; 
        String sqlE;
        sql="INSERT INTO tipodocumento(descripcion)"
                + " VALUES ('"+objTD.getDescripcion()+"')";
       
         try {
            if(conectar.ejecutar(sql)){
                var=true;
             }            
         } catch (Exception e) {
            System.out.println("Error en guardar "+e);
          }
      
       return var;
    }
    
    public boolean modificar(TipoDocumento objTD){ //
        
        boolean var=false;
        Conexion conectar=new Conexion();//utilizo mi clase conexion
        ResultSet rs1;
        String sql="";
        sql="UPDATE tipodocumento SET descripcion='"+objTD.getDescripcion()+"' WHERE codigoDocumento="+objTD.getCodigoDocumento();
        
        try{           
           if(conectar.ejecutar(sql)){
               var=true;
           }
        }catch(Exception e){
            System.out.println("Error en modificar "+e);
        }
     
        return var;
    }
    
    public boolean eliminar(int codigo){
        boolean var=false;
        Conexion conectar=new Conexion();//utilizo mi clase conexion
        ResultSet rs; 
        String sql;
        sql="DELETE FROM tipodocumento WHERE codigoDocumento="+codigo;       
        try{
           if(conectar.ejecutar(sql)){
              var=true;           
            }
        }catch(Exception e){
            System.out.println(e);
        }
      return var;
    } 
    
    
  
    public void cargarCB(javax.swing.JComboBox jcbx) {
        DefaultComboBoxModel value = new DefaultComboBoxModel();//Construye un objeto DefaultComboBoxModel vacío.
        //jcbx.removeAllItems();//deja el combobox vacio listo para cargar lo que viene de la BD, en este caso no hace falta
        //abajo con setModel se setea los valores del comobox, asi en la ventana aparezca item1,item2...
        jcbx.setModel(value);//Establece el modelo de datos que JComboBox utiliza para obtener la lista de elementos.
        TipoDocumento tp;//creo una referencia de tipoDocumento

        for (int i = 0; i < traer().size(); i++) {
            tp = new TipoDocumento();//instancio el objeto tipodocumento
            tp.setCodigoDocumento(traer().get(i).getCodigoDocumento());
            tp.setDescripcion(traer().get(i).getDescripcion());
            value.addElement(tp);
        }
    }
  
  
}
