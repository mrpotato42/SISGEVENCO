/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Conexion.Conexion;
import Modelo.Articulo;
import Modelo.SubLineaProducto;
import java.sql.ResultSet;
import java.util.ArrayList;


/**
 *
 * @author Leonardo
 */
public class CtrlArticulo {
   
    
      public ArrayList<Articulo> traerTodos(){//USADO EN LISTADOARTICULOGUI
       ArrayList<Articulo> listado=new ArrayList();
       String sql;
//       sql="Select arti.codigoArticulo,arti.nombreArticulo,arti.descripcion,arti.idProveedores, prove.nombre as nomProvee,"
//          + "arti.iva,arti.idSublinea,sli.sublineaDescripcion,arti.cantidad,arti.lote,arti.costo,arti.precioVenta,arti.utilidad,"
//          + "arti.estado from articulo arti INNER JOIN proveedores prove ON arti.idProveedores=prove.idProveedores INNER JOIN sublineaproducto sli"
//          + " ON arti.idSublinea=sli.idSublinea";//codigo bueno
        sql="Select arti.codigoArticulo,arti.nombreArticulo,arti.descripcion,arti.idProveedores, prove.nombre as nomProvee,"
          + "arti.iva,arti.idSublinea,sli.sublineaDescripcion,sli.idLinea,lp.lineaDescripcion,arti.cantidad,arti.lote,arti.costo,arti.precioVenta,arti.utilidad,"
          + "arti.estado from articulo arti INNER JOIN proveedores prove ON arti.idProveedores=prove.idProveedores INNER JOIN sublineaproducto sli"
          + " ON arti.idSublinea=sli.idSublinea INNER JOIN lineaProducto lp ON sli.idLinea=lp.idLinea WHERE arti.estado='Activo'";           


       System.out.println(sql);
       Conexion conectar=new Conexion();//utilizo mi clase conexion
       ResultSet rs;
        try {
          rs=conectar.consultar(sql);
          while(rs.next()){//recorre el resultset 
              Articulo a=new Articulo();              
              a.setCodigoArticulo(rs.getInt("codigoArticulo"));
              a.setNombreArticulo(rs.getString("nombreArticulo"));
              a.setDescripcion(rs.getString("descripcion"));
              a.setIdProveedores(rs.getInt("idProveedores"));
              a.setNomProvee(rs.getString("nomProvee"));
              a.setIva(rs.getDouble("iva"));
              
              SubLineaProducto objSLP=new SubLineaProducto();
              objSLP.setIdLinea(rs.getInt("idSublinea"));
              objSLP.setSubLineaDescripcion(rs.getString("sublineaDescripcion"));
              objSLP.setIdLinea(rs.getInt("idLinea"));
              objSLP.setDescLineaProd(rs.getString("lineaDescripcion"));
              a.setSublineaProducto(objSLP);
              
              a.setCantidad(rs.getInt("cantidad"));
              a.setLote(rs.getString("lote"));
              a.setCosto(rs.getDouble("costo"));
              a.setPrecioVenta(rs.getDouble("precioVenta"));
              a.setUtilidad(rs.getDouble("utilidad"));
              a.setEstado(rs.getString("estado"));
                                                 
              listado.add(a);//en cada ciclo llenamos el array list con el obj
          }//fin while
        } catch (Exception e) {
            System.out.println("Error en la consulta: "+e);
            
        }
        return listado;
    }
     
