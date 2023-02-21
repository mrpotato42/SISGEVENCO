/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Conexion.Conexion;
import Modelo.HorarioLaboral;
import Modelo.Usuario;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author DANIEL
 */
public class CtrlUsuario {
    
     public ArrayList<Usuario> traer(){
       ArrayList<Usuario> listado=new ArrayList();
       String sql;
       sql="Select * from usuario where idUsuario=3";
         System.out.println(sql);
       Conexion conectar=new Conexion();//utilizo mi clase conexion
       ResultSet rs;
        try {
          rs=conectar.consultar(sql);
          while(rs.next()){//recorre el resultset 
              Usuario e=new Usuario();
              e.setIdUsuario(rs.getInt("idUsuario"));
              e.setPrimerNombre(rs.getString("primerNombre"));
              e.setSegundoNombre(rs.getString("segundoNombre"));
              e.setPrimerApellido(rs.getString("primerApellido"));
              e.setSegundoApellido(rs.getString("segundoApellido"));
              e.setLogin(rs.getString("login"));
              e.setPassword(rs.getString("password"));              
              e.setIdRol(rs.getInt("idrol"));
              e.setSexo(rs.getString("sexo"));
              e.setIdTipoIdentidad(rs.getInt("idTipoIdentidad"));
              e.setNumeroIdentidad(rs.getString("numeroIdentidad"));
              e.setFechaNac(rs.getDate("fechaNac"));
              e.setIdCargo(rs.getInt("idCargo"));             
              
              HorarioLaboral objHorLab=new HorarioLaboral();
              objHorLab.setIdHorario(rs.getInt("idHorario"));              
              e.setHorarioLaboral(objHorLab);
              
              e.setDireccion(rs.getString("direccion"));
              e.setTelefono(rs.getString("telefono"));
              e.setEstado(rs.getString("estado"));
                       
               listado.add(e);//en cada ciclo llenamos el array list con el obj
          }//fin while
        } catch (Exception e) {
            System.out.println("Error en la consulta: "+e);
            
        }
        return listado;
    }
     
     
     
     
     public ArrayList<Usuario> listadoUsuarios() {

        ArrayList<Usuario> listado = new ArrayList();
        String sql;
        sql = "SELECT usu.idUsuario, usu.primerNombre, usu.segundoNombre, usu.primerApellido, usu.segundoApellido,usu.idRol,rol.nombre as nomRol, usu.login, usu.sexo, "
                + "usu.numeroIdentidad, usu.idTipoIdentidad, ti.nombreTipoIdentidad, usu.fechaNac, usu.idCargo, cg.nombre AS nomCargo, usu.idHorario,hl.horaInicio,hl.horaFin, hl.horaDesc,"
                + " usu.direccion, usu.telefono,usu.estado FROM usuario AS usu INNER JOIN rol ON usu.idRol = rol.idRol "
                + "INNER JOIN tipoidentidad AS ti ON usu.idTipoIdentidad = ti.idTipoIdentidad "
                + "INNER JOIN cargos AS cg ON usu.idCargo = cg.idCargo "
                + "INNER JOIN horariolaboral AS hl ON usu.idHorario = hl.idHorario ORDER BY usu.primerNombre";
        System.out.println("consulta tipo: " + sql);
        Conexion conectar = new Conexion();
        ResultSet rs;
        try {
            rs = conectar.consultar(sql);
            while (rs.next()) {
                Usuario objUsu = new Usuario();

                objUsu.setIdUsuario(rs.getInt("idUsuario"));
                objUsu.setPrimerNombre(rs.getString("primerNombre"));
                objUsu.setSegundoNombre(rs.getString("segundoNombre"));
                objUsu.setPrimerApellido(rs.getString("primerApellido"));
                objUsu.setSegundoApellido(rs.getString("segundoApellido"));
                objUsu.setLogin(rs.getString("login"));
                objUsu.setIdRol(rs.getInt("idRol"));
                objUsu.setNomRol(rs.getString("nomRol"));
                objUsu.setSexo(rs.getString("sexo"));
                objUsu.setIdTipoIdentidad(rs.getInt("idTipoIdentidad"));
                objUsu.setNombreTipoIdentidad(rs.getString("nombreTipoIdentidad"));
                objUsu.setNumeroIdentidad(rs.getString("numeroIdentidad"));
                objUsu.setFechaNac(rs.getDate("fechaNac"));
                objUsu.setIdCargo(rs.getInt("idCargo"));
                objUsu.setNomCargo(rs.getString("nomCargo"));
                //objeto tipo HORARIO LABORAL
                HorarioLaboral objHl=new HorarioLaboral();
                objHl.setIdHorario(rs.getInt("idHorario"));
                objHl.setHoraInicio(rs.getTime("horaInicio"));
                objHl.setHoraFin(rs.getTime("horaFin"));
                objHl.setHoraDesc(rs.getString("horaDesc"));
                //FIN OBJETO HORARIO LABORAL
                objUsu.setHorarioLaboral(objHl);
                objUsu.setDireccion(rs.getString("direccion"));
                objUsu.setTelefono(rs.getString("telefono"));
                objUsu.setEstado(rs.getString("estado"));
                listado.add(objUsu);

            }
        } catch (Exception e) {
            System.out.println("Error en consulta" + e);
        }
        return listado;
    }
    
     
     public ArrayList<Usuario> BusquedaTiempoReal(String texto){
       ArrayList<Usuario> listado=new ArrayList();
       String sql="";
           
       
            sql = "SELECT usu.idUsuario, usu.primerNombre, usu.segundoNombre, usu.primerApellido, usu.segundoApellido,usu.idRol,r.nombre as nomRol, usu.login, usu.sexo, "
                + "usu.numeroIdentidad, usu.idTipoIdentidad, ti.nombreTipoIdentidad, usu.fechaNac, usu.idCargo, cg.nombre AS nomCargo, usu.idHorario,hl.horaInicio,hl.horaFin, hl.horaDesc,"
                + " usu.direccion, usu.telefono,usu.estado FROM usuario AS usu INNER JOIN rol as r ON usu.idRol = r.idRol "
                + "INNER JOIN tipoidentidad AS ti ON usu.idTipoIdentidad = ti.idTipoIdentidad "
                + "INNER JOIN cargos AS cg ON usu.idCargo = cg.idCargo "
                + "INNER JOIN horariolaboral AS hl ON usu.idHorario = hl.idHorario "
               + " WHERE UPPER(usu.primerNombre) LIKE UPPER('%"+texto+"%') OR UPPER(usu.segundoNombre) LIKE UPPER('%"+texto+"%') OR "
               + "UPPER(usu.primerApellido) LIKE UPPER('%"+texto+"%') OR UPPER(usu.segundoApellido) LIKE UPPER('%"+texto+"%') OR UPPER(r.nombre) LIKE UPPER('%"+texto+"%') "
               + "OR UPPER(usu.login) LIKE UPPER('%"+texto+"%') OR UPPER(usu.sexo) LIKE UPPER('%"+texto+"%') OR UPPER(usu.numeroIdentidad) LIKE UPPER('%"+texto+"%') "
               + "OR UPPER(ti.nombreTipoIdentidad) LIKE UPPER('%"+texto+"%') OR UPPER(usu.fechaNac) LIKE UPPER('%"+texto+"%') "
               + "OR UPPER(cg.nombre) LIKE UPPER('%"+texto+"%') OR UPPER(hl.horaInicio) LIKE UPPER('%"+texto+"%') "
               + "OR UPPER(usu.direccion) LIKE UPPER('%"+texto+"%') OR UPPER(usu.telefono) LIKE UPPER('%"+texto+"%') "
               + "OR UPPER(usu.estado) LIKE UPPER('%"+texto+"%') order by usu.primerNombre"; 
                    
          
            System.out.println(sql); 
            
       Conexion conectar=new Conexion();//utilizo mi clase conexion
       ResultSet rs;
        try {
          rs=conectar.consultar(sql);
          while(rs.next()){//recorre el resultset
              Usuario objUsu = new Usuario();

                objUsu.setIdUsuario(rs.getInt("idUsuario"));
                objUsu.setPrimerNombre(rs.getString("primerNombre"));
                objUsu.setSegundoNombre(rs.getString("segundoNombre"));
                objUsu.setPrimerApellido(rs.getString("primerApellido"));
                objUsu.setSegundoApellido(rs.getString("segundoApellido"));
                objUsu.setLogin(rs.getString("login"));
                objUsu.setIdRol(rs.getInt("idRol"));
                objUsu.setNomRol(rs.getString("nomRol"));
                objUsu.setSexo(rs.getString("sexo"));
                objUsu.setIdTipoIdentidad(rs.getInt("idTipoIdentidad"));
                objUsu.setNombreTipoIdentidad(rs.getString("nombreTipoIdentidad"));
                objUsu.setNumeroIdentidad(rs.getString("numeroIdentidad"));
                objUsu.setFechaNac(rs.getDate("fechaNac"));
                objUsu.setIdCargo(rs.getInt("idCargo"));
                objUsu.setNomCargo(rs.getString("nomCargo"));
                //objeto tipo HORARIO LABORAL
                HorarioLaboral objHl=new HorarioLaboral();
                objHl.setIdHorario(rs.getInt("idHorario"));
                objHl.setHoraInicio(rs.getTime("horaInicio"));
                objHl.setHoraFin(rs.getTime("horaFin"));
                objHl.setHoraDesc(rs.getString("horaDesc"));
                //FIN OBJETO HORARIO LABORAL
                objUsu.setHorarioLaboral(objHl);
                objUsu.setDireccion(rs.getString("direccion"));
                objUsu.setTelefono(rs.getString("telefono"));
                objUsu.setEstado(rs.getString("estado"));
                listado.add(objUsu);
          }//fin while
        } catch (Exception e) {
            System.out.println("Error en la consulta: "+e);
            
        }
        return listado;
    } 
     
