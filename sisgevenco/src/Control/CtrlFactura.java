/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Conexion.Conexion;
import Modelo.Cliente;
import Modelo.Factura;
import Modelo.Usuario;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Leonardo
 */
public class CtrlFactura {
    
    public ArrayList<Factura> traerTodasLasFact(){//metodo solo usado en ReportFacturaGui
        
       ArrayList<Factura> listado=new ArrayList();
       String sql;
       sql="Select f.numeroDocumento,f.codigoDocumento,td.descripcion as descDocumento,f.fecha,f.hora,f.codigoCaja"
            + ",ca.descripcion,f.codigoCliente,cli.nombre,cli.apellido,cli.numeroDocumento as numDocuCli,f.idResolucionFactura,"
            + "rf.nroResolucionFactura,f.idUsuario,usu.primerNombre,usu.segundoNombre,usu.primerApellido,"
            +" usu.segundoApellido FROM factura f INNER JOIN tipoDocumento td ON f.codigoDocumento=td.codigoDocumento "
            +" INNER JOIN caja ca ON f.codigoCaja=ca.codigoCaja INNER JOIN cliente cli ON f.codigoCliente=cli.codigoCliente"
            +" INNER JOIN resolucionFactura rf ON f.idResolucionFactura=rf.idResolucionFactura INNER JOIN usuario usu "
            + "ON f.idUsuario=usu.idUsuario where f.codigoDocumento=1"; 
       
       
               
       System.out.println(sql);
       Conexion conectar=new Conexion();//utilizo mi clase conexion
       ResultSet rs;
        try {
          rs=conectar.consultar(sql);
          while(rs.next()){//recorre el resultset 
              Factura fac=new Factura();
              fac.setNumeroDocumento(rs.getInt("numeroDocumento"));
              fac.setCodigoDocumento(rs.getInt("codigoDocumento"));
              fac.setDescDocumento(rs.getString("descDocumento"));
              fac.setFecha(rs.getDate("fecha"));
              fac.setHora(rs.getTime("hora"));
              fac.setCodigoCaja(rs.getInt("codigoCaja"));
              fac.setDescCaja(rs.getString("descripcion"));              
                 Cliente c=new Cliente();
                 c.setCodigoCliente(rs.getInt("codigoCliente"));
                 c.setNombre(rs.getString("nombre"));
                 c.setApellido(rs.getString("apellido"));
                 c.setNumeroDocumento(rs.getString("numDocuCli"));
              fac.setCliente(c);
              fac.setIdResolucionFactura(rs.getInt("idResolucionFactura"));
              fac.setNroResolucionFactura(rs.getInt("nroResolucionFactura"));
                   Usuario u=new Usuario();
                   u.setIdUsuario(rs.getInt("idUsuario"));
                   u.setPrimerNombre(rs.getString("primerNombre"));
                   u.setSegundoNombre(rs.getString("segundoNombre"));
                   u.setPrimerApellido(rs.getString("primerApellido"));
                   u.setSegundoApellido(rs.getString("segundoApellido"));
               fac.setUsuario(u); 
               
              listado.add(fac);//en cada ciclo llenamos el array list con el obj
          }//fin while
        } catch (Exception e) {
            System.out.println("Error en la consulta: "+e);
            
        }
        return listado;
    }
    
