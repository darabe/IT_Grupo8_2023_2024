package modelo;

import java.util.Date;

public class Valoracion implements java.io.Serializable {

    private Integer idValoracion;
    private Comentario comentario;
    private Usuario usuario;
    private Integer puntuacion;
    private Date fechaCreacion;

    public Valoracion() {
    }

    public Valoracion(Comentario comentario, Usuario usuario) {
        this.comentario = comentario;
        this.usuario = usuario;
    }

    public Valoracion(Comentario comentario, Usuario usuario, Integer puntuacion, Date fechaCreacion) {
        this.comentario = comentario;
        this.usuario = usuario;
        this.puntuacion = puntuacion;
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getIdValoracion() {
        return this.idValoracion;
    }

    public void setIdValoracion(Integer idValoracion) {
        this.idValoracion = idValoracion;
    }

    public Comentario getComentario() {
        return this.comentario;
    }

    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getPuntuacion() {
        return this.puntuacion;
    }

    public void setPuntuacion(Integer puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Date getFechaCreacion() {
        return this.fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

}
