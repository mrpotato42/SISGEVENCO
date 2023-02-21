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
public class TipoDocumento {
    private int codigoDocumento;
    private String descripcion;

    public TipoDocumento(int codigoDocumento, String descripcion) {
        this.codigoDocumento = codigoDocumento;
        this.descripcion = descripcion;
    }

    public TipoDocumento() {
    }

    public int getCodigoDocumento() {
        return codigoDocumento;
    }

    public void setCodigoDocumento(int codigoDocumento) {
        this.codigoDocumento = codigoDocumento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return  descripcion;
    }
    
}
