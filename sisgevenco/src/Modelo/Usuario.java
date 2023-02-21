/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Leonardo
 */
public class Usuario {
    
    private int idUsuario;   
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String login;
    private String password;
    private int idRol;
    private String nomRol;
    private String sexo;
    private int idTipoIdentidad;
    private String nombreTipoIdentidad;
    private String numeroIdentidad;
    private Date fechaNac;
    private int idCargo;
    private String nomCargo;
    private HorarioLaboral horarioLaboral;
    private String direccion;
    private String telefono;
    private String estado;

    public Usuario(int idUsuario, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String login, String password, int idRol, String nomRol, String sexo, int idTipoIdentidad, String nombreTipoIdentidad, String numeroIdentidad, Date fechaNac, int idCargo, String nomCargo, HorarioLaboral horarioLaboral, String direccion, String telefono, String estado) {
        this.idUsuario = idUsuario;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.login = login;
        this.password = password;
        this.idRol = idRol;
        this.nomRol = nomRol;
        this.sexo = sexo;
        this.idTipoIdentidad = idTipoIdentidad;
        this.nombreTipoIdentidad = nombreTipoIdentidad;
        this.numeroIdentidad = numeroIdentidad;
        this.fechaNac = fechaNac;
        this.idCargo = idCargo;
        this.nomCargo = nomCargo;
        this.horarioLaboral = horarioLaboral;
        this.direccion = direccion;
        this.telefono = telefono;
        this.estado = estado;
    }
    
   

    public Usuario() {
    }
            
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getNomRol() {
        return nomRol;
    }

    public void setNomRol(String nomRol) {
        this.nomRol = nomRol;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
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

    public String getNumeroIdentidad() {
        return numeroIdentidad;
    }

    public void setNumeroIdentidad(String numeroIdentidad) {
        this.numeroIdentidad = numeroIdentidad;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public int getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }

    public String getNomCargo() {
        return nomCargo;
    }

    public void setNomCargo(String nomCargo) {
        this.nomCargo = nomCargo;
    }

    public HorarioLaboral getHorarioLaboral() {
        return horarioLaboral;
    }

    public void setHorarioLaboral(HorarioLaboral horarioLaboral) {
        this.horarioLaboral = horarioLaboral;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    
}
