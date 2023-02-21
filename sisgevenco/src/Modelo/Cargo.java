


package Modelo;


public class Cargo {
    private int idCargo;
    private String nombre;
    private String descripcion;


    public Cargo (int idCargo, String nombre, String descripcion) {
        this.idCargo = idCargo;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Cargo() {
    }

    public int getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return nombre;
    }

   
    
    
    
}

