package modelo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Anunciante implements java.io.Serializable {

    private Integer idAnunciante;
    private String nombre;
    private String correo;
    private String telefono;
    private String direccion;
    private String pais;
    private Date fechaRegistro;
    private Set anuncios = new HashSet(0);

    public Anunciante() {
    }

    public Anunciante(String nombre, String correo, String telefono, String direccion, String pais, Date fechaRegistro, Set anuncios) {
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.pais = pais;
        this.fechaRegistro = fechaRegistro;
        this.anuncios = anuncios;
    }

    public Integer getIdAnunciante() {
        return this.idAnunciante;
    }

    public void setIdAnunciante(Integer idAnunciante) {
        this.idAnunciante = idAnunciante;
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

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPais() {
        return this.pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Date getFechaRegistro() {
        return this.fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Set getAnuncios() {
        return this.anuncios;
    }

    public void setAnuncios(Set anuncios) {
        this.anuncios = anuncios;
    }

}
