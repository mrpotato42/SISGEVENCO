/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Leonardo
 */
public class SubLineaProducto {
    private int idSubLinea;
    private String subLineaDescripcion;
    private int idLinea;
    private String descLineaProd;

    public SubLineaProducto(int idSubLinea, String subLineaDescripcion, int idLinea, String descLineaProd) {
        this.idSubLinea = idSubLinea;
        this.subLineaDescripcion = subLineaDescripcion;
        this.idLinea = idLinea;
        this.descLineaProd = descLineaProd;
    }

    public SubLineaProducto() {
    }

    public int getIdSubLinea() {
        return idSubLinea;
    }

    public void setIdSubLinea(int idSubLinea) {
        this.idSubLinea = idSubLinea;
    }

    public String getSubLineaDescripcion() {
        return subLineaDescripcion;
    }

    public void setSubLineaDescripcion(String subLineaDescripcion) {
        this.subLineaDescripcion = subLineaDescripcion;
    }
    
    public int getIdLinea() {
        return idLinea;
    }

    public void setIdLinea(int idLinea) {
        this.idLinea = idLinea;
    }

    public String getDescLineaProd() {
        return descLineaProd;
    }

    public void setDescLineaProd(String descLineaProd) {
        this.descLineaProd = descLineaProd;
    }

    
    
    @Override
    public String toString() {
        return subLineaDescripcion;
    }
    
    
}
