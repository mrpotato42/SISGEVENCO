/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Conexion.Conexion;
import Modelo.ResolucionFactura;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Leonardo
 */
public class CtrlResolucionFactura {
    
    
    public ArrayList<ResolucionFactura> traer(){
       ArrayList<ResolucionFactura> listado=new ArrayList();
       String sql;
       sql="Select * from resolucionfactura";
       Conexion conectar=new Conexion();//utilizo mi clase conexion
       ResultSet rs;
        try {
          rs=conectar.consultar(sql);
          while(rs.next()){//recorre el resultset 
              ResolucionFactura rf=new ResolucionFactura();
              rf.setIdResolucionFactura(rs.getInt("idResolucionFactura"));
              rf.setNroResolucionFactura(rs.getInt("nroResolucionFactura"));
              rf.setFecha(rs.getDate("fecha"));
              rf.setFechaInicio(rs.getDate("fechaInicio"));
              rf.setFechaFin(rs.getDate("fechaFin"));
               listado.add(rf);//en cada ciclo llenamos el array list con el obj
          }//fin while
        } catch (Exception e) {
            System.out.println("Error en la consulta: "+e);
            
        }
        return listado;
    }
    
    
     public ArrayList<ResolucionFactura> listadoResolucionFactura() {// by taky

        ArrayList<ResolucionFactura> listado = new ArrayList();
        String sql;
        sql = "SELECT * FROM resolucionfactura";
        System.out.println("consulta tipo: " + sql);
        Conexion conectar = new Conexion();
        ResultSet rs;
        try {
            rs = conectar.consultar(sql);
            while (rs.next()) {
                ResolucionFactura objResoFac = new ResolucionFactura();

                objResoFac.setIdResolucionFactura(rs.getInt("IdResolucionFactura"));
                objResoFac.setNroResolucionFactura(rs.getInt("nroResolucionFactura"));
                objResoFac.setFecha(rs.getDate("Fecha"));
                objResoFac.setFechaInicio(rs.getDate("FechaInicio"));
                objResoFac.setFechaFin(rs.getDate("FechaFin"));
                listado.add(objResoFac);

            }
        } catch (Exception e) {
            System.out.println("Error en consulta" + e);
        }
        return listado;
    }
    
    public boolean agregar(ResolucionFactura objResoFac) {// by taky

        boolean var = false;
        String sql;
        sql = "INSERT INTO resolucionfactura(nroResolucionFactura,fecha,fechaInicio,fechaFin) VALUES"
                + " ("+ objResoFac.getNroResolucionFactura()+ ", '"+objResoFac.getFecha()+ "', '" + objResoFac.getFechaInicio()+ "', '"
                + objResoFac.getFechaFin()+"')";

        System.out.println("agregar resolucion: " + sql);
        Conexion conectar = new Conexion();

        try {
            var = conectar.ejecutar(sql);
        } catch (Exception e) {
            System.out.println("Error en agregar" + e);
        }
        return var;
    }
    
    public boolean modificar(ResolucionFactura objResoFac) {// by taky

        boolean var = false;
        String sql;
        sql = "UPDATE resolucionfactura SET  nroResolucionFactura= "+objResoFac.getNroResolucionFactura()+",Fecha='" + objResoFac.getFecha()+ "', FechaInicio='" + objResoFac.getFechaInicio()+ "', "
                + "FechaFin='" + objResoFac.getFechaFin()+ "' WHERE idResolucionFactura=" + objResoFac.getIdResolucionFactura();

        System.out.println("agregar tipo: " + sql);
        Conexion conectar = new Conexion();

        try {
            var = conectar.ejecutar(sql);
        } catch (Exception e) {
            System.out.println("Error en agregar" + e);
        }
        return var;
    }
    
    public boolean borrar(int id) {// by taky

        boolean var = false;
        String sql;
        sql = "DELETE FROM resolucionfactura WHERE IdResolucionFactura=" + id;

        System.out.println("borrar Resolucion: " + sql);
        Conexion conectar = new Conexion();

        try {
            var = conectar.ejecutar(sql);
        } catch (Exception e) {
            System.out.println("Error en borrar" + e);
        }
        return var;
    }
    
    
    
  public void cargarCB(javax.swing.JComboBox jcbx){
    DefaultComboBoxModel value=new DefaultComboBoxModel();//Construye un objeto DefaultComboBoxModel vacío.
    //jcbx.removeAllItems();//deja el combobox vacio listo para cargar lo que viene de la BD, en este caso no hace falta
    //abajo con setModel se setea los valores del comobox, asi en la ventana aparezca item1,item2...
    jcbx.setModel(value);//Establece el modelo de datos que JComboBox utiliza para obtener la lista de elementos.
    ResolucionFactura rf;//creo una referencia de tipoDocumento
    
      for(int i=0;i<traer().size();i++){ 
        rf=new ResolucionFactura();//instancio el objeto tipodocumento
        rf.setIdResolucionFactura(traer().get(i).getIdResolucionFactura());
        rf.setNroResolucionFactura(traer().get(i).getNroResolucionFactura());
        
        value.addElement(rf);
      }           
}  
}
