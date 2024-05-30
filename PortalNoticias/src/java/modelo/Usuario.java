package modelo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Usuario implements java.io.Serializable {

    private Integer idUsuario;
    private String nombre;
    private String correo;
    private String contrasenya;
    private String rol;
    private Date fechaRegistro;
    private Set noticias = new HashSet(0);
    private Set comentarios = new HashSet(0);
    private Set valoracions = new HashSet(0);

    public Usuario() {
    }

    public Usuario(String nombre, String correo, String contrasenya, String rol, Date fechaRegistro, Set noticias, Set comentarios, Set valoracions) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasenya = contrasenya;
        this.rol = rol;
        this.fechaRegistro = fechaRegistro;
        this.noticias = noticias;
        this.comentarios = comentarios;
        this.valoracions = valoracions;
    }

    public Integer getIdUsuario() {
        return this.idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenya() {
        return this.contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public String getRol() {
        return this.rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Date getFechaRegistro() {
        return this.fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Set getNoticias() {
        return this.noticias;
    }

    public void setNoticias(Set noticias) {
        this.noticias = noticias;
    }

    public Set getComentarios() {
        return this.comentarios;
    }

    public void setComentarios(Set comentarios) {
        this.comentarios = comentarios;
    }

    public Set getValoracions() {
        return this.valoracions;
    }

    public void setValoracions(Set valoracions) {
        this.valoracions = valoracions;
    }

}