    public ArrayList<Factura> traerTodasLasFactRango(String fechaIni, String fechaFin){//metodo solo usado en ReportFacturaGui por RANGO DE FECHA
        
       ArrayList<Factura> listado=new ArrayList();
       String sql;
       sql="Select f.numeroDocumento,f.codigoDocumento,td.descripcion as descDocumento,f.fecha,f.hora,f.codigoCaja"
            + ",ca.descripcion,f.codigoCliente,cli.nombre,cli.apellido,cli.numeroDocumento as numDocuCli,f.idResolucionFactura,"
            + "rf.nroResolucionFactura,f.idUsuario,usu.primerNombre,usu.segundoNombre,usu.primerApellido,"
            +" usu.segundoApellido FROM factura f INNER JOIN tipoDocumento td ON f.codigoDocumento=td.codigoDocumento "
            +" INNER JOIN caja ca ON f.codigoCaja=ca.codigoCaja INNER JOIN cliente cli ON f.codigoCliente=cli.codigoCliente"
            +" INNER JOIN resolucionFactura rf ON f.idResolucionFactura=rf.idResolucionFactura INNER JOIN usuario usu "
            + "ON f.idUsuario=usu.idUsuario where f.codigoDocumento=1 AND (f.fecha>='"+fechaIni+"' AND f.fecha<='"+fechaFin+"')"; 
       
       
               
       System.out.println(sql);
       Conexion conectar=new Conexion();//utilizo mi clase conexion
       ResultSet rs;
        try {
          rs=conectar.consultar(sql);
          while(rs.next()){//recorre el resultset 
              Factura fac=new Factura();
              fac.setNumeroDocumento(rs.getInt("numeroDocumento"));
              fac.setCodigoDocumento(rs.getInt("codigoDocumento"));
              fac.setDescDocumento(rs.getString("descDocumento"));
              fac.setFecha(rs.getDate("fecha"));
              fac.setHora(rs.getTime("hora"));
              fac.setCodigoCaja(rs.getInt("codigoCaja"));
              fac.setDescCaja(rs.getString("descripcion"));              
                 Cliente c=new Cliente();
                 c.setCodigoCliente(rs.getInt("codigoCliente"));
                 c.setNombre(rs.getString("nombre"));
                 c.setApellido(rs.getString("apellido"));
                 c.setNumeroDocumento(rs.getString("numDocuCli"));                 
              fac.setCliente(c);
              fac.setIdResolucionFactura(rs.getInt("idResolucionFactura"));
              fac.setNroResolucionFactura(rs.getInt("nroResolucionFactura"));
                   Usuario u=new Usuario();
                   u.setIdUsuario(rs.getInt("idUsuario"));
                   u.setPrimerNombre(rs.getString("primerNombre"));
                   u.setSegundoNombre(rs.getString("segundoNombre"));
                   u.setPrimerApellido(rs.getString("primerApellido"));
                   u.setSegundoApellido(rs.getString("segundoApellido"));
               fac.setUsuario(u); 
               
              listado.add(fac);//en cada ciclo llenamos el array list con el obj
          }//fin while
        } catch (Exception e) {
            System.out.println("Error en la consulta: "+e);
            
        }
        return listado;
    }
        
    
    
    public ArrayList<Factura> busquedaTiempoReal(String texto){// BUSCA FACTURAS EN ReporFacturaGui
        
       ArrayList<Factura> listado=new ArrayList();
       String sql;
       sql="Select f.numeroDocumento,f.codigoDocumento,td.descripcion as descDocumento,f.fecha,f.hora,f.codigoCaja"
         + ",ca.descripcion,f.codigoCliente,cli.nombre,cli.apellido,cli.numeroDocumento as numDocuCli,f.idResolucionFactura,"
         + "rf.nroResolucionFactura,f.idUsuario,usu.primerNombre,usu.segundoNombre,usu.primerApellido,"
         +" usu.segundoApellido from factura f INNER JOIN tipoDocumento td ON f.codigoDocumento=td.codigoDocumento "
         +" INNER JOIN caja ca ON f.codigoCaja=ca.codigoCaja INNER JOIN cliente cli ON f.codigoCliente=cli.codigoCliente"
         +" INNER JOIN resolucionFactura rf ON f.idResolucionFactura=rf.idResolucionFactura INNER JOIN "
         + "usuario usu ON f.idUsuario=usu.idUsuario WHERE "
         + " ( f.numeroDocumento LIKE '%"+texto+"%' OR UPPER(td.descripcion) LIKE UPPER('%"+texto+"%') OR UPPER(f.fecha) LIKE UPPER('%"+texto+"%') OR "
         + "UPPER(f.hora) LIKE UPPER('%"+texto+"%') OR UPPER(ca.descripcion) LIKE UPPER('%"+texto+"%') OR"
         +" UPPER(usu.primerNombre) LIKE UPPER('%"+texto+"%') OR UPPER(usu.primerApellido) LIKE UPPER('%"+texto+"%') OR"
         + " UPPER(cli.nombre) LIKE UPPER('%"+texto+"%') OR UPPER(cli.apellido) LIKE UPPER('%"+texto+"%') OR"
         + " cli.numeroDocumento LIKE '%"+texto+"%' OR UPPER(rf.nroResolucionFactura) LIKE UPPER('%"+texto+"%') ) AND f.codigoDocumento=1";      
               
       System.out.println(sql);
       Conexion conectar=new Conexion();//utilizo mi clase conexion
       ResultSet rs;
        try {
          rs=conectar.consultar(sql);
          while(rs.next()){//recorre el resultset 
              Factura fac=new Factura();
              fac.setNumeroDocumento(rs.getInt("numeroDocumento"));
              fac.setCodigoDocumento(rs.getInt("codigoDocumento"));
              fac.setDescDocumento(rs.getString("descDocumento"));
              fac.setFecha(rs.getDate("fecha"));
              fac.setHora(rs.getTime("hora"));
              fac.setCodigoCaja(rs.getInt("codigoCaja"));
              fac.setDescCaja(rs.getString("descripcion"));              
                 Cliente c=new Cliente();
                 c.setCodigoCliente(rs.getInt("codigoCliente"));
                 c.setNombre(rs.getString("nombre"));
                 c.setApellido(rs.getString("apellido"));
                 c.setNumeroDocumento(rs.getString("numDocuCli"));
              fac.setCliente(c);
              fac.setIdResolucionFactura(rs.getInt("idResolucionFactura"));
              fac.setNroResolucionFactura(rs.getInt("nroResolucionFactura"));
                   Usuario u=new Usuario();
                   u.setIdUsuario(rs.getInt("idUsuario"));
                   u.setPrimerNombre(rs.getString("primerNombre"));
                   u.setSegundoNombre(rs.getString("segundoNombre"));
                   u.setPrimerApellido(rs.getString("primerApellido"));
                   u.setSegundoApellido(rs.getString("segundoApellido"));
               fac.setUsuario(u); 
               
              listado.add(fac);//en cada ciclo llenamos el array list con el obj
          }//fin while
        } catch (Exception e) {
            System.out.println("Error en la consulta: "+e);
            
        }
        return listado;
    }
    
