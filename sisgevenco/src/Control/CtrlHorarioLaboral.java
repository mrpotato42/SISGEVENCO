package Control;

import Conexion.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import Modelo.HorarioLaboral;
import javax.swing.DefaultComboBoxModel;

public class CtrlHorarioLaboral {

    public ArrayList<HorarioLaboral> listadoHorarioLaboral() {

        ArrayList<HorarioLaboral> listado = new ArrayList();
        String sql;
        sql = "SELECT * FROM horariolaboral";
        
        Conexion conectar = new Conexion();
        ResultSet rs;
        try {
            rs = conectar.consultar(sql);
            while (rs.next()) {
                HorarioLaboral objHora = new HorarioLaboral();
                objHora.setIdHorario(rs.getInt("IdHorario"));
                objHora.setHoraInicio(rs.getTime("HoraInicio"));
                objHora.setHoraFin(rs.getTime("HoraFin"));
                objHora.setHoraDesc(rs.getString("HoraDesc"));
                listado.add(objHora);

            }
        } catch (Exception e) {
            System.out.println("Error en consulta" + e);
        }
        return listado;
    }
    
    public ArrayList<HorarioLaboral> BusquedaTiempoReal(String texto){
       ArrayList<HorarioLaboral> listado=new ArrayList();
       String sql="";
       
           sql="Select * from horariolaboral"
               + " WHERE horaInicio LIKE '%"+texto+"%' OR "
               + "horaFin LIKE '%"+texto+"%' OR horaDesc LIKE '%"+texto+"%'";           
          
            System.out.println(sql); 
            
       Conexion conectar=new Conexion();//utilizo mi clase conexion
       ResultSet rs;
        try {
          rs=conectar.consultar(sql);
          while(rs.next()){//recorre el resultset
               HorarioLaboral objHora = new HorarioLaboral();
                objHora.setIdHorario(rs.getInt("IdHorario"));
                objHora.setHoraInicio(rs.getTime("HoraInicio"));
                objHora.setHoraFin(rs.getTime("HoraFin"));
                objHora.setHoraDesc(rs.getString("HoraDesc"));
                listado.add(objHora);              
              
              listado.add(objHora);//en cada ciclo llenamos el array list con el obj
          }//fin while
        } catch (Exception e) {
            System.out.println("Error en la consulta: "+e);
            
        }
        return listado;
    } 
    
    
    
    public ArrayList<HorarioLaboral> traerUnHorarioLabo(String codigo) {
        ArrayList<HorarioLaboral> listado = new ArrayList();//INVESTIGAR ARRAYLIST
        String sql;
        sql = "Select * from horariolaboral WHERE idHorario=" + codigo;

        Conexion conectar = new Conexion();//utilizo mi clase conexion
        ResultSet rs;
        try {
            rs = conectar.consultar(sql);
            while (rs.next()) {//recorre el resultset
                HorarioLaboral objHora = new HorarioLaboral();
                objHora.setIdHorario(rs.getInt("IdHorario"));
                objHora.setHoraInicio(rs.getTime("HoraInicio"));
                objHora.setHoraFin(rs.getTime("HoraFin"));
                objHora.setHoraDesc(rs.getString("HoraDesc"));
                listado.add(objHora);
            }//fin while
        } catch (Exception e) {
            System.out.println("Error en la consulta: " + e);

        }
        return listado;
    }

    public boolean guardar(HorarioLaboral objHl) {
        boolean var = false;
        Conexion conectar = new Conexion();//utilizo mi clase conexion
        String sql;
        String sqlE;
        sql = "INSERT INTO horariolaboral(horaInicio,horaFin,horaDesc)"
                + " VALUES ('" + objHl.getHoraInicio() + "','" + objHl.getHoraFin()+ "','" + objHl.getHoraDesc() + "')";

        try {
            if (conectar.ejecutar(sql)) {
                var = true;
            }
        } catch (Exception e) {
            System.out.println("Error en guardar " + e);
        }

        return var;
    }

    public boolean modificar(HorarioLaboral objHl) { //

        boolean var = false;
        Conexion conectar = new Conexion();//utilizo mi clase conexion
        ResultSet rs1;
        String sql = "";
        sql = "UPDATE horariolaboral SET horaInicio='" + objHl.getHoraInicio() + "', horaFin='" + objHl.getHoraFin()
                + "',horaDesc='"+objHl.getHoraDesc()+"' WHERE idHorario=" + objHl.getIdHorario();

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
        sql = "DELETE FROM horariolaboral WHERE idHorario=" + codigo;
        try {
            if (conectar.ejecutar(sql)) {
                var = true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return var;
    }
    
    public  void  cargarCBHora(javax.swing.JComboBox jcb){     
        jcb.removeAllItems();//borra los valores existentes que hay en el combobox lo limpia
        for(int i=0;i<=23;i++){          
           String min=i+"";
           if(min.length()==1){
            jcb.addItem("0"+i);//para que de 1 a 9 vaya asi 01,02,03...09
           }else{
              jcb.addItem(i+""); 
           }
        }              
    }

    public  void  cargarCBMinutos(javax.swing.JComboBox jcb){     
        jcb.removeAllItems();//borra los valores existentes que hay en el combobox lo limpia
        for(int i=0;i<=59;i++){          
           String min=i+"";
           if(min.length()==1){
            jcb.addItem("0"+i);//para que de 1 a 9 vaya asi 01,02,03...09
           }else{
              jcb.addItem(i+""); 
           }
        }              
    }
    
       public void cargarCB(javax.swing.JComboBox jcbx){
        DefaultComboBoxModel value=new DefaultComboBoxModel();//Construye un objeto DefaultComboBoxModel vacío.
        //jcbx.removeAllItems();//deja el combobox vacio listo para cargar lo que viene de la BD, en este caso no hace falta
        //abajo con setModel se setea los valores del comobox, asi en la ventana aparezca item1,item2...
        jcbx.setModel(value);//Establece el modelo de datos que JComboBox utiliza para obtener la lista de elementos.
        HorarioLaboral objHl;//creo una referencia de tipoDocumento

          for(int i=0;i<listadoHorarioLaboral().size();i++){ 
            objHl=new HorarioLaboral();//instancio el objeto tipo Identidad
            objHl.setIdHorario(listadoHorarioLaboral().get(i).getIdHorario());
            objHl.setHoraInicio(listadoHorarioLaboral().get(i).getHoraInicio());
            objHl.setHoraFin(listadoHorarioLaboral().get(i).getHoraFin());
            objHl.setHoraDesc(listadoHorarioLaboral().get(i).getHoraDesc());
            value.addElement(objHl);
          }           
   }

}