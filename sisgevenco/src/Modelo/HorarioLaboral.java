package Modelo;

import java.sql.Time;

public class HorarioLaboral {

    public int idHorario;
    public Time horaInicio;
    public Time horaFin;
    public String horaDesc;

    public HorarioLaboral() {
    }

    public HorarioLaboral(int idHorario, Time horaInicio, Time horaFin, String horaDesc) {
        this.idHorario = idHorario;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.horaDesc = horaDesc;
    }

    public int getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Time getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Time horaFin) {
        this.horaFin = horaFin;
    }

    public String getHoraDesc() {
        return horaDesc;
    }

    public void setHoraDesc(String horaDesc) {
        this.horaDesc = horaDesc;
    }

    @Override
    public String toString() {
        return horaInicio + " a " + horaFin;
    }
    
    
}
