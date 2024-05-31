package modelo;

import java.util.HashSet;
import java.util.Set;

public class Etiqueta implements java.io.Serializable {

    private Integer idEtiqueta;
    private String nombre;
    private String descripcion;
    private Set noticiaEtiquetas = new HashSet(0);

    public Etiqueta() {
    }

    public Etiqueta(String nombre, String descripcion, Set noticiaEtiquetas) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.noticiaEtiquetas = noticiaEtiquetas;
    }

    public Integer getIdEtiqueta() {
        return this.idEtiqueta;
    }

    public void setIdEtiqueta(Integer idEtiqueta) {
        this.idEtiqueta = idEtiqueta;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set getNoticiaEtiquetas() {
        return this.noticiaEtiquetas;
    }

    public void setNoticiaEtiquetas(Set noticiaEtiquetas) {
        this.noticiaEtiquetas = noticiaEtiquetas;
    }

}
