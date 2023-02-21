/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Conexion.Conexion;
import Modelo.Cliente;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Leonardo
 */
public class CtrlCliente {
    
     public ArrayList<Cliente> traerTodos(){//VENTANA LISTADOCLIENTEGUI
       ArrayList<Cliente> listado=new ArrayList();
       String sql;
       sql="Select cli.codigoCliente,cli.idTipoIdentidad,ti.nombreTipoIdentidad,cli.numeroDocumento,cli.nombre,cli.apellido,cli.genero,cli.fechaNacimiento,"
               + "cli.direccion,cli.telefono,cli.email,cli.codigociudad,ciu.nombre as nombreCiu,cli.estado from "
               + "cliente cli INNER JOIN tipoidentidad ti ON cli.idTipoIdentidad=ti.idTipoIdentidad INNER JOIN ciudad ciu ON cli.codigoCiudad=ciu.codigoCiudad"
               + " WHERE cli.estado='Activo'";
               
       System.out.println(sql);
       Conexion conectar=new Conexion();//utilizo mi clase conexion
       ResultSet rs;
        try {
          rs=conectar.consultar(sql);
          while(rs.next()){//recorre el resultset 
              Cliente c=new Cliente();
              c.setCodigoCliente(rs.getInt("codigoCliente"));
              c.setIdTipoIdentidad(rs.getInt("idTipoIdentidad"));              
              c.setNombreTipoIdentidad(rs.getString("nombreTipoIdentidad"));
              c.setNumeroDocumento(rs.getString("numeroDocumento"));              
              c.setNombre(rs.getString("nombre"));
              c.setApellido(rs.getString("apellido"));
              c.setGenero(rs.getString("genero"));
              c.setFechaNacimiento(rs.getDate("fechaNacimiento"));
              c.setDireccion(rs.getString("direccion"));
              c.setTelefono(rs.getString("telefono"));
              c.setEmail(rs.getString("email"));
              c.setCodigoCiudad(rs.getInt("codigoCiudad"));
              c.setNombreCiu(rs.getString("nombreCiu"));
              c.setEstado(rs.getString("estado"));
                       
              listado.add(c);//en cada ciclo llenamos el array list con el obj
          }//fin while
        } catch (Exception e) {
            System.out.println("Error en la consulta: "+e);
            
        }
        return listado;
    }
     
     
    public ArrayList<Cliente> traerTodosDos(){//VENTANA CLIENTEGUI
       ArrayList<Cliente> listado=new ArrayList();
       String sql;
       sql="Select cli.codigoCliente,cli.idTipoIdentidad,ti.nombreTipoIdentidad,cli.numeroDocumento,cli.nombre,cli.apellido,cli.genero,cli.fechaNacimiento,"
               + "cli.direccion,cli.telefono,cli.email,cli.codigociudad,ciu.nombre as nombreCiu,cli.estado from "
               + "cliente cli INNER JOIN tipoidentidad ti ON cli.idTipoIdentidad=ti.idTipoIdentidad INNER JOIN ciudad ciu ON cli.codigoCiudad=ciu.codigoCiudad";
               
       System.out.println(sql);
       Conexion conectar=new Conexion();//utilizo mi clase conexion
       ResultSet rs;
        try {
          rs=conectar.consultar(sql);
          while(rs.next()){//recorre el resultset 
              Cliente c=new Cliente();
              c.setCodigoCliente(rs.getInt("codigoCliente"));
              c.setIdTipoIdentidad(rs.getInt("idTipoIdentidad"));              
              c.setNombreTipoIdentidad(rs.getString("nombreTipoIdentidad"));
              c.setNumeroDocumento(rs.getString("numeroDocumento"));              
              c.setNombre(rs.getString("nombre"));
              c.setApellido(rs.getString("apellido"));
              c.setGenero(rs.getString("genero"));
              c.setFechaNacimiento(rs.getDate("fechaNacimiento"));
              c.setDireccion(rs.getString("direccion"));
              c.setTelefono(rs.getString("telefono"));
              c.setEmail(rs.getString("email"));
              c.setCodigoCiudad(rs.getInt("codigoCiudad"));
              c.setNombreCiu(rs.getString("nombreCiu"));
              c.setEstado(rs.getString("estado"));
                       
              listado.add(c);//en cada ciclo llenamos el array list con el obj
          }//fin while
        } catch (Exception e) {
            System.out.println("Error en la consulta: "+e);
            
        }
        return listado;
    }
      
     
    public ArrayList<Cliente> traerUnCliente(int codigoCliente){
       ArrayList<Cliente> listado=new ArrayList();
       String sql;
       sql="Select cli.codigoCliente,cli.idTipoIdentidad,ti.nombreTipoIdentidad,cli.numeroDocumento,cli.nombre,cli.apellido,cli.genero,cli.fechaNacimiento,"
               + "cli.direccion,cli.telefono,cli.email,cli.codigociudad,ciu.nombre as nombreCiu,cli.estado from "
               + "cliente cli INNER JOIN tipoidentidad ti ON cli.idTipoIdentidad=ti.idTipoIdentidad INNER JOIN ciudad ciu ON cli.codigoCiudad=ciu.codigoCiudad"
               + " where cli.codigoCliente="+codigoCliente;
       System.out.println(sql);
       Conexion conectar=new Conexion();//utilizo mi clase conexion
       ResultSet rs;
        try {
          rs=conectar.consultar(sql);
          while(rs.next()){//recorre el resultset 
              Cliente c=new Cliente();
              c.setCodigoCliente(rs.getInt("codigoCliente"));
              c.setIdTipoIdentidad(rs.getInt("idTipoIdentidad"));              
              c.setNombreTipoIdentidad(rs.getString("nombreTipoIdentidad"));
              c.setNumeroDocumento(rs.getString("numeroDocumento"));              
              c.setNombre(rs.getString("nombre"));
              c.setApellido(rs.getString("apellido"));
              c.setGenero(rs.getString("genero"));
              c.setFechaNacimiento(rs.getDate("fechaNacimiento"));
              c.setDireccion(rs.getString("direccion"));
              c.setTelefono(rs.getString("telefono"));
              c.setEmail(rs.getString("email"));             
              c.setCodigoCiudad(rs.getInt("codigoCiudad"));
              c.setNombreCiu(rs.getString("nombreCiu"));
              c.setEstado(rs.getString("estado"));
                       
              listado.add(c);//en cada ciclo llenamos el array list con el obj
          }//fin while
        } catch (Exception e) {
            System.out.println("Error en la consulta: "+e);
            
        }
        return listado;
    } 
     
     public ArrayList<Cliente> BusquedaTiempoReal(String texto){//PARA VENTANA LISTADOCLIENTEGUI
       ArrayList<Cliente> listado=new ArrayList();
       String sql="";
       
           sql="Select cli.codigoCliente,cli.idTipoIdentidad,ti.nombreTipoIdentidad,cli.numeroDocumento,cli.nombre,cli.apellido,cli.genero,cli.fechaNacimiento,"
               + "cli.direccion,cli.telefono,cli.email,cli.codigociudad,ciu.nombre as nombreCiu,cli.estado from "
               + "cliente cli INNER JOIN tipoidentidad ti ON cli.idTipoIdentidad=ti.idTipoIdentidad INNER JOIN ciudad ciu ON cli.codigoCiudad=ciu.codigoCiudad"
               + " WHERE ( UPPER(cli.nombre) LIKE UPPER('%"+texto+"%') OR "
               + "UPPER(cli.apellido) LIKE UPPER('%"+texto+"%') OR UPPER(ti.nombreTipoIdentidad) LIKE UPPER('%"+texto+"%') "
               + "OR cli.numeroDocumento LIKE '%"+texto+"%' OR UPPER(cli.genero) LIKE UPPER('%"+texto+"%') "
               + "OR UPPER(cli.email) LIKE UPPER('%"+texto+"%') OR UPPER(ciu.nombre) LIKE UPPER('%"+texto+"%')"
               + " OR UPPER(cli.estado) LIKE UPPER('%"+texto+"%') ) AND cli.estado='Activo' order by cli.nombre";           
          
            System.out.println(sql); 
            
       Conexion conectar=new Conexion();//utilizo mi clase conexion
       ResultSet rs;
        try {
          rs=conectar.consultar(sql);
          while(rs.next()){//recorre el resultset
              Cliente c=new Cliente();
              c.setCodigoCliente(rs.getInt("codigoCliente"));
              c.setIdTipoIdentidad(rs.getInt("idTipoIdentidad"));              
              c.setNombreTipoIdentidad(rs.getString("nombreTipoIdentidad"));
              c.setNumeroDocumento(rs.getString("numeroDocumento"));              
              c.setNombre(rs.getString("nombre"));
              c.setApellido(rs.getString("apellido"));
              c.setGenero(rs.getString("genero"));
              c.setFechaNacimiento(rs.getDate("fechaNacimiento"));
              c.setDireccion(rs.getString("direccion"));
              c.setTelefono(rs.getString("telefono"));
              c.setEmail(rs.getString("email"));
              c.setCodigoCiudad(rs.getInt("codigoCiudad"));
              c.setNombreCiu(rs.getString("nombreCiu"));
              c.setEstado(rs.getString("estado"));
              
              listado.add(c);//en cada ciclo llenamos el array list con el obj
          }//fin while
        } catch (Exception e) {
            System.out.println("Error en la consulta: "+e);
            
        }
        return listado;
    } 
    