       public ArrayList<Articulo> traerTodosDos(){//USADO EN ARTICULOGUI
       ArrayList<Articulo> listado=new ArrayList();
       String sql;
//       sql="Select arti.codigoArticulo,arti.nombreArticulo,arti.descripcion,arti.idProveedores, prove.nombre as nomProvee,"
//          + "arti.iva,arti.idSublinea,sli.sublineaDescripcion,arti.cantidad,arti.lote,arti.costo,arti.precioVenta,arti.utilidad,"
//          + "arti.estado from articulo arti INNER JOIN proveedores prove ON arti.idProveedores=prove.idProveedores INNER JOIN sublineaproducto sli"
//          + " ON arti.idSublinea=sli.idSublinea";//codigo bueno
        sql="Select arti.codigoArticulo,arti.nombreArticulo,arti.descripcion,arti.idProveedores, prove.nombre as nomProvee,"
          + "arti.iva,arti.idSublinea,sli.sublineaDescripcion,sli.idLinea,lp.lineaDescripcion,arti.cantidad,arti.lote,arti.costo,arti.precioVenta,arti.utilidad,"
          + "arti.estado from articulo arti INNER JOIN proveedores prove ON arti.idProveedores=prove.idProveedores INNER JOIN sublineaproducto sli"
          + " ON arti.idSublinea=sli.idSublinea INNER JOIN lineaProducto lp ON sli.idLinea=lp.idLinea";           


       System.out.println(sql);
       Conexion conectar=new Conexion();//utilizo mi clase conexion
       ResultSet rs;
        try {
          rs=conectar.consultar(sql);
          while(rs.next()){//recorre el resultset 
              Articulo a=new Articulo();              
              a.setCodigoArticulo(rs.getInt("codigoArticulo"));
              a.setNombreArticulo(rs.getString("nombreArticulo"));
              a.setDescripcion(rs.getString("descripcion"));
              a.setIdProveedores(rs.getInt("idProveedores"));
              a.setNomProvee(rs.getString("nomProvee"));
              a.setIva(rs.getDouble("iva"));
              
              SubLineaProducto objSLP=new SubLineaProducto();
              objSLP.setIdLinea(rs.getInt("idSublinea"));
              objSLP.setSubLineaDescripcion(rs.getString("sublineaDescripcion"));
              objSLP.setIdLinea(rs.getInt("idLinea"));
              objSLP.setDescLineaProd(rs.getString("lineaDescripcion"));
              a.setSublineaProducto(objSLP);
              
              a.setCantidad(rs.getInt("cantidad"));
              a.setLote(rs.getString("lote"));
              a.setCosto(rs.getDouble("costo"));
              a.setPrecioVenta(rs.getDouble("precioVenta"));
              a.setUtilidad(rs.getDouble("utilidad"));
              a.setEstado(rs.getString("estado"));
                                                 
              listado.add(a);//en cada ciclo llenamos el array list con el obj
          }//fin while
        } catch (Exception e) {
            System.out.println("Error en la consulta: "+e);
            
        }
        return listado;
    }
      
      
     public ArrayList<Articulo> BusquedaTiempoReal(String texto){//USADO EN LISTADOARTICULOGUI
       ArrayList<Articulo> listado=new ArrayList();
       String sql="";
           sql="Select arti.codigoArticulo,arti.nombreArticulo,arti.descripcion,arti.idProveedores, prove.nombre as nomProvee,"
             + "arti.iva,arti.idSublinea,sli.sublineaDescripcion,arti.cantidad,arti.precioVenta"
             +" from articulo arti INNER JOIN proveedores prove ON arti.idProveedores=prove.idProveedores INNER JOIN sublineaproducto sli"
             +" ON arti.idSublinea=sli.idSublinea WHERE (arti.codigoArticulo LIKE '%"+texto+"%' "
             +"OR UPPER(arti.nombreArticulo) LIKE UPPER('%"+texto+"%') OR UPPER(arti.descripcion) LIKE UPPER('%"+texto+"%')"
             +" OR UPPER(prove.nombre) LIKE UPPER('%"+texto+"%') OR arti.iva LIKE '%"+texto+"%'"
             +" OR UPPER(sli.sublineaDescripcion) LIKE UPPER('%"+texto+"%') OR arti.cantidad LIKE '%"+texto+"%'"      
             +" OR arti.precioVenta LIKE '%"+texto+"%' OR UPPER(arti.lote) LIKE UPPER('%"+texto+"%') ) AND arti.estado='Activo'"
             + " order by arti.nombreArticulo";
             System.out.println(sql);    
       Conexion conectar=new Conexion();//utilizo mi clase conexion
       ResultSet rs;
        try {
          rs=conectar.consultar(sql);
          while(rs.next()){//recorre el resultset
             Articulo a=new Articulo();              
              a.setCodigoArticulo(rs.getInt("codigoArticulo"));
              a.setNombreArticulo(rs.getString("nombreArticulo"));
              a.setDescripcion(rs.getString("descripcion"));
              a.setNomProvee(rs.getString("nomProvee"));
              a.setIva(rs.getDouble("iva"));
              
              SubLineaProducto objSLP=new SubLineaProducto();
              objSLP.setSubLineaDescripcion(rs.getString("sublineaDescripcion"));
              a.setSublineaProducto(objSLP);
              
              a.setCantidad(rs.getInt("cantidad"));             
              a.setPrecioVenta(rs.getDouble("precioVenta"));
             
              
              listado.add(a);//en cada ciclo llenamos el array list con el obj
          }//fin while
        } catch (Exception e) {
            System.out.println("Error en la consulta: "+e);
            
        }
        return listado;
    } 
    