     public ArrayList<Usuario> traerUnUsuario(int idUsuario){
       ArrayList<Usuario> listado=new ArrayList();
       String sql;
      sql = "SELECT usu.idUsuario, usu.primerNombre, usu.segundoNombre, usu.primerApellido, usu.segundoApellido,usu.idRol,rol.nombre as nomRol, usu.login,usu.password, usu.sexo, "
                + "usu.numeroIdentidad, usu.idTipoIdentidad, ti.nombreTipoIdentidad, usu.fechaNac, usu.idCargo, cg.nombre AS nomCargo, usu.idHorario,hl.horaInicio,hl.horaFin, hl.horaDesc,"
                + " usu.direccion, usu.telefono,usu.estado FROM usuario AS usu INNER JOIN rol ON usu.idRol = rol.idRol "
                + "INNER JOIN tipoidentidad AS ti ON usu.idTipoIdentidad = ti.idTipoIdentidad "
                + "INNER JOIN cargos AS cg ON usu.idCargo = cg.idCargo "
                + "INNER JOIN horariolaboral AS hl ON usu.idHorario = hl.idHorario WHERE usu.idUsuario="+idUsuario;
       System.out.println(sql);
       Conexion conectar=new Conexion();//utilizo mi clase conexion
       ResultSet rs;
        try {
          rs=conectar.consultar(sql);
          while(rs.next()){//recorre el resultset 
              Usuario objUsu = new Usuario();

                objUsu.setIdUsuario(rs.getInt("idUsuario"));
                objUsu.setPrimerNombre(rs.getString("primerNombre"));
                objUsu.setSegundoNombre(rs.getString("segundoNombre"));
                objUsu.setPrimerApellido(rs.getString("primerApellido"));
                objUsu.setSegundoApellido(rs.getString("segundoApellido"));
                objUsu.setLogin(rs.getString("login"));
                 objUsu.setPassword(rs.getString("password"));
                objUsu.setIdRol(rs.getInt("idRol"));
                objUsu.setNomRol(rs.getString("nomRol"));
                objUsu.setSexo(rs.getString("sexo"));
                objUsu.setIdTipoIdentidad(rs.getInt("idTipoIdentidad"));
                objUsu.setNombreTipoIdentidad(rs.getString("nombreTipoIdentidad"));
                objUsu.setNumeroIdentidad(rs.getString("numeroIdentidad"));
                objUsu.setFechaNac(rs.getDate("fechaNac"));
                objUsu.setIdCargo(rs.getInt("idCargo"));
                objUsu.setNomCargo(rs.getString("nomCargo"));
                //objeto tipo HORARIO LABORAL
                HorarioLaboral objHl=new HorarioLaboral();
                objHl.setIdHorario(rs.getInt("idHorario"));
                objHl.setHoraInicio(rs.getTime("horaInicio"));
                objHl.setHoraFin(rs.getTime("horaFin"));
                objHl.setHoraDesc(rs.getString("horaDesc"));
                //FIN OBJETO HORARIO LABORAL
                objUsu.setHorarioLaboral(objHl);
                objUsu.setDireccion(rs.getString("direccion"));
                objUsu.setTelefono(rs.getString("telefono"));
                objUsu.setEstado(rs.getString("estado"));
                listado.add(objUsu);
          }//fin while
        } catch (Exception e) {
            System.out.println("Error en la consulta: "+e);
            
        }
        return listado;
    } 
     
     
    public boolean guardar(Usuario objUsu) {

        boolean var = false;
        String sql;
        sql = "INSERT INTO usuario VALUES"
                + " ('" + objUsu.getIdUsuario() + "', '" + objUsu.getPrimerNombre() + "', '" + objUsu.getSegundoNombre() + "', '"
                + objUsu.getPrimerApellido() + "', '" + objUsu.getSegundoApellido() + "', '" + objUsu.getLogin() + "', '" + objUsu.getPassword()+"','" + objUsu.getSexo()
                + "', " + objUsu.getIdTipoIdentidad() + ", '" + objUsu.getNumeroIdentidad() + "', '" + objUsu.getFechaNac()
                + "', " + objUsu.getIdCargo() + ", '" + objUsu.getDireccion()+ "', '" + objUsu.getTelefono()
                +"',"+objUsu.getIdRol()+","+objUsu.getHorarioLaboral().getIdHorario()+",'"+objUsu.getEstado()+"')";

        System.out.println("agregar Usuario: " + sql);
        Conexion conectar = new Conexion();

        try {
            var = conectar.ejecutar(sql);
        } catch (Exception e) {
            System.out.println("Error en agregar" + e);
        }
        return var;
    }
    
    

