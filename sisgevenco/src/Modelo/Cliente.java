/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;

/**
 *
 * @author DANIEL
 */
public class Cliente {
    private int codigoCliente;
    private int idTipoIdentidad;
    private String nombreTipoIdentidad;//no lo meti al constructor !!
    private String numeroDocumento;
    private String nombre;
    private String apellido;
    private String genero;
    private Date fechaNacimiento;
    private String direccion;
    private String telefono;
    private String email;
    private int codigoCiudad;
    private String nombreCiu;
    private String estado;

    public Cliente(int codigoCliente, int idTipoIdentidad, String nombreTipoIdentidad, String numeroDocumento, String nombre, String apellido, String genero, Date fechaNacimiento, String direccion, String telefono, String email, int codigoCiudad, String nombreCiu, String estado) {
        this.codigoCliente = codigoCliente;
        this.idTipoIdentidad = idTipoIdentidad;
        this.nombreTipoIdentidad = nombreTipoIdentidad;
        this.numeroDocumento = numeroDocumento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.codigoCiudad = codigoCiudad;
        this.nombreCiu = nombreCiu;
        this.estado = estado;
    }
        

    public Cliente() {
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
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
    
    
    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
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

    public int getCodigoCiudad() {
        return codigoCiudad;
    }

    public void setCodigoCiudad(int codigoCiudad) {
        this.codigoCiudad = codigoCiudad;
    }

    public String getNombreCiu() {
        return nombreCiu;
    }

    public void setNombreCiu(String nombreCiu) {
        this.nombreCiu = nombreCiu;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
       
    
    @Override
    public String toString() {
        return nombre + " " + apellido;
    }
    
    
    
}
