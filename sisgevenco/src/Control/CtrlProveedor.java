/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Conexion.Conexion;
import Modelo.Proveedor;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author DANIEL
 */
public class CtrlProveedor {
    
    public ArrayList<Proveedor> traerTodos(){
       ArrayList<Proveedor> listado=new ArrayList();
       String sql;
       sql="Select prove.idProveedores,prove.numeroIdentidad,prove.nombre,prove.codigoCiudad,ciu.nombre as nomCiudad,"
           + "prove.direccion,prove.telefono,prove.email,prove.estado from "
           + "proveedores prove INNER JOIN ciudad ciu ON prove.codigoCiudad=ciu.codigoCiudad";
               
       System.out.println(sql);
       Conexion conectar=new Conexion();//utilizo mi clase conexion
       ResultSet rs;
        try {
          rs=conectar.consultar(sql);
          while(rs.next()){//recorre el resultset 
              Proveedor pro=new Proveedor();
              
              pro.setIdProveedor(rs.getInt("idProveedores"));
              pro.setNumeroIdentidad(rs.getString("numeroIdentidad"));              
              pro.setNombre(rs.getString("nombre"));
              pro.setCodigoCiudad(rs.getInt("codigoCiudad"));
              pro.setNomCiudad(rs.getString("nomCiudad"));
              pro.setDireccion(rs.getString("direccion"));
              pro.setTelefono(rs.getString("telefono"));
              pro.setEmail(rs.getString("email"));
              pro.setEstado(rs.getString("estado"));
              
              listado.add(pro);//en cada ciclo llenamos el array list con el obj
          }//fin while
        } catch (Exception e) {
            System.out.println("Error en la consulta: "+e);
            
        }
        return listado;
    }
     
     
    public ArrayList<Proveedor> traerUnProveedor(int idProveedores){
       ArrayList<Proveedor> listado=new ArrayList();
       String sql;
       sql="Select prove.idProveedores,prove.numeroIdentidad,prove.nombre,prove.codigoCiudad,ciu.nombre as nomCiudad,"
           + "prove.direccion,prove.telefono,prove.email,prove.estado from "
           + "proveedores prove INNER JOIN ciudad ciu ON prove.codigoCiudad=ciu.codigoCiudad where "
           + "idProveedores="+idProveedores;
       System.out.println(sql);
       Conexion conectar=new Conexion();//utilizo mi clase conexion
       ResultSet rs;
        try {
          rs=conectar.consultar(sql);
          while(rs.next()){//recorre el resultset 
              Proveedor pro=new Proveedor();
              
              pro.setIdProveedor(rs.getInt("idProveedores"));
              pro.setNumeroIdentidad(rs.getString("numeroIdentidad"));              
              pro.setNombre(rs.getString("nombre"));
              pro.setCodigoCiudad(rs.getInt("codigoCiudad"));
              pro.setNomCiudad(rs.getString("nomCiudad"));
              pro.setDireccion(rs.getString("direccion"));
              pro.setTelefono(rs.getString("telefono"));
              pro.setEmail(rs.getString("email"));
              pro.setEstado(rs.getString("estado"));
              listado.add(pro);//en cada ciclo llenamos el array list con el obj
          }//fin while
        } catch (Exception e) {
            System.out.println("Error en la consulta: "+e);
            
        }
        return listado;
    } 
//     
     public ArrayList<Proveedor> BusquedaTiempoReal(String texto){
       ArrayList<Proveedor> listado=new ArrayList();
       String sql="";
       
           sql="Select prove.idProveedores,prove.numeroIdentidad,prove.nombre,prove.codigoCiudad,ciu.nombre as nomCiudad,"
           + "prove.direccion,prove.telefono,prove.email,prove.estado from "
               + "proveedores prove INNER JOIN ciudad ciu ON prove.codigoCiudad=ciu.codigoCiudad"
               + " WHERE prove.numeroIdentidad LIKE '%"+texto+"%' OR "
               + "UPPER(prove.nombre) LIKE UPPER('%"+texto+"%') OR UPPER(ciu.nombre) LIKE UPPER('%"+texto+"%') "
               + "OR prove.telefono LIKE '%"+texto+"%' OR UPPER(prove.direccion) LIKE UPPER('%"+texto+"%') "
               + "OR UPPER(prove.email) LIKE UPPER('%"+texto+"%') OR UPPER(prove.estado) LIKE UPPER('%"+texto+"%')"
               + " order by prove.nombre";           
          
            System.out.println(sql); 
            
       Conexion conectar=new Conexion();//utilizo mi clase conexion
       ResultSet rs;
        try {
          rs=conectar.consultar(sql);
          while(rs.next()){//recorre el resultset
              Proveedor pro=new Proveedor();
              
              pro.setIdProveedor(rs.getInt("idProveedores"));
              pro.setNumeroIdentidad(rs.getString("numeroIdentidad"));              
              pro.setNombre(rs.getString("nombre"));
              pro.setCodigoCiudad(rs.getInt("codigoCiudad"));
              pro.setNomCiudad(rs.getString("nomCiudad"));
              pro.setDireccion(rs.getString("direccion"));
              pro.setTelefono(rs.getString("telefono"));
              pro.setEmail(rs.getString("email"));
              pro.setEstado(rs.getString("estado"));
              listado.add(pro);//en cada ciclo llenamos el array list con el obj
          }//fin while
        } catch (Exception e) {
            System.out.println("Error en la consulta: "+e);
            
        }
        return listado;
    } 
//    
     public boolean guardar(Proveedor objProve){
        
        boolean var=false;
        Conexion conectar=new Conexion();//utilizo mi clase conexion
        String sql; 
       
        sql="INSERT INTO proveedores(numeroIdentidad,nombre,codigoCiudad,direccion,telefono,email,estado)"
            + " VALUES ('"+objProve.getNumeroIdentidad()+"','"
            +objProve.getNombre()+"',"+objProve.getCodigoCiudad()+",'"+objProve.getDireccion()+"','"
            +objProve.getTelefono()+"','"+objProve.getEmail()+"','"+objProve.getEstado()+"')";
        
         System.out.println(sql);
       
         try {
            if(conectar.ejecutar(sql)){
                var=true;
             }            
         } catch (Exception e) {
            System.out.println("Error en guardar "+e);
          }
      
       return var;
    }
    
