package modelo;

import java.util.HashSet;
import java.util.Set;

public class Categoria implements java.io.Serializable {

    private Integer idCategoria;
    private String nombre;
    private String descripcion;
    private Set noticias = new HashSet(0);

    public Categoria() {
    }

    public Categoria(String nombre, String descripcion, Set noticias) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.noticias = noticias;
    }

    public Integer getIdCategoria() {
        return this.idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
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

    public Set getNoticias() {
        return this.noticias;
    }

    public void setNoticias(Set noticias) {
        this.noticias = noticias;
    }

}
