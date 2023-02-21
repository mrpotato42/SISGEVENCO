/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

/**
 *
 * @author DANIEL
 */
public class listaDT {
    private int codigoArticulo;
    private String nomArticulo;
    private int cantidad;
    private double precioVenta;
    private double subTotal;
    private double porIva;
    private double iva;
    private double total;

    public listaDT(int codigoArticulo, String nomArticulo, int cantidad, double precioVenta, double subTotal, double porIva, double iva, double total) {
        this.codigoArticulo = codigoArticulo;
        this.nomArticulo = nomArticulo;
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
        this.subTotal = subTotal;
        this.porIva = porIva;
        this.iva = iva;
        this.total = total;
    }

    public int getCodigoArticulo() {
        return codigoArticulo;
    }

    public void setCodigoArticulo(int codigoArticulo) {
        this.codigoArticulo = codigoArticulo;
    }

    public String getNomArticulo() {
        return nomArticulo;
    }

    public void setNomArticulo(String nomArticulo) {
        this.nomArticulo = nomArticulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getPorIva() {
        return porIva;
    }

    public void setPorIva(double porIva) {
        this.porIva = porIva;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    
   
    
}