       public ArrayList<Articulo> BusquedaTiempoRealDos(String texto){//USADO EN ARTICULOGUI
       ArrayList<Articulo> listado=new ArrayList();
       String sql="";
           sql="Select arti.codigoArticulo,arti.nombreArticulo,arti.descripcion,arti.idProveedores, prove.nombre as nomProvee,"
             + "arti.iva,arti.idSublinea,sli.sublineaDescripcion,sli.idLinea,lp.lineaDescripcion,arti.cantidad,arti.lote,arti.costo,arti.precioVenta,arti.utilidad"
             +",arti.estado from articulo arti INNER JOIN proveedores prove ON arti.idProveedores=prove.idProveedores INNER JOIN sublineaproducto sli"
             +" ON arti.idSublinea=sli.idSublinea INNER JOIN lineaProducto lp ON sli.idLinea=lp.idLinea  WHERE arti.codigoArticulo LIKE '%"+texto+"%' "
             +"OR UPPER(arti.nombreArticulo) LIKE UPPER('%"+texto+"%') OR UPPER(arti.descripcion) LIKE UPPER('%"+texto+"%')"
             +" OR UPPER(prove.nombre) LIKE UPPER('%"+texto+"%') OR arti.iva LIKE '%"+texto+"%'"
             +" OR UPPER(sli.sublineaDescripcion) LIKE UPPER('%"+texto+"%')"
             + " OR UPPER(lp.lineaDescripcion) LIKE UPPER('%"+texto+"%') OR arti.cantidad LIKE '%"+texto+"%'"      
             +" OR arti.precioVenta LIKE '%"+texto+"%' OR UPPER(arti.lote) LIKE UPPER('%"+texto+"%')"
             + " OR UPPER(arti.estado) LIKE UPPER('%"+texto+"%') order by arti.nombreArticulo";
             System.out.println(sql);    
       Conexion conectar=new Conexion();//utilizo mi clase conexion
       ResultSet rs;
        try {
          rs=conectar.consultar(sql);
          while(rs.next()){//recorre el resultset
             Articulo a=new Articulo();              
              a.setCodigoArticulo(rs.getInt("codigoArticulo"));
              a.setNombreArticulo(rs.getString("nombreArticulo"));
              a.setDescripcion(rs.getString("descripcion"));
              a.setNomProvee(rs.getString("nomProvee"));
              a.setIva(rs.getDouble("iva"));
              
              SubLineaProducto objSLP=new SubLineaProducto();
              objSLP.setSubLineaDescripcion(rs.getString("sublineaDescripcion"));
              objSLP.setIdLinea(rs.getInt("idLinea"));
              objSLP.setDescLineaProd(rs.getString("lineaDescripcion"));
              a.setSublineaProducto(objSLP);
              
              a.setCantidad(rs.getInt("cantidad"));
              a.setLote(rs.getString("lote"));
              a.setCosto(rs.getDouble("costo"));
              a.setPrecioVenta(rs.getDouble("precioVenta"));
              a.setUtilidad(rs.getDouble("utilidad"));
              a.setEstado(rs.getString("estado"));
              
              listado.add(a);//en cada ciclo llenamos el array list con el obj
          }//fin while
        } catch (Exception e) {
            System.out.println("Error en la consulta: "+e);
            
        }
        return listado;
    } 
     
     
       public int cantidadEnExistencia(int codigoArticulo){
        
         int cantidad = 0;
         String sql = "";
         sql = "SELECT cantidad from articulo where codigoArticulo=" + codigoArticulo;
         System.out.println(sql);
         Conexion conectar = new Conexion();//utilizo mi clase conexion
         ResultSet rs;
         try {

             rs = conectar.consultar(sql);
             rs.next();//recorre el resultset
             cantidad = rs.getInt("cantidad");

         } catch (Exception e) {
             System.out.println("Error en la consulta: " + e);

         }
         return cantidad;
    } 
       
