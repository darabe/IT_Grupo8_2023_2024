package modelo.actions.categoria;

import com.opensymphony.xwork2.ActionSupport;
import modelo.Categoria;
import modelo.dao.CategoriaDAO;

public class borrarCategoriaAction extends ActionSupport {

    private String id;
    private Categoria categoria;

    public borrarCategoriaAction() {
        categoria = new Categoria();
        this.clearErrorsAndMessages();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String execute() throws Exception {
        CategoriaDAO dao = new CategoriaDAO();
        categoria = dao.obtenerCategoria(Integer.parseInt(id));
        dao.borrarCategoria(categoria);
        return SUCCESS;
    }

}
