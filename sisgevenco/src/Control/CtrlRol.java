/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Conexion.Conexion;
import Modelo.Rol;
import Modelo.TipoIdentidad;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Leonardo
 */
public class CtrlRol {
    
   public ArrayList<Rol> listadoRol(){
       ArrayList<Rol> listado=new ArrayList();
       String sql;
       sql="Select * from rol order by nombre ASC";
       Conexion conectar=new Conexion();//utilizo mi clase conexion
       ResultSet rs;
        try {// excepciones 
          rs=conectar.consultar(sql);
          while(rs.next()){//recorre el resultset 
              Rol objR=new Rol();
              objR.setIdRol(rs.getInt("idRol"));
              objR.setNombre(rs.getString("nombre"));
              objR.setDescripcion(rs.getString("descripcion"));
              listado.add(objR);//en cada ciclo llenamos el arraylist con el obj
          }//fin while
        } catch (Exception e) {
            System.out.println("Error en la consulta: "+e);
            
        }
        return listado;
    }
    
    public ArrayList<Rol>traerUnRol(String codigo){
       ArrayList<Rol> listado=new ArrayList();//INVESTIGAR ARRAYLIST
       String sql;
       sql="Select * from rol WHERE idRol='"+codigo+"'";
       
       Conexion conectar=new Conexion();//utilizo mi clase conexion
       ResultSet rs;
        try {
          rs=conectar.consultar(sql);
          while(rs.next()){//recorre el resultset
              Rol objR=new Rol();
              objR.setIdRol(rs.getInt("idRol"));
              objR.setNombre(rs.getString("nombre"));
              objR.setDescripcion(rs.getString("descripcion"));
              listado.add(objR);//en cada ciclo llenamos el arraylist con el obj
          }//fin while
        } catch (Exception e) {
            System.out.println("Error en la consulta: "+e);
            
        }
        return listado;
    }
    
    public boolean guardar(Rol objR){
        boolean var=false;
        Conexion conectar=new Conexion();//utilizo mi clase conexion
        String sql; 
        String sqlE;
        sql="INSERT INTO rol(idRol,nombre,descripcion)"
                + " VALUES ('"+objR.getIdRol()+"','"+objR.getNombre()+"','"+objR.getDescripcion()+"')";
       
         try {
            if(conectar.ejecutar(sql)){
                var=true;
             }            
         } catch (Exception e) {
            System.out.println("Error en guardar "+e);
          }
      
       return var;
    }
    
    public boolean modificar(Rol objR){ //
        
        boolean var=false;
        Conexion conectar=new Conexion();//utilizo mi clase conexion
        ResultSet rs1;
        String sql="";
        sql="UPDATE rol SET nombre='"+objR.getNombre()+"', descripcion='" +objR.getDescripcion()
                +"' WHERE idRol="+objR.getIdRol();       
        
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
        sql="DELETE FROM rol WHERE idRol='"+codigo+"'";       
        try{
           if(conectar.ejecutar(sql)){
              var=true;           
            }
        }catch(Exception e){
            System.out.println(e);
        }
      return var;
    }
    
   public void cargarCB(javax.swing.JComboBox jcbx){
        DefaultComboBoxModel value=new DefaultComboBoxModel();//Construye un objeto DefaultComboBoxModel vacío.
        //jcbx.removeAllItems();//deja el combobox vacio listo para cargar lo que viene de la BD, en este caso no hace falta
        //abajo con setModel se setea los valores del comobox, asi en la ventana aparezca item1,item2...
        jcbx.setModel(value);//Establece el modelo de datos que JComboBox utiliza para obtener la lista de elementos.
        Rol objR;//creo una referencia de tipoDocumento

          for(int i=0;i<listadoRol().size();i++){ 
            objR=new Rol();//instancio el objeto tipo Identidad
            objR.setIdRol(listadoRol().get(i).getIdRol());
            objR.setNombre(listadoRol().get(i).getNombre());
            value.addElement(objR);
          }           
   }
    
}
