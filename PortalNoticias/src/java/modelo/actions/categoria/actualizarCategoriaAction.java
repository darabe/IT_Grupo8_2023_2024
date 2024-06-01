package modelo.actions.categoria;

import com.opensymphony.xwork2.ActionSupport;
import java.util.HashSet;
import modelo.Categoria;
import modelo.dao.CategoriaDAO;

public class actualizarCategoriaAction extends ActionSupport {

    private String id;
    private String nombre;
    private String descripcion;
    private Categoria categoria;

    public actualizarCategoriaAction() {
        categoria = new Categoria();
        this.clearErrorsAndMessages();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    }

    @Override
    public String execute() throws Exception {
        CategoriaDAO dao = new CategoriaDAO();
        categoria = dao.obtenerCategoria(Integer.parseInt(id));
        if (categoria == null) {
            addActionError("¡No existe la categoría especificada!");
            return ERROR;
        }
        // Cargar los nuevos atributos de la Categoría
        categoria.setNombre(nombre);
        categoria.setDescripcion(descripcion);
        // ARREGLAR
        categoria.setNoticias(new HashSet(0));
        // Actualizar una Categoría existente
        dao.actualizarCategoria(categoria);
        return SUCCESS;
    }

}