    public ArrayList<Factura> traerTodasLasCotiza(){//metodo solo usado en ReportCotizacionGui
        
       ArrayList<Factura> listado=new ArrayList();
       String sql;
       sql="Select f.numeroDocumento,f.codigoDocumento,td.descripcion as descDocumento,f.fecha,f.hora,f.codigoCaja"
            + ",ca.descripcion,f.codigoCliente,cli.nombre,cli.apellido,cli.numeroDocumento as numDocuCli,"
            + "f.idUsuario,usu.primerNombre,usu.segundoNombre,usu.primerApellido,"
            +" usu.segundoApellido FROM factura f INNER JOIN tipoDocumento td ON f.codigoDocumento=td.codigoDocumento "
            +" INNER JOIN caja ca ON f.codigoCaja=ca.codigoCaja INNER JOIN cliente cli ON f.codigoCliente=cli.codigoCliente"
            +" INNER JOIN usuario usu ON f.idUsuario=usu.idUsuario where f.codigoDocumento=2"; 
       System.out.println(sql);
       Conexion conectar=new Conexion();//utilizo mi clase conexion
       ResultSet rs;
        try {
          rs=conectar.consultar(sql);
          while(rs.next()){//recorre el resultset 
              Factura fac=new Factura();
              fac.setNumeroDocumento(rs.getInt("numeroDocumento"));
              fac.setCodigoDocumento(rs.getInt("codigoDocumento"));
              fac.setDescDocumento(rs.getString("descDocumento"));
              fac.setFecha(rs.getDate("fecha"));
              fac.setHora(rs.getTime("hora"));
              fac.setCodigoCaja(rs.getInt("codigoCaja"));
              fac.setDescCaja(rs.getString("descripcion"));              
                 Cliente c=new Cliente();
                 c.setCodigoCliente(rs.getInt("codigoCliente"));
                 c.setNombre(rs.getString("nombre"));                 
                 c.setApellido(rs.getString("apellido"));
                 c.setNumeroDocumento(rs.getString("numDocuCli"));
              fac.setCliente(c);
//              fac.setIdResolucionFactura(rs.getInt("idResolucionFactura"));
//              fac.setNroResolucionFactura(rs.getInt("nroResolucionFactura"));
                   Usuario u=new Usuario();
                   u.setIdUsuario(rs.getInt("idUsuario"));
                   u.setPrimerNombre(rs.getString("primerNombre"));
                   u.setSegundoNombre(rs.getString("segundoNombre"));
                   u.setPrimerApellido(rs.getString("primerApellido"));
                   u.setSegundoApellido(rs.getString("segundoApellido"));
               fac.setUsuario(u); 
               
              listado.add(fac);//en cada ciclo llenamos el array list con el obj
          }//fin while
        } catch (Exception e) {
            System.out.println("Error en la consulta: "+e);
            
        }
        return listado;
    }
    
    
     public ArrayList<Factura> busquedaTiempoRealCot(String texto){//usado en reporteCotizacionGui
        
       ArrayList<Factura> listado=new ArrayList();
       String sql;
       sql="Select f.numeroDocumento,f.codigoDocumento,td.descripcion as descDocumento,f.fecha,f.hora,f.codigoCaja"
         + ",ca.descripcion,f.codigoCliente,cli.nombre,cli.apellido,cli.numeroDocumento as numDocuCli,f.idResolucionFactura,"
         + "f.idUsuario,usu.primerNombre,usu.segundoNombre,usu.primerApellido,"
         +" usu.segundoApellido from factura f INNER JOIN tipoDocumento td ON f.codigoDocumento=td.codigoDocumento "
         +" INNER JOIN caja ca ON f.codigoCaja=ca.codigoCaja INNER JOIN cliente cli ON f.codigoCliente=cli.codigoCliente"
         +" INNER JOIN usuario usu ON f.idUsuario=usu.idUsuario WHERE "
         + " (f.numeroDocumento LIKE '%"+texto+"%' OR UPPER(td.descripcion) LIKE UPPER('%"+texto+"%') OR UPPER(f.fecha) LIKE UPPER('%"+texto+"%') OR "
         + "UPPER(f.hora) LIKE UPPER('%"+texto+"%') OR UPPER(ca.descripcion) LIKE UPPER('%"+texto+"%') OR"
         +" UPPER(usu.primerNombre) LIKE ('%"+texto+"%') OR UPPER(usu.primerApellido) LIKE UPPER('%"+texto+"%') OR"
         + " UPPER(cli.nombre) LIKE UPPER('%"+texto+"%') OR UPPER(cli.apellido) LIKE UPPER('%"+texto+"%') OR cli.numeroDocumento LIKE '%"+texto+"%' "
         + ") AND f.codigoDocumento=2";      
               
       System.out.println(sql);
       Conexion conectar=new Conexion();//utilizo mi clase conexion
       ResultSet rs;
        try {
          rs=conectar.consultar(sql);
          while(rs.next()){//recorre el resultset 
              Factura fac=new Factura();
              fac.setNumeroDocumento(rs.getInt("numeroDocumento"));
              fac.setCodigoDocumento(rs.getInt("codigoDocumento"));
              fac.setDescDocumento(rs.getString("descDocumento"));
              fac.setFecha(rs.getDate("fecha"));
              fac.setHora(rs.getTime("hora"));
              fac.setCodigoCaja(rs.getInt("codigoCaja"));
              fac.setDescCaja(rs.getString("descripcion"));              
                 Cliente c=new Cliente();
                 c.setCodigoCliente(rs.getInt("codigoCliente"));
                 c.setNombre(rs.getString("nombre"));
                 c.setApellido(rs.getString("apellido"));
                 c.setNumeroDocumento(rs.getString("numDocuCli"));
              fac.setCliente(c);
//              fac.setIdResolucionFactura(rs.getInt("idResolucionFactura"));
//              fac.setNroResolucionFactura(rs.getInt("nroResolucionFactura"));
                   Usuario u=new Usuario();
                   u.setIdUsuario(rs.getInt("idUsuario"));
                   u.setPrimerNombre(rs.getString("primerNombre"));
                   u.setSegundoNombre(rs.getString("segundoNombre"));
                   u.setPrimerApellido(rs.getString("primerApellido"));
                   u.setSegundoApellido(rs.getString("segundoApellido"));
               fac.setUsuario(u); 
               
              listado.add(fac);//en cada ciclo llenamos el array list con el obj
          }//fin while
        } catch (Exception e) {
            System.out.println("Error en la consulta: "+e);
            
        }
        return listado;
    }
    
