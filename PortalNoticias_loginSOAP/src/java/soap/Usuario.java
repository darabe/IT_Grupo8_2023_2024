package soap;

import java.util.Date;

public class Usuario implements java.io.Serializable {

    private Integer idUsuario;
    private String nombre;
    private String correo;
    private String contrasenya;
    private String rol;
    private Date fechaRegistro;

    public Usuario() {
    }

    public Usuario(String nombre, String correo, String contrasenya, String rol, Date fechaRegistro) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasenya = contrasenya;
        this.rol = rol;
        this.fechaRegistro = fechaRegistro;
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

}
