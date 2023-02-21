/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Leonardo
 */
public class TurnoCaja {
    private int idTurnoCaja;
    private int idUsuario;
    private int codCaja;
    private String DescCaja;
    private Date fecha;
    private Time horaInicial;
    private Time horaFinal;
    private String observaciones;

    public TurnoCaja(int idTurnoCaja, int idUsuario, int codCaja, String DescCaja, Date fecha, Time horaInicial, Time horaFinal, String observaciones) {
        this.idTurnoCaja = idTurnoCaja;
        this.idUsuario = idUsuario;
        this.codCaja = codCaja;
        this.DescCaja = DescCaja;
        this.fecha = fecha;
        this.horaInicial = horaInicial;
        this.horaFinal = horaFinal;
        this.observaciones = observaciones;
    }

    

    public TurnoCaja() {
    }

    public int getIdTurnoCaja() {
        return idTurnoCaja;
    }

    public void setIdTurnoCaja(int idTurnoCaja) {
        this.idTurnoCaja = idTurnoCaja;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getCodCaja() {
        return codCaja;
    }

    public void setCodCaja(int codCaja) {
        this.codCaja = codCaja;
    }

    public String getDescCaja() {
        return DescCaja;
    }

    public void setDescCaja(String DescCaja) {
        this.DescCaja = DescCaja;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(Time horaInicial) {
        this.horaInicial = horaInicial;
    }

    public Time getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(Time horaFinal) {
        this.horaFinal = horaFinal;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
   
    
}
