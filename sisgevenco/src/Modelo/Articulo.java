/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author DANIEL
 */
public class Articulo {
    private int codigoArticulo;
    private String nombreArticulo;
    private String descripcion;
    private int idProveedores;
    private String nomProvee;
    private double iva;
    private SubLineaProducto sublineaProducto;
    private int cantidad;
    private String lote;
    private double costo;
    private double precioVenta;
    private double utilidad;
    private String estado;
    //  2:30 miercoles
    // av 5ta cnorte 47a49 arquitecsoft

    public Articulo(int codigoArticulo, String nombreArticulo, String descripcion, int idProveedores, String nomProvee, double iva, SubLineaProducto sublineaProducto, int cantidad, String lote, double costo, double precioVenta, double utilidad, String estado) {
        this.codigoArticulo = codigoArticulo;
        this.nombreArticulo = nombreArticulo;
        this.descripcion = descripcion;
        this.idProveedores = idProveedores;
        this.nomProvee = nomProvee;
        this.iva = iva;
        this.sublineaProducto = sublineaProducto;
        this.cantidad = cantidad;
        this.lote = lote;
        this.costo = costo;
        this.precioVenta = precioVenta;
        this.utilidad = utilidad;
        this.estado = estado;
    }

    

    public Articulo() {
    }
        
    public int getCodigoArticulo() {
        return codigoArticulo;
    }

    public void setCodigoArticulo(int codigoArticulo) {
        this.codigoArticulo = codigoArticulo;
    }

    public String getNombreArticulo() {
        return nombreArticulo;
    }

    public void setNombreArticulo(String nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdProveedores() {
        return idProveedores;
    }

    public void setIdProveedores(int idProveedores) {
        this.idProveedores = idProveedores;
    }

    public String getNomProvee() {
        return nomProvee;
    }

    public void setNomProvee(String nomProvee) {
        this.nomProvee = nomProvee;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public SubLineaProducto getSublineaProducto() {
        return sublineaProducto;
    }

    public void setSublineaProducto(SubLineaProducto sublineaProducto) {
        this.sublineaProducto = sublineaProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public double getUtilidad() {
        return utilidad;
    }

    public void setUtilidad(double utilidad) {
        this.utilidad = utilidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}
