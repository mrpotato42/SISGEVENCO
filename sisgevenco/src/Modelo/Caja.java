
package Modelo;

/**
 *
 * @author DANIEL
 */
public class Caja {
    private int codigoCaja;  
    private String ubicacion;
    private String descripcion;

    public Caja(int codigoCaja, String ubicacion, String descripcion) {
        this.codigoCaja = codigoCaja;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
    }

    public Caja() {
    }

    public int getCodigoCaja() {
        return codigoCaja;
    }

    public void setCodigoCaja(int codigoCaja) {
        this.codigoCaja = codigoCaja;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
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