     public ArrayList<Factura> traerTodasLasCotiRango(String fechaIni, String fechaFin){//metodo solo usado en ReportCotizacionGui por RANGO DE FECHA
        
       ArrayList<Factura> listado=new ArrayList();
       String sql;
       sql="Select f.numeroDocumento,f.codigoDocumento,td.descripcion as descDocumento,f.fecha,f.hora,f.codigoCaja"
            + ",ca.descripcion,f.codigoCliente,cli.nombre,cli.apellido,cli.numeroDocumento as numDocuCli,"
            + "f.idUsuario,usu.primerNombre,usu.segundoNombre,usu.primerApellido,"
            +" usu.segundoApellido FROM factura f INNER JOIN tipoDocumento td ON f.codigoDocumento=td.codigoDocumento "
            +" INNER JOIN caja ca ON f.codigoCaja=ca.codigoCaja INNER JOIN cliente cli ON f.codigoCliente=cli.codigoCliente"
            +" INNER JOIN usuario usu ON f.idUsuario=usu.idUsuario where f.codigoDocumento=2 AND (f.fecha>='"+fechaIni+"' AND f.fecha<='"+fechaFin+"')"; 
              
       System.out.println(sql);
       Conexion conectar=new Conexion();//utilizo mi clase conexion
       ResultSet rs;
        try {
          rs=conectar.consultar(sql);
          while(rs.next()){//recorre el resultset 
               Factura fac=new Factura();
              fac.setNumeroDocumento(rs.getInt("numeroDocumento"));
              fac.setCodigoDocumento(rs.getInt("codigoDocumento"));
              fac.setDescDocumento(rs.getString("descDocumento"));
              fac.setFecha(rs.getDate("fecha"));
              fac.setHora(rs.getTime("hora"));
              fac.setCodigoCaja(rs.getInt("codigoCaja"));
              fac.setDescCaja(rs.getString("descripcion"));              
                 Cliente c=new Cliente();
                 c.setCodigoCliente(rs.getInt("codigoCliente"));
                 c.setNombre(rs.getString("nombre"));
                 c.setApellido(rs.getString("apellido"));
                 c.setNumeroDocumento(rs.getString("numDocuCli"));
              fac.setCliente(c);
//              fac.setIdResolucionFactura(rs.getInt("idResolucionFactura"));
//              fac.setNroResolucionFactura(rs.getInt("nroResolucionFactura"));
                   Usuario u=new Usuario();
                   u.setIdUsuario(rs.getInt("idUsuario"));
                   u.setPrimerNombre(rs.getString("primerNombre"));
                   u.setSegundoNombre(rs.getString("segundoNombre"));
                   u.setPrimerApellido(rs.getString("primerApellido"));
                   u.setSegundoApellido(rs.getString("segundoApellido"));
               fac.setUsuario(u); 
               
              listado.add(fac);//en cada ciclo llenamos el array list con el obj
          }//fin while
        } catch (Exception e) {
            System.out.println("Error en la consulta: "+e);
            
        }
        return listado;
    } 
    
