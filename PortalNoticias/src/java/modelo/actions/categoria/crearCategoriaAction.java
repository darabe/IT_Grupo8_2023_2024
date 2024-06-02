package modelo.actions.categoria;

import com.opensymphony.xwork2.ActionSupport;
import java.util.HashSet;
import modelo.Categoria;
import modelo.dao.CategoriaDAO;

public class crearCategoriaAction extends ActionSupport {

    private String nombre;
    private String descripcion;
    private Categoria categoria;

    public crearCategoriaAction() {
        categoria = new Categoria();
        this.clearErrorsAndMessages();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public void validate() {
        //
    }

    @Override
    public String execute() throws Exception {
        // Cargar los atributos
        categoria.setNombre(nombre);
        categoria.setDescripcion(descripcion);
        // ARREGLAR
        categoria.setNoticias(new HashSet(0));
        // Registrar una nueva Categoría
        CategoriaDAO dao = new CategoriaDAO();
        dao.registrarCategoria(categoria);
        return SUCCESS;
    }

}
