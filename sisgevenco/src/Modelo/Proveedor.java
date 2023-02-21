package Modelo;

/**
 *
 * @author Leonardo
 */
public class Proveedor {
    private int idProveedor;
    private String numeroIdentidad;
    private String nombre;
    private int codigoCiudad;
    private String nomCiudad;
    private String direccion;
    private String telefono;
    private String email;
    private String estado;

    public Proveedor(int idProveedor, String numeroIdentidad, String nombre, int codigoCiudad, String nomCiudad, String direccion, String telefono, String email, String estado) {
        this.idProveedor = idProveedor;
        this.numeroIdentidad = numeroIdentidad;
        this.nombre = nombre;
        this.codigoCiudad = codigoCiudad;
        this.nomCiudad = nomCiudad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.estado = estado;
    }

   
    public Proveedor() {
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNumeroIdentidad() {
        return numeroIdentidad;
    }

    public void setNumeroIdentidad(String numeroIdentidad) {
        this.numeroIdentidad = numeroIdentidad;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigoCiudad() {
        return codigoCiudad;
    }

    public void setCodigoCiudad(int codigoCiudad) {
        this.codigoCiudad = codigoCiudad;
    }

    public String getNomCiudad() {
        return nomCiudad;
    }

    public void setNomCiudad(String nomCiudad) {
        this.nomCiudad = nomCiudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
            
    @Override
    public String toString() {
        return nombre;
    }
    
    
}
