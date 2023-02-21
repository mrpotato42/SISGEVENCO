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
public class TipoIdentidad {
    private int idTipoIdentidad;
    private String nombreTipoIdentidad;

    public TipoIdentidad(int idTipoIdentidad, String nombreTipoIdentidad) {
        this.idTipoIdentidad = idTipoIdentidad;
        this.nombreTipoIdentidad = nombreTipoIdentidad;
    }

    public TipoIdentidad() {
    }

    public int getIdTipoIdentidad() {
        return idTipoIdentidad;
    }

    public void setIdTipoIdentidad(int idTipoIdentidad) {
        this.idTipoIdentidad = idTipoIdentidad;
    }

    public String getNombreTipoIdentidad() {
        return nombreTipoIdentidad;
    }

    public void setNombreTipoIdentidad(String nombreTipoIdentidad) {
        this.nombreTipoIdentidad = nombreTipoIdentidad;
    }

    @Override
    public String toString() {
        return  nombreTipoIdentidad;
    }
    
    
   
}
