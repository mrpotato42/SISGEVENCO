package Control;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Conexion.Conexion;
import Modelo.Usuario;
import java.util.Date;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CtrLogin {

    public boolean login(Usuario usr) {

        String sql;
        sql = "SELECT idUsuario, login, password,primerNombre,primerApellido FROM usuario WHERE login = \"" + usr.getLogin()+"\"";
        Conexion conectar = new Conexion();
        ResultSet rs;
        
        try {
            rs = conectar.consultar(sql);
            if (rs.next()) {
                if (usr.getPassword().equals(rs.getString("password"))) {                    
                    usr.setIdUsuario(rs.getInt("idUsuario"));
                    usr.setLogin(rs.getString("login"));
                    usr.setLogin(rs.getString("primerNombre"));
                    usr.setLogin(rs.getString("primerApellido"));
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        } catch (SQLException e) {
            Logger.getLogger(CtrLogin.class.getName()).log(Level.SEVERE, null,e);
            return false;
        }
    }
    
    public ArrayList<Usuario> traerLogueado(String login,String password) {
        ArrayList<Usuario> listado=new ArrayList<>();
        Usuario usr=new Usuario();
        String sql;
        sql = "SELECT u.idUsuario,u.primerNombre,u.primerApellido,r.nombre FROM usuario u INNER JOIN"
                + " rol r ON u.idRol=r.idRol WHERE login = '" + login+"' AND "
                + "password='"+password+"'";
        Conexion conectar = new Conexion();
        ResultSet rs;
        
        try {
            rs = conectar.consultar(sql);
            if (rs.next()) {   
                    usr.setIdUsuario(rs.getInt("idUsuario"));
                    usr.setPrimerNombre(rs.getString("primerNombre"));
                    usr.setPrimerApellido(rs.getString("primerApellido"));
                    usr.setNomRol(rs.getString("nombre"));
                    listado.add(usr);
            }
           
        } catch (SQLException e) {
            System.out.println("Ocurrio un error! "+ e);
            
        }
        return listado;
    }
    
    
     public String fechaNow(){//SON USADOS SOLAMENTE EN MENUPRINCIPAL.GUI
        String fecha="";
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        fecha=dateFormat.format(date);
        return fecha;
    }
    
    public String horaNow(){//SON USADOS SOLAMENTE EN MENUPRINCIPAL.GUI
        String hora="";
        Date date = new Date();
//        Caso 1: obtener la hora y salida por pantalla con formato:
        DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
        hora=hourFormat.format(date);      
        return hora;
    }
    

}
