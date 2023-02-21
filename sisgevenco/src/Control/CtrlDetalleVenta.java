/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Conexion.Conexion;
import Modelo.DetalleVenta;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Leonardo
 */
public class CtrlDetalleVenta {
    
    
    public boolean guardar(DetalleVenta dv){              
        String sql;  
        boolean val=false;
          sql="INSERT INTO detalleventa values("+dv.getNumeroDocumento()+","+dv.getCodigoArticulo()+
                  ","+dv.getCantidad()+","+dv.getIva()+","+dv.getTotal()+")";          
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
    
      public ArrayList<DetalleVenta> traerDetalleVenta(int numeroDocumento){
       ArrayList<DetalleVenta> listado=new ArrayList();
       String sql;       
       sql="Select dv.numeroDocumento, dv.codigoArticulo,a.nombreArticulo,a.precioVenta, dv.cantidad, dv.iva"
            + ",dv.total  from detalleventa dv INNER JOIN articulo a "
            + "ON dv.codigoArticulo=a.codigoArticulo"
            + " where dv.numeroDocumento="+numeroDocumento;
       System.out.println(sql);
       Conexion conectar=new Conexion();//utilizo mi clase conexion
       ResultSet rs;
        try {
          rs=conectar.consultar(sql);
          while(rs.next()){//recorre el resultset 
              DetalleVenta dt=new DetalleVenta();
                    dt.setNomArticulo(rs.getString("nombreArticulo"));
                    dt.setPrecioVenta(rs.getDouble("precioVenta"));                    
                    dt.setCantidad(rs.getInt("cantidad"));
//                    dt.setPorcentajeDescuento(rs.getDouble("porcentajeDescuento"));
//                    dt.setTotalDescuento(rs.getDouble("totalDescuento"));
                    dt.setIva(rs.getDouble("iva"));
                    dt.setTotal(rs.getDouble("total"));                                       
                                      
              listado.add(dt);//en cada ciclo llenamos el array list con el obj
          }//fin while
        } catch (Exception e) {
            System.out.println("Error en la consulta: "+e);
            
        }
        return listado;
    } 
    
    
}