    public boolean guardar(Articulo objArti){
        
        boolean var=false;
        Conexion conectar=new Conexion();//utilizo mi clase conexion
        String sql; 
       
        sql="INSERT INTO articulo(nombreArticulo,descripcion,idProveedores,iva,"
                + "idSublinea,cantidad,lote,costo,precioVenta,utilidad,estado)"
                + " VALUES ('"+objArti.getNombreArticulo()+"','"
                +objArti.getDescripcion()+"',"+objArti.getIdProveedores()+","+objArti.getIva()+","
                +objArti.getSublineaProducto().getIdSubLinea()+","+objArti.getCantidad()+",'"+objArti.getLote()+
                "',"+objArti.getCosto()+","+objArti.getPrecioVenta()+","+
                objArti.getUtilidad()+",'"+objArti.getEstado()+"')";
        
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
    
    
       public ArrayList<Articulo> traerUnArticulo(int codigoArticulo){
       ArrayList<Articulo> listado=new ArrayList();
       String sql;
        sql="Select arti.codigoArticulo,arti.nombreArticulo,arti.descripcion,arti.idProveedores, prove.nombre as nomProvee,"
          + "arti.iva,arti.idSublinea,sli.sublineaDescripcion,sli.idLinea,lp.lineaDescripcion,arti.cantidad,arti.lote,arti.costo,arti.precioVenta,arti.utilidad"
          + ",arti.estado from articulo arti INNER JOIN proveedores prove ON arti.idProveedores=prove.idProveedores INNER JOIN sublineaproducto sli"
          + " ON arti.idSublinea=sli.idSublinea INNER JOIN lineaProducto lp ON sli.idLinea=lp.idLinea WHERE arti.codigoArticulo="+codigoArticulo;
       System.out.println(sql);
       Conexion conectar=new Conexion();//utilizo mi clase conexion
       ResultSet rs;
        try {
          rs=conectar.consultar(sql);
          while(rs.next()){//recorre el resultset 
             Articulo a=new Articulo();              
              a.setCodigoArticulo(rs.getInt("codigoArticulo"));
              a.setNombreArticulo(rs.getString("nombreArticulo"));
              a.setDescripcion(rs.getString("descripcion"));
              a.setIdProveedores(rs.getInt("idProveedores"));
              a.setNomProvee(rs.getString("nomProvee"));
              a.setIva(rs.getDouble("iva"));
              
              SubLineaProducto objSLP=new SubLineaProducto();
              objSLP.setIdLinea(rs.getInt("idSublinea"));
              objSLP.setSubLineaDescripcion(rs.getString("sublineaDescripcion"));
              objSLP.setIdLinea(rs.getInt("idLinea"));
              objSLP.setDescLineaProd(rs.getString("lineaDescripcion"));
              a.setSublineaProducto(objSLP);
              
              a.setCantidad(rs.getInt("cantidad"));
              a.setLote(rs.getString("lote"));
              a.setCosto(rs.getDouble("costo"));
              a.setPrecioVenta(rs.getDouble("precioVenta"));
              a.setUtilidad(rs.getDouble("utilidad"));
              a.setEstado(rs.getString("estado"));         
              listado.add(a);//en cada ciclo llenamos el array list con el obj
          }//fin while
        } catch (Exception e) {
            System.out.println("Error en la consulta: "+e);
            
        }
        return listado;
    } 
       
     public boolean modificar(Articulo objArti){ //
        
        boolean var=false;
        Conexion conectar=new Conexion();//utilizo mi clase conexion
        ResultSet rs1;
        String sql="";
        sql="UPDATE articulo SET nombreArticulo='"+objArti.getNombreArticulo()+"', descripcion='"+objArti.getDescripcion()+"',idProveedores="
                +objArti.getIdProveedores()+",iva="+objArti.getIva()+", idSublinea="+objArti.getSublineaProducto().getIdSubLinea()
                +", cantidad="+objArti.getCantidad()+",lote='"+objArti.getLote()
                +"', costo="+objArti.getCosto()+",precioVenta="+objArti.getPrecioVenta()+
                ",utilidad="+objArti.getUtilidad()+",estado='"+objArti.getEstado()+"' WHERE codigoArticulo="+objArti.getCodigoArticulo();      
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
        sql="DELETE FROM articulo WHERE codigoArticulo="+codigo;       
        try{
           if(conectar.ejecutar(sql)){
              var=true;           
            }
        }catch(Exception e){
            System.out.println(e);
        }
      return var;
    } 
    
    
    //ARTICULO MAS VENDIDO
    
    public String articuloMasVendido(){
       ArrayList<Articulo> listado=new ArrayList();
       String sql;
       String mensaje="";
       sql="SELECT dt.codigoArticulo, SUM(dt.cantidad) as can,a.nombreArticulo FROM detalleventa dt"+ 
            " INNER JOIN articulo a ON dt.codigoArticulo=a.codigoArticulo GROUP by dt.codigoArticulo order by can desc LIMIT 1";
              
       System.out.println(sql);
       Conexion conectar=new Conexion();//utilizo mi clase conexion
       ResultSet rs;
        try {
          rs=conectar.consultar(sql);
          while(rs.next()){//recorre el resultset 
       
             mensaje="<html><h1 style='color:green'>El Articulo "+rs.getString("nombreArticulo")+" es el mas Vendido!</h1><html>"
                     + "\n<html><h1 style='color:green'>Cantidad Vendidas="+rs.getInt("can")+"</h1><html>";
             
          }//fin while
        } catch (Exception e) {
            System.out.println("Error en la consulta: "+e);
            
        }
        return mensaje;
    }
    
    
   public boolean ActualizarIventarioArti(int codigo,int newCantidad){ //
        
        boolean var=false;
        Conexion conectar=new Conexion();//utilizo mi clase conexion
        
        String sql="";
        sql="UPDATE articulo SET cantidad="+newCantidad+" where codigoArticulo="+codigo;     
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
   
   
    
}
