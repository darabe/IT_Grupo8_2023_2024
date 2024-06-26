package modelo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Anuncio implements java.io.Serializable {

    private Integer idAnuncio;
    private Anunciante anunciante;
    private String titulo;
    private String imagen;
    private String contenido;
    private String tipo;
    private Date fechaCreacion;
    private Set noticias = new HashSet(0);

    public Anuncio() {
    }

    public Anuncio(Anunciante anunciante) {
        this.anunciante = anunciante;
    }

    public Anuncio(Anunciante anunciante, String titulo, String imagen, String contenido, String tipo, Date fechaCreacion, Set noticias) {
        this.anunciante = anunciante;
        this.titulo = titulo;
        this.imagen = imagen;
        this.contenido = contenido;
        this.tipo = tipo;
        this.fechaCreacion = fechaCreacion;
        this.noticias = noticias;
    }

    public Integer getIdAnuncio() {
        return this.idAnuncio;
    }

    public void setIdAnuncio(Integer idAnuncio) {
        this.idAnuncio = idAnuncio;
    }

    public Anunciante getAnunciante() {
        return this.anunciante;
    }

    public void setAnunciante(Anunciante anunciante) {
        this.anunciante = anunciante;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getImagen() {
        return this.imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getContenido() {
        return this.contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFechaCreacion() {
        return this.fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Set getNoticias() {
        return this.noticias;
    }

    public void setNoticias(Set noticias) {
        this.noticias = noticias;
    }

}