    public boolean guardar(Factura f){              
        String sql;  
        boolean val=false;
                    
           if(f.getIdResolucionFactura()==0){
               sql="INSERT INTO factura values("+f.getNumeroDocumento()+","+f.getCodigoDocumento()+
                  ",'"+f.getFecha()+"','"+f.getHora()+"',"+f.getCodigoCaja()+","+f.getCliente().getCodigoCliente()+
                  ","+null+","+f.getUsuario().getIdUsuario()+")";  
           }else{          
               sql="INSERT INTO factura values("+f.getNumeroDocumento()+","+f.getCodigoDocumento()+
                  ",'"+f.getFecha()+"','"+f.getHora()+"',"+f.getCodigoCaja()+","+f.getCliente().getCodigoCliente()+
                  ","+f.getIdResolucionFactura()+","+f.getUsuario().getIdUsuario()+")"; 
           }
        System.out.println(sql);      
        Conexion conectar=new Conexion();//utilizo mi clase conexion
        try {
           if(conectar.ejecutar(sql)){
               val=true;
           }                     
        } catch (Exception e) {
            System.out.println("Error en guardar "+e);
        }
        
        return val;
    }
    
    public int ConsecutivoCodigoDB(){
       String sql;
       int codigo=0;
       sql="select numeroDocumento from factura order by numeroDocumento DESC limit 1";
       Conexion conectar=new Conexion();//utilizo mi clase conexion
       ResultSet rs;
        try {
          rs=conectar.consultar(sql);          
          if(rs.next()){//recorre el resultset
             codigo=rs.getInt("numeroDocumento")+1;
          }else{
              codigo=1;//esto es en caso que no haya registro en la BD
          }
        } catch (Exception e) {
            System.out.println("Error en la consulta consecutivo: "+e);            
        }
        return codigo;
    }
      
}
