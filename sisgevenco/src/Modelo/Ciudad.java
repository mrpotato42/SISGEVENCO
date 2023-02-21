
package Modelo;

/**
 *
 * @author DANIEL
 */
public class Ciudad {
    private int codigoCiudad;
    private String nombre;
    private String departamento;

    public Ciudad(int codigoCiudad, String nombre, String departamento) {// constructor con parametros
        this.codigoCiudad = codigoCiudad;
        this.nombre = nombre;
        this.departamento = departamento;
    }

    public Ciudad() {//constructor vacio
    }
    
    //METODOS GET Y SET

    public int getCodigoCiudad() {
        return codigoCiudad;
    }

    public void setCodigoCiudad(int codigoCiudad) {
        this.codigoCiudad = codigoCiudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
  

    @Override
    public String toString() {
        return nombre;
    }

   
    
    
    
    
}