      public ArrayList<Cliente> BusquedaTiempoRealDos(String texto){//PARA VENTANA CLIENTEGUI
       ArrayList<Cliente> listado=new ArrayList();
       String sql="";
       
           sql="Select cli.codigoCliente,cli.idTipoIdentidad,ti.nombreTipoIdentidad,cli.numeroDocumento,cli.nombre,cli.apellido,cli.genero,cli.fechaNacimiento,"
               + "cli.direccion,cli.telefono,cli.email,cli.codigociudad,ciu.nombre as nombreCiu,cli.estado from "
               + "cliente cli INNER JOIN tipoidentidad ti ON cli.idTipoIdentidad=ti.idTipoIdentidad INNER JOIN ciudad ciu ON cli.codigoCiudad=ciu.codigoCiudad"
               + " WHERE  UPPER(cli.nombre) LIKE UPPER('%"+texto+"%') OR "
               + "UPPER(cli.apellido) LIKE UPPER('%"+texto+"%') OR UPPER(ti.nombreTipoIdentidad) LIKE UPPER('%"+texto+"%') "
               + "OR cli.numeroDocumento LIKE '%"+texto+"%' OR UPPER(cli.genero) LIKE UPPER('%"+texto+"%') "
               + "OR UPPER(cli.email) LIKE UPPER('%"+texto+"%') OR UPPER(ciu.nombre) LIKE UPPER('%"+texto+"%')"
               + " OR UPPER(cli.estado) LIKE UPPER('%"+texto+"%')  order by cli.nombre";           
          
            System.out.println(sql); 
            
       Conexion conectar=new Conexion();//utilizo mi clase conexion
       ResultSet rs;
        try {
          rs=conectar.consultar(sql);
          while(rs.next()){//recorre el resultset
              Cliente c=new Cliente();
              c.setCodigoCliente(rs.getInt("codigoCliente"));
              c.setIdTipoIdentidad(rs.getInt("idTipoIdentidad"));              
              c.setNombreTipoIdentidad(rs.getString("nombreTipoIdentidad"));
              c.setNumeroDocumento(rs.getString("numeroDocumento"));              
              c.setNombre(rs.getString("nombre"));
              c.setApellido(rs.getString("apellido"));
              c.setGenero(rs.getString("genero"));
              c.setFechaNacimiento(rs.getDate("fechaNacimiento"));
              c.setDireccion(rs.getString("direccion"));
              c.setTelefono(rs.getString("telefono"));
              c.setEmail(rs.getString("email"));
              c.setCodigoCiudad(rs.getInt("codigoCiudad"));
              c.setNombreCiu(rs.getString("nombreCiu"));
              c.setEstado(rs.getString("estado"));
              
              listado.add(c);//en cada ciclo llenamos el array list con el obj
          }//fin while
        } catch (Exception e) {
            System.out.println("Error en la consulta: "+e);
            
        }
        return listado;
    } 
     
     
     public boolean guardar(Cliente objC){
        
        boolean var=false;
        Conexion conectar=new Conexion();//utilizo mi clase conexion
        String sql; 
        String sqlE;
        sql="INSERT INTO cliente(idTipoIdentidad,numeroDocumento, nombre, apellido,"
                + "genero, fechaNacimiento, direccion, telefono, email,codigoCiudad,estado)"
                + " VALUES ("+objC.getIdTipoIdentidad()+",'"
                +objC.getNumeroDocumento()+"','"+objC.getNombre()+"','"+objC.getApellido()+"','"
                +objC.getGenero()+"','"+objC.getFechaNacimiento()+"','"+objC.getDireccion()+
                "','"+objC.getTelefono()+"','"+objC.getEmail()+"',"+
                objC.getCodigoCiudad()+",'"+objC.getEstado()+"')";
        
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
    
    public boolean modificar(Cliente objC){ //
        
        boolean var=false;
        Conexion conectar=new Conexion();//utilizo mi clase conexion
        ResultSet rs1;
        String sql="";
        sql="UPDATE cliente SET idTipoIdentidad="+objC.getIdTipoIdentidad()+", numeroDocumento='"+objC.getNumeroDocumento()+"',nombre='"
                +objC.getNombre()+"',apellido='"+objC.getApellido()+"', genero='"+objC.getGenero()
                +"', fechaNacimiento='"+objC.getFechaNacimiento()+"',direccion='"+objC.getDireccion()
                +"', telefono='"+objC.getTelefono()+"',email='"+objC.getEmail()+
                "',codigoCiudad="+objC.getCodigoCiudad()+",estado='"+objC.getEstado()+"' WHERE codigoCliente="+objC.getCodigoCliente();      
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
    
    public boolean eliminar(int codigo){
        boolean var=false;
        Conexion conectar=new Conexion();//utilizo mi clase conexion
        ResultSet rs; 
        String sql;
        sql="DELETE FROM cliente WHERE codigoCliente="+codigo;       
        try{
           if(conectar.ejecutar(sql)){
              var=true;           
            }
        }catch(Exception e){
            System.out.println(e);
        }
      return var;
    } 
    
     //VALIDACIONES 
     
     public int existeNumeroID(String numeroDocumento){//PARA BOTON GUARDAR       
       int existe=0;
       String sql;
       sql="SELECT count(numeroDocumento) as hay FROM cliente WHERE numeroDocumento='"+numeroDocumento+"'";
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
    
     
      public int existeNumeroIDEditar(String numeroDocumento,int codigoCliente){//PARA BOTON EDITAR       
       int existe=0;
       String sql;
       sql="SELECT count(numeroDocumento) as hay FROM cliente WHERE numeroDocumento='"+numeroDocumento
        + "' AND codigoCliente<>"+codigoCliente;
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
