 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Conexion.Conexion;
import Modelo.TipoIdentidad;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author DANIEL
 */
public class CtrlTipoIdentidad {
    
    public ArrayList<TipoIdentidad> listadoTipoIdentidad(){
       ArrayList<TipoIdentidad> listado=new ArrayList();
       String sql;
       sql="Select * from tipoidentidad order by nombreTipoIdentidad ASC";
       Conexion conectar=new Conexion();//utilizo mi clase conexion
       ResultSet rs;
        try {// excepciones 
          rs=conectar.consultar(sql);
          while(rs.next()){//recorre el resultset 
              TipoIdentidad objT = new TipoIdentidad();
              objT.setIdTipoIdentidad(rs.getInt("idTipoIdentidad"));
              objT.setNombreTipoIdentidad(rs.getString("nombreTipoIdentidad"));
             
              listado.add(objT);//en cada ciclo llenamos el arraylist con el obj
          }//fin while
        } catch (Exception e) {
            System.out.println("Error en la consulta: "+e);
            
        }
        return listado;
    }
    
    public ArrayList<TipoIdentidad>traerUnTipoIdentidad(String codigo){
       ArrayList<TipoIdentidad> listado=new ArrayList();//INVESTIGAR ARRAYLIST
       String sql;
       sql="Select * from tipoidentidad WHERE idTipoIdentidad='"+codigo+"'";
       
       Conexion conectar=new Conexion();//utilizo mi clase conexion
       ResultSet rs;
        try {
          rs=conectar.consultar(sql);
          while(rs.next()){//recorre el resultset
              TipoIdentidad objT=new TipoIdentidad();
              objT.setIdTipoIdentidad(rs.getInt("idTipoIdentidad"));
              objT.setNombreTipoIdentidad(rs.getString("nombreTipoIdentidad"));
              
              listado.add(objT);//en cada ciclo llenamos el arraylist con el obj
          }//fin while
        } catch (Exception e) {
            System.out.println("Error en la consulta: "+e);
            
        }
        return listado;
    }
    
    public boolean guardar(TipoIdentidad objT){
        boolean var=false;
        Conexion conectar=new Conexion();//utilizo mi clase conexion
        String sql; 
        String sqlE;
        sql="INSERT INTO tipoidentidad(nombreTipoIdentidad)"
                + " VALUES ('"+objT.getNombreTipoIdentidad()+"')";
       
         try {
            if(conectar.ejecutar(sql)){
                var=true;
             }            
         } catch (Exception e) {
            System.out.println("Error en guardar "+e);
          }
      
       return var;
    }
    
    public boolean modificar(TipoIdentidad objT){ //
        
        boolean var=false;
        Conexion conectar=new Conexion();//utilizo mi clase conexion
        ResultSet rs1;
        String sql="";
        sql="UPDATE tipoidentidad SET nombreTipoIdentidad='"+objT.getNombreTipoIdentidad()+"' WHERE idTipoIdentidad="+objT.getIdTipoIdentidad();       
        
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
        sql="DELETE FROM tipoidentidad WHERE idTipoIdentidad='"+codigo+"'";       
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
    TipoIdentidad tipIde;//creo una referencia de tipoDocumento
    
      for(int i=0;i<listadoTipoIdentidad().size();i++){ 
        tipIde=new TipoIdentidad();//instancio el objeto tipo Identidad
        tipIde.setIdTipoIdentidad(listadoTipoIdentidad().get(i).getIdTipoIdentidad());
        tipIde.setNombreTipoIdentidad(listadoTipoIdentidad().get(i).getNombreTipoIdentidad());
        value.addElement(tipIde);
      }           
}
    
}
