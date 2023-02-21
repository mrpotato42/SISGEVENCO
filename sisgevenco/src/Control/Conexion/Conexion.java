/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author DANIEL
 */
public class Conexion implements Configuracion {
      private static Connection con=null;//creamos una variable de tipo Connection
    
    static{//bloque statico 
        /*Es posible declarar bloques de código como estáticos, de tal manera que sean ejecutados cuando se cargue la clase. */
        try{
            Class.forName(DRIVER);//registra el driver de conexión para la base de datos. 
            con=DriverManager.getConnection(CONNECTION_URL,USERNAME, PASSWORD);//suministra la URL y conexion
                       
            if(con!=null){
                System.out.println("-->"+con);
                System.out.println("Conexion Exitosa!"); 
            }else{
                System.out.println("Conexion Fallida"); 
            }
        }catch(ClassNotFoundException | SQLException e){
           e.printStackTrace();
            System.out.println("Error en conexion: "+e);
        }
    }
    
    public static Connection getConnection(){//metodo que arroja lo que esta almacenado en la variable con osea la conexion
        return con;
    }
    
    public boolean ejecutar(String sql){
        boolean var;
        try{
            Statement sentencia;
            sentencia=getConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            if(sentencia.executeUpdate(sql)==0)//ejecute mi consulta
               var=false; //si es igual a cero no ejecuto la consulta retorne FALSE 
            else
              var =true;//si no es cero ejecuto la consulta exitosamente
            
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Error en ejecución: "+e);//mensaje para el desarrollador!
            var=false;
        }      
        
        return var;
    }
    
    public ResultSet consultar(String sql){
        ResultSet resultado;
        try{
            Statement sentencia;
            sentencia=getConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            resultado=sentencia.executeQuery(sql);//ejecuta la sentencia en la base de datos         
            
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Error en la consulta: "+e);//mensaje para el desarrollador!
            resultado=null;
        }
     
        return resultado;//retorna un conjunto de resultados desde la BDD
    }
    
    public static void main(String[] args) {
        Conexion c=new Conexion();
        
    }
}
