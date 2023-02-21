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
public class Factura {
    private int numeroDocumento;
    private int codigoDocumento;
    private String descDocumento;
    private Date fecha;
    private Time hora;
    private int codigoCaja;
    private String descCaja;
//    private int codigoCliente;
    private Cliente cliente;
    private int idResolucionFactura;
    private int nroResolucionFactura;
//    private int codigoEmpleado;
    private Usuario usuario;

    public Factura(int numeroDocumento, int codigoDocumento, String descDocumento, Date fecha, Time hora, int codigoCaja, String descCaja, Cliente cliente, int idResolucionFactura, int nroResolucionFactura, Usuario usuario) {
        this.numeroDocumento = numeroDocumento;
        this.codigoDocumento = codigoDocumento;
        this.descDocumento = descDocumento;
        this.fecha = fecha;
        this.hora = hora;
        this.codigoCaja = codigoCaja;
        this.descCaja = descCaja;
        this.cliente = cliente;
        this.idResolucionFactura = idResolucionFactura;
        this.nroResolucionFactura = nroResolucionFactura;
        this.usuario = usuario;
    }

    public Factura() {
    }

    public int getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(int numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public int getCodigoDocumento() {
        return codigoDocumento;
    }

    public void setCodigoDocumento(int codigoDocumento) {
        this.codigoDocumento = codigoDocumento;
    }

    public String getDescDocumento() {
        return descDocumento;
    }

    public void setDescDocumento(String descDocumento) {
        this.descDocumento = descDocumento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public int getCodigoCaja() {
        return codigoCaja;
    }

    public void setCodigoCaja(int codigoCaja) {
        this.codigoCaja = codigoCaja;
    }

    public String getDescCaja() {
        return descCaja;
    }

    public void setDescCaja(String descCaja) {
        this.descCaja = descCaja;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