    public boolean modificar(Usuario objUsu) {

        boolean var = false;
        String sql;
      
        sql = "UPDATE usuario SET primerNombre='" + objUsu.getPrimerNombre() + "',segundoNombre='" + objUsu.getSegundoNombre() + "', primerApellido='"
                + objUsu.getPrimerApellido() + "', segundoApellido='" + objUsu.getSegundoApellido() +"', login='" + objUsu.getLogin() + "', password='" + objUsu.getPassword() + "', idRol='" + objUsu.getIdRol() + "', sexo='" + objUsu.getSexo()
                + "', idTipoIdentidad='" + objUsu.getIdTipoIdentidad() + "', numeroIdentidad='" + objUsu.getNumeroIdentidad() + "', fechaNac='" + objUsu.getFechaNac()
                + "', idCargo='" + objUsu.getIdCargo() + "', idHorario='" + objUsu.getHorarioLaboral().getIdHorario() + "', direccion='" + objUsu.getDireccion()
                + "', telefono='" + objUsu.getTelefono() + "',estado='"+objUsu.getEstado()+"' WHERE idUsuario =" + objUsu.getIdUsuario();
        System.out.println("modificar Usuario: " + sql);
        Conexion conectar = new Conexion();

        try {
            var = conectar.ejecutar(sql);
        } catch (Exception e) {
            System.out.println("Error en modificar" + e);
        }
        return var;
    }

