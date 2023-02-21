/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Conexion.Conexion;
import Modelo.Caja;
import Modelo.TurnoCaja;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;


/**
 *
 * @author Leonardo
 */
public class CtrlCaja {
    
    public ArrayList<Caja> traer(){
       ArrayList<Caja> listado=new ArrayList();
       String sql;
       sql="Select * from caja";
       Conexion conectar=new Conexion();//utilizo mi clase conexion
       ResultSet rs;
        try {
          rs=conectar.consultar(sql);
          while(rs.next()){//recorre el resultset 
              Caja c=new Caja();
              c.setCodigoCaja(rs.getInt("codigoCaja"));             
              c.setUbicacion(rs.getString("ubicacion"));
              c.setDescripcion(rs.getString("descripcion"));
              
               listado.add(c);//en cada ciclo llenamos el array list con el obj
          }//fin while
        } catch (Exception e) {
            System.out.println("Error en la consulta: "+e);
            
        }
        return listado;
    }
    
    //******METODOS PARA DETECTAR LA CAJA CAJA CAJA
    public int buscarCajaXcodigo(int codigoCaja){
         int hay=0;       
        String sql;
        sql = "SELECT count(*) as hayCaja FROM caja WHERE codigoCaja="+codigoCaja;
        System.out.println("consulta tipo: " + sql);
        Conexion conectar = new Conexion();
        ResultSet rs;
        try {
            rs = conectar.consultar(sql);
            while (rs.next()) {
                hay=rs.getInt("hayCaja");               
               
            }
        } catch (Exception e) {
            System.out.println("Error en consulta" + e);
        }
        return hay;
    }
    
     public String buscarDescCaja(int codigoCaja){
        String descCaja="";       
        String sql;
        sql = "SELECT descripcion as descCaja FROM caja WHERE codigoCaja="+codigoCaja;
        System.out.println("consulta tipo: " + sql);
        Conexion conectar = new Conexion();
        ResultSet rs;
        try {
            rs = conectar.consultar(sql);
            while (rs.next()) {
                descCaja=rs.getString("descCaja"); 
            }
        } catch (Exception e) {
            System.out.println("Error en consulta" + e);
        }
        return descCaja;
    }
    
       public int ConsecutivoCodigoDB(){//USADO EN VISTA MENUPRINCIPAL
       String sql;
       int codigo=0;
       sql="select idTurnoCaja from turnocaja order by idTurnoCaja DESC limit 1";//convierte el codemail de char a 
       //numero entero para ordenarlo como debe ser ya que si se deja en char no toma orden (1, 10 , 2 ,3) 
       Conexion conectar=new Conexion();//utilizo mi clase conexion
       ResultSet rs;
        try {
          rs=conectar.consultar(sql);
          
          if(rs.next()){//recorre el resultset
             codigo=Integer.parseInt(rs.getString("idTurnoCaja"))+1;
          }else{
              codigo=1;//esto es en caso que no haya registro en la BD
          }
        } catch (Exception e) {
            System.out.println("Error en la consulta consecutivo: "+e);            
        }
        return codigo;
    } 
     
     public boolean insertTurnoCaja(TurnoCaja objTC) {//AL DIGITAR EL CODIGO DE CAJA PASA ESTO
        boolean var = false;
        Conexion conectar = new Conexion();//utilizo mi clase conexion
        String sql;
        
        sql = "INSERT INTO turnocaja(idTurnoCaja,idUsuario, codCaja,fecha,horaInicial,horaFinal,observaciones)"
                + " VALUES ("+objTC.getIdTurnoCaja()+","+objTC.getIdUsuario()+"," + objTC.getCodCaja()+ ",'" + objTC.getFecha() +
                 "','"+objTC.getHoraInicial()+"','00:00:00','')";

        try {
            if (conectar.ejecutar(sql)) {
                var = true;
            }
        } catch (Exception e) {
            System.out.println("Error en guardar " + e);
        }

        return var;
    }
    
      public boolean modificarTurnoCaja(int idTurnoCaja,String horaNow) { //

        boolean var = false;
        Conexion conectar = new Conexion();//utilizo mi clase conexion
        ResultSet rs1;
        String sql = "";
        sql = "UPDATE turnoCaja SET horaFinal='" +horaNow
          + "' WHERE idTurnocaja="+idTurnoCaja;

        try {
            if (conectar.ejecutar(sql)) {
                var = true;
            }
        } catch (Exception e) {
            System.out.println("Error en modificar " + e);
        }

        return var;
    }
    
     public boolean modificarTurnoCajaDos(int idTurnoCaja,String observaciones) { //para ventana turnocaja

        boolean var = false;
        Conexion conectar = new Conexion();//utilizo mi clase conexion
        ResultSet rs1;
        String sql = "";
        sql = "UPDATE turnoCaja SET observaciones='" +observaciones
          + "' WHERE idTurnocaja="+idTurnoCaja;

        try {
            if (conectar.ejecutar(sql)) {
                var = true;
            }
        } catch (Exception e) {
            System.out.println("Error en modificar " + e);
        }

        return var;
    }  
     
    //*********METODOS PARA DETECTAR LA CAJA CAJA CAJA
    
    public ArrayList<Caja> listadoCaja() {//hecho por taky solo este metodo

        ArrayList<Caja> listado = new ArrayList();
        String sql;
        sql = "SELECT * FROM caja";
        System.out.println("consulta tipo: " + sql);
        Conexion conectar = new Conexion();
        ResultSet rs;
        try {
            rs = conectar.consultar(sql);
            while (rs.next()) {
                Caja objCaja = new Caja();
                objCaja.setCodigoCaja(rs.getInt("CodigoCaja"));               
                objCaja.setUbicacion(rs.getString("Ubicacion"));
                objCaja.setDescripcion(rs.getString("Descripcion"));
                listado.add(objCaja);

            }
        } catch (Exception e) {
            System.out.println("Error en consulta" + e);
        }
        return listado;
    }
    
