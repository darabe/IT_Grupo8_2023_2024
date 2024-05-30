package modelo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Comentario implements java.io.Serializable {

    private Integer idComentario;
    private Noticia noticia;
    private Usuario usuario;
    private String contenido;
    private Date fechaCreacion;
    private Set valoracions = new HashSet(0);

    public Comentario() {
    }

    public Comentario(Noticia noticia, Usuario usuario) {
        this.noticia = noticia;
        this.usuario = usuario;
    }

    public Comentario(Noticia noticia, Usuario usuario, String contenido, Date fechaCreacion, Set valoracions) {
        this.noticia = noticia;
        this.usuario = usuario;
        this.contenido = contenido;
        this.fechaCreacion = fechaCreacion;
        this.valoracions = valoracions;
    }

    public Integer getIdComentario() {
        return this.idComentario;
    }

    public void setIdComentario(Integer idComentario) {
        this.idComentario = idComentario;
    }

    public Noticia getNoticia() {
        return this.noticia;
    }

    public void setNoticia(Noticia noticia) {
        this.noticia = noticia;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getContenido() {
        return this.contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getFechaCreacion() {
        return this.fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Set getValoracions() {
        return this.valoracions;
    }

    public void setValoracions(Set valoracions) {
        this.valoracions = valoracions;
    }

}