    public boolean modificar(Proveedor objProve){ //
        
        boolean var=false;
        Conexion conectar=new Conexion();//utilizo mi clase conexion
        ResultSet rs1;
        String sql="";
        sql="UPDATE proveedores SET numeroIdentidad='"+objProve.getNumeroIdentidad()+"', nombre='"+objProve.getNombre()+"',codigoCiudad="
             +objProve.getCodigoCiudad()+",direccion='"+objProve.getDireccion()
             +"', telefono='"+objProve.getTelefono()+"',email='"+objProve.getEmail()+
             "',estado='"+objProve.getEstado()+"' WHERE idProveedores="+objProve.getIdProveedor();      
        System.out.println(sql);
        try{           
           if(conectar.ejecutar(sql)){
               var=true;
           }
        }catch(Exception e){
            System.out.println("Error en modificar "+e);
        }
     
        return var;
    }
//    
    public boolean eliminar(int codigo){
        boolean var=false;
        Conexion conectar=new Conexion();//utilizo mi clase conexion
        ResultSet rs; 
        String sql;
        sql="DELETE FROM proveedores WHERE idProveedores="+codigo;       
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
        Proveedor prove;//creo una referencia
        int tam=traerTodos().size();
        for (int i = 0; i < tam; i++) {
            prove = new Proveedor();//instancio el objeto 
            prove.setIdProveedor(traerTodos().get(i).getIdProveedor());
            prove.setNombre(traerTodos().get(i).getNombre());
            value.addElement(prove);
        }
    }
    
     
     //VALIDACIONES 
     
     public int existeNumeroID(String numeroIdentidad){//PARA BOTON GUARDAR       
       int existe=0;
       String sql;
       sql="SELECT count(numeroIdentidad) as hay FROM proveedores WHERE numeroIdentidad='"+numeroIdentidad+"'";
       Conexion conectar=new Conexion();//utilizo mi clase conexion
       ResultSet rs;
        try {
          rs=conectar.consultar(sql);
          while(rs.next()){//recorre el resultset 
             existe=rs.getInt("hay");
          }//fin while
        } catch (Exception e) {
            System.out.println("Error en la consulta: "+e);
            
        }
        return existe;
    }
    
     
      public int existeNumeroIDEditar(String numeroIdentidad,int idProveedores){//PARA BOTON EDITAR       
       int existe=0;
       String sql;
       sql="SELECT count(numeroIdentidad) as hay FROM proveedores WHERE numeroIdentidad='"+numeroIdentidad+"'"
        + " AND idProveedores<>"+idProveedores;
       Conexion conectar=new Conexion();//utilizo mi clase conexion
       ResultSet rs;
        try {
          rs=conectar.consultar(sql);
          while(rs.next()){//recorre el resultset 
             existe=rs.getInt("hay");
          }//fin while
        } catch (Exception e) {
            System.out.println("Error en la consulta: "+e);
            
        }
        return existe;
    }
     
       public boolean ValidarEmail(String email){
        boolean rpta=false; 
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"); 
         Matcher mather = pattern.matcher(email); 
        if (mather.find() == true) {
           rpta=true;
        }
        return rpta;
     } 
    
    
}