    public boolean guardar(Caja objCa) {
        boolean var = false;
        Conexion conectar = new Conexion();//utilizo mi clase conexion
        String sql;
        
        sql = "INSERT INTO caja(codigoCaja,ubicacion,descripcion)"
                + " VALUES (" + objCa.getCodigoCaja() + ",'" + objCa.getUbicacion() + "','" + objCa.getDescripcion() + "')";

        try {
            if (conectar.ejecutar(sql)) {
                var = true;
            }
        } catch (Exception e) {
            System.out.println("Error en guardar " + e);
        }

        return var;
    }

    public boolean modificar(Caja objCa) { //

        boolean var = false;
        Conexion conectar = new Conexion();//utilizo mi clase conexion
        ResultSet rs1;
        String sql = "";
        sql = "UPDATE caja SET ubicacion='" + objCa.getUbicacion() + "', descripcion='" + objCa.getDescripcion()
                + "' WHERE codigoCaja=" + objCa.getCodigoCaja();

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
        sql = "DELETE FROM caja WHERE codigoCaja="+codigo;
        try {
            if (conectar.ejecutar(sql)) {
                var = true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return var;
    }
    
    
    
  public  void  cargarCB(javax.swing.JComboBox jcbx){     
      DefaultComboBoxModel value=new DefaultComboBoxModel();//Construye un objeto DefaultComboBoxModel vacío.
    //jcbx.removeAllItems();//deja el combobox vacio listo para cargar lo que viene de la BD, en este caso no hace falta
    //abajo con setModel se setea los valores del comobox, asi en la ventana aparezca item1,item2...
    jcbx.setModel(value);//Establece el modelo de datos que JComboBox utiliza para obtener la lista de elementos.
    Caja c;//creo una referencia de tipoDocumento
    int tam=traer().size();
      for(int i=0;i<tam;i++){ 
        c=new Caja();//instancio el objeto tipodocumento
        c.setCodigoCaja(traer().get(i).getCodigoCaja());
        c.setDescripcion(traer().get(i).getDescripcion());
        value.addElement(c);
      }            
  }
 
  //METODOS PARA EL TURNO CAJA
  
  public ArrayList<TurnoCaja> listadoTurnoCaja(int idUsuario){
       ArrayList<TurnoCaja> listado=new ArrayList();
       String sql;
       sql="Select tc.idTurnoCaja,tc.codCaja,ca.descripcion as descCaja,tc.fecha,tc.horaInicial,tc.horaFinal,tc.observaciones "
          + " from turnocaja tc INNER JOIN caja ca ON tc.codCaja=ca.codigoCaja where tc.idUsuario="+idUsuario;
       Conexion conectar=new Conexion();//utilizo mi clase conexion
       ResultSet rs;
        try {
          rs=conectar.consultar(sql);
          while(rs.next()){//recorre el resultset 
              TurnoCaja objTC=new TurnoCaja();
              objTC.setIdUsuario(idUsuario);
              objTC.setIdTurnoCaja(rs.getInt("idTurnoCaja"));
              objTC.setCodCaja(rs.getInt("codCaja")); 
              objTC.setDescCaja(rs.getString("descCaja"));
              objTC.setFecha(rs.getDate("fecha"));
              objTC.setHoraInicial(rs.getTime("horaInicial"));
              objTC.setHoraFinal(rs.getTime("horaFinal"));
              objTC.setObservaciones(rs.getString("observaciones"));
              
               listado.add(objTC);//en cada ciclo llenamos el array list con el obj
          }//fin while
        } catch (Exception e) {
            System.out.println("Error en la consulta: "+e);
            
        }
        return listado;
    }
     
//     public boolean guardarCtrlCaja(ControlCaja objCC) {
//        boolean var = false;
//        Conexion conectar = new Conexion();//utilizo mi clase conexion
//        String sql;
//        
//        sql = "INSERT INTO controlcaja(idUsuario, codCaja,fecha,novedades)"
//                + " VALUES (" + objCC.getIdUsuario() + "," + objCC.getCodigoCaja() + ",'" + objCC.getFecha() +
//                 "','"+objCC.getNovedades()+"')";
//
//        try {
//            if (conectar.ejecutar(sql)) {
//                var = true;
//            }
//        } catch (Exception e) {
//            System.out.println("Error en guardar " + e);
//        }
//
//        return var;
//    }
    
//    public boolean modificarCtrlCaja(ControlCaja objCC) { //
//
//        boolean var = false;
//        Conexion conectar = new Conexion();//utilizo mi clase conexion
//        ResultSet rs1;
//        String sql = "";
//        sql = "UPDATE controlcaja SET codCaja=" + objCC.getCodigoCaja() + ",fecha='" + objCC.getFecha()
//            + "',novedades='"+objCC.getNovedades()+"' WHERE idControlCaja="+objCC.getIdControlCaja();
//
//        try {
//            if (conectar.ejecutar(sql)) {
//                var = true;
//            }
//        } catch (Exception e) {
//            System.out.println("Error en modificar " + e);
//        }
//
//        return var;
//    }

//    public boolean eliminarCtrlCaja(int idControlCaja) {
//        boolean var = false;
//        Conexion conectar = new Conexion();//utilizo mi clase conexion
//        ResultSet rs;
//        String sql;
//        sql = "DELETE FROM controlCaja WHERE idControlCaja="+idControlCaja;
//        try {
//            if (conectar.ejecutar(sql)) {
//                var = true;
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        return var;
//    }
    
    
     
}
