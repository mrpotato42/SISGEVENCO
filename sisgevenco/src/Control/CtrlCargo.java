

package Control;

import Conexion.Conexion;
import Modelo.Cargo;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;


public class CtrlCargo {
    
    public ArrayList<Cargo> listadoCargo(){
       ArrayList<Cargo> listado=new ArrayList();
       String sql;
       sql="Select * from Cargos order by nombre ASC";
       Conexion conectar=new Conexion();//utilizo mi clase conexion
       ResultSet rs;
        try {
          rs=conectar.consultar(sql);
          while(rs.next()){//recorre el resultset 
              Cargo objD=new Cargo();
              objD.setIdCargo(rs.getInt("idCargo"));
              objD.setNombre(rs.getString("nombre"));
              objD.setDescripcion(rs.getString("descripcion"));
              listado.add(objD);//en cada ciclo llenamos el arraylist con el obj
          }//fin while
        } catch (Exception e) {
            System.out.println("Error en la consulta: "+e);
            
        }
        return listado;
    }
    
    public ArrayList<Cargo>traerUnCargo(String codigo){
       ArrayList<Cargo> listado=new ArrayList();//INVESTIGAR ARRAYLIST
       String sql;
       sql="Select * from Cargos WHERE idCargo='"+codigo+"'";
       
       Conexion conectar=new Conexion();//utilizo mi clase conexion
       ResultSet rs;
        try {
          rs=conectar.consultar(sql);
          while(rs.next()){//recorre el resultset
              Cargo objD=new Cargo();
              objD.setIdCargo(rs.getInt("idCargo"));
              objD.setNombre(rs.getString("nombre"));
              objD.setDescripcion(rs.getString("descripcion"));
              listado.add(objD);//en cada ciclo llenamos el arraylist con el obj
          }//fin while
        } catch (Exception e) {
            System.out.println("Error en la consulta: "+e);
            
        }
        return listado;
    }
    
    public boolean guardar(Cargo objD){
        boolean var=false;
        Conexion conectar=new Conexion();//utilizo mi clase conexion
        String sql; 
        String sqlE;
        sql="INSERT INTO Cargos(idCargo,nombre,descripcion)"
                + " VALUES ('"+objD.getIdCargo()+"','"+objD.getNombre()+"','"+objD.getDescripcion()+"')";
       
         try {
            if(conectar.ejecutar(sql)){
                var=true;
             }            
         } catch (Exception e) {
            System.out.println("Error en guardar "+e);
          }
      
       return var;
    }
    
    public boolean modificar(Cargo objD){ //
        
        boolean var=false;
        Conexion conectar=new Conexion();//utilizo mi clase conexion
        ResultSet rs1;
        String sql="";
        sql="UPDATE Cargos SET nombre='"+objD.getNombre()+"',descripcion='"+objD.getDescripcion()
                +"' WHERE idCargo="+objD.getIdCargo();       
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
        sql="DELETE FROM Cargos WHERE idCargo='"+codigo+"'";       
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
        Cargo objC;//creo una referencia de tipoDocumento

          for(int i=0;i<listadoCargo().size();i++){              
            objC=new Cargo();//instancio el objeto tipo Identidad
            objC.setIdCargo(listadoCargo().get(i).getIdCargo());
            objC.setNombre(listadoCargo().get(i).getNombre());
             System.out.println("entre cbx cargo-->"+objC.getNombre());
            value.addElement(objC);
          }           
   }
    
}

