/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;

/**
 *
 * @author Leonardo
 */
public class ResolucionFactura {
    private int idResolucionFactura;
    private int nroResolucionFactura;
    private Date fecha;
    private Date fechaInicio;
    private Date fechaFin;

    public ResolucionFactura(int idResolucionFactura, int nroResolucionFactura, Date fecha, Date fechaInicio, Date fechaFin) {
        this.idResolucionFactura = idResolucionFactura;
        this.nroResolucionFactura = nroResolucionFactura;
        this.fecha = fecha;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public ResolucionFactura() {
    }

    public int getIdResolucionFactura() {
        return idResolucionFactura;
    }

    public void setIdResolucionFactura(int idResolucionFactura) {
        this.idResolucionFactura = idResolucionFactura;
    }

    public int getNroResolucionFactura() {
        return nroResolucionFactura;
    }

    public void setNroResolucionFactura(int nroResolucionFactura) {
        this.nroResolucionFactura = nroResolucionFactura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

   

    @Override
    public String toString() {
        return String.valueOf(nroResolucionFactura);
    }
    
    
    
    
}