    public boolean eliminar(int id) {

        boolean var = false;
        String sql;
        sql = "DELETE FROM usuario WHERE idUsuario =" + id;

        System.out.println("borrar Usuario: " + sql);
        Conexion conectar = new Conexion();

        try {
            var = conectar.ejecutar(sql);
        } catch (Exception e) {
            System.out.println("Error en borrar" + e);
        }
        return var;
    }
    
    
    
    public ArrayList<Usuario> traerUnEmpleado(int codigoUsuario){
       ArrayList<Usuario> listado=new ArrayList();
       String sql;
       sql="Select primerNombre,primerApellido from usuario where idUsuario="+codigoUsuario;
         System.out.println(sql);
       Conexion conectar=new Conexion();//utilizo mi clase conexion
       ResultSet rs;
        try {
          rs=conectar.consultar(sql);
          while(rs.next()){//recorre el resultset 
              Usuario e=new Usuario();
              
              e.setPrimerNombre(rs.getString("primerNombre"));              
              e.setPrimerApellido(rs.getString("primerApellido"));    
                       
              listado.add(e);//en cada ciclo llenamos el array list con el obj
          }//fin while
        } catch (Exception e) {
            System.out.println("Error en la consulta: "+e);
            
        }
        return listado;
    }
    
    
     //VALIDACIONES VALIDACIONES VALIDACIONES VALIDACIONES VALIDACIONES
     
     public int existeNumeroID(String numeroIdentidad){//PARA BOTON GUARDAR       
       int existe=0;
       String sql;
       sql="SELECT count(numeroIdentidad) as hay FROM usuario WHERE numeroIdentidad='"+numeroIdentidad+"'";
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
    
     
      public int existeNumeroIDEditar(String numeroIdentidad,int idUsuario){//PARA BOTON EDITAR       
       int existe=0;
       String sql;
       sql="SELECT count(numeroIdentidad) as hay FROM usuario WHERE numeroIdentidad='"+numeroIdentidad
        + "' AND idUsuario<>"+idUsuario;
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
    
      public int existeLogin(String login) {
        int existe=0;
        String sql;
        sql = "SELECT count(login) as hay FROM usuario WHERE login = '"+login+"'";
        Conexion conectar = new Conexion();
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
      
    public int existeLoginEditar(String login,int idUsuario) {
        int existe=0;
        String sql;
        sql = "SELECT count(login) as hay FROM usuario WHERE login = '"+login+"' AND idUsuario<>"+idUsuario;
        Conexion conectar = new Conexion();
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
  
    
}
