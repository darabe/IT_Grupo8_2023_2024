package modelo;
// Generated 21-may-2024 9:44:01 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Noticia generated by hbm2java
 */
public class Noticia  implements java.io.Serializable {


     private Integer idNoticia;
     private Anuncio anuncio;
     private Categoria categoria;
     private Usuario usuario;
     private String autor;
     private String titulo;
     private String imagen;
     private String contenido;
     private Date fechaCreacion;
     private Set etiquetas = new HashSet(0);
     private Set comentarios = new HashSet(0);

    public Noticia() {
    }

	
    public Noticia(Anuncio anuncio, Categoria categoria, Usuario usuario) {
        this.anuncio = anuncio;
        this.categoria = categoria;
        this.usuario = usuario;
    }
    public Noticia(Anuncio anuncio, Categoria categoria, Usuario usuario, String autor, String titulo, String imagen, String contenido, Date fechaCreacion, Set etiquetas, Set comentarios) {
       this.anuncio = anuncio;
       this.categoria = categoria;
       this.usuario = usuario;
       this.autor = autor;
       this.titulo = titulo;
       this.imagen = imagen;
       this.contenido = contenido;
       this.fechaCreacion = fechaCreacion;
       this.etiquetas = etiquetas;
       this.comentarios = comentarios;
    }
   
    public Integer getIdNoticia() {
        return this.idNoticia;
    }
    
    public void setIdNoticia(Integer idNoticia) {
        this.idNoticia = idNoticia;
    }
    public Anuncio getAnuncio() {
        return this.anuncio;
    }
    
    public void setAnuncio(Anuncio anuncio) {
        this.anuncio = anuncio;
    }
    public Categoria getCategoria() {
        return this.categoria;
    }
    
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public String getAutor() {
        return this.autor;
    }
    
    public void setAutor(String autor) {
        this.autor = autor;
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
    public Date getFechaCreacion() {
        return this.fechaCreacion;
    }
    
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    public Set getEtiquetas() {
        return this.etiquetas;
    }
    
    public void setEtiquetas(Set etiquetas) {
        this.etiquetas = etiquetas;
    }
    public Set getComentarios() {
        return this.comentarios;
    }
    
    public void setComentarios(Set comentarios) {
        this.comentarios = comentarios;
    }




}


