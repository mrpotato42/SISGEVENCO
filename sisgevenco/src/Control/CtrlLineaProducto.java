

package Control;

import Conexion.Conexion;
import Modelo.LineaProducto;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;


public class CtrlLineaProducto {
    
    public ArrayList<LineaProducto> listadoLineaP(){
       ArrayList<LineaProducto> listado=new ArrayList();
       String sql;
       sql="Select * from lineaproducto order by lineaDescripcion ASC";
       Conexion conectar=new Conexion();//utilizo mi clase conexion
       ResultSet rs;
        try {
          rs=conectar.consultar(sql);
          while(rs.next()){//recorre el resultset 
              LineaProducto objL=new LineaProducto();
              objL.setidLinea(rs.getInt("idLinea"));
              objL.setdescripcion(rs.getString("lineaDescripcion"));
              listado.add(objL);//en cada ciclo llenamos el arraylist con el obj
          }//fin while
        } catch (Exception e) {
            System.out.println("Error en la consulta: "+e);
            
        }
        return listado;
    }
    
    public ArrayList<LineaProducto>traerUnaLineaP(String codigo){
       ArrayList<LineaProducto> listado=new ArrayList();//INVESTIGAR ARRAYLIST
       String sql;
       sql="Select * from lineaproducto WHERE idLinea='"+codigo+"'";
       
       Conexion conectar=new Conexion();//utilizo mi clase conexion
       ResultSet rs;
        try {
          rs=conectar.consultar(sql);
          while(rs.next()){//recorre el resultset
              LineaProducto objL=new LineaProducto();
              objL.setidLinea(rs.getInt("idlinea"));
              objL.setdescripcion(rs.getString("lineaDescripcion"));
              listado.add(objL);//en cada ciclo llenamos el arraylist con el obj
          }//fin while
        } catch (Exception e) {
            System.out.println("Error en la consulta: "+e);
            
        }
        return listado;
    }
    
    public boolean guardar(LineaProducto objL){
        boolean var=false;
        Conexion conectar=new Conexion();//utilizo mi clase conexion
        String sql; 
        String sqlE;
        sql="INSERT INTO lineaproducto(idLinea,lineaDescripcion)"
                + " VALUES ('"+objL.getidLinea()+"','"+objL.getdescripcion()+"')";
       
         try {
            if(conectar.ejecutar(sql)){
                var=true;
             }            
         } catch (Exception e) {
            System.out.println("Error en guardar "+e);
          }
      
       return var;
    }
    
    public boolean modificar(LineaProducto objL){ //
        
        boolean var=false;
        Conexion conectar=new Conexion();//utilizo mi clase conexion
        ResultSet rs1;
        String sql="";
        sql="UPDATE lineaproducto SET lineaDescripcion='"+objL.getdescripcion()
                +"' WHERE idLinea="+objL.getidLinea();       
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
        sql="DELETE FROM lineaproducto WHERE idLinea='"+codigo+"'";       
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
        LineaProducto lp;//creo una referencia de tipoDocumento
        int tam=listadoLineaP().size();
        for (int i = 0; i < tam; i++) {
            lp = new LineaProducto();//instancio el objeto sublineaproducto
            lp.setidLinea(listadoLineaP().get(i).getidLinea());
            lp.setdescripcion(listadoLineaP().get(i).getdescripcion());
            value.addElement(lp);
        }
    }
    
}

