package modelo.actions.categoria;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import modelo.Categoria;
import modelo.dao.CategoriaDAO;
import org.apache.struts2.ServletActionContext;

public class obtenerCategoriaAction extends ActionSupport {

    private HttpSession sesion;
    private String idFiltrado;
    private Categoria categoria;
    private List<Categoria> categorias;

    public obtenerCategoriaAction() {
        sesion = ServletActionContext.getRequest().getSession(false);
        categoria = null;
        categorias = new ArrayList<>();
        this.clearErrorsAndMessages();
    }

    public HttpSession getSesion() {
        return sesion;
    }

    public void setSesion(HttpSession sesion) {
        this.sesion = sesion;
    }

    public String getIdFiltrado() {
        return idFiltrado;
    }

    public void setIdFiltrado(String idFiltrado) {
        this.idFiltrado = idFiltrado;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public String obtenerCategoria() {
        CategoriaDAO dao = new CategoriaDAO();
        categoria = dao.obtenerCategoria(Integer.parseInt(idFiltrado));
        if (categoria == null) {
            addActionError("¡No se ha encontrado ninguna categoría!");
            return ERROR;
        }
        sesion.setAttribute("categoria", categoria);
        return SUCCESS;
    }

    public String obtenerCategoriaFiltrado() {
        CategoriaDAO dao = new CategoriaDAO();
        categoria = dao.obtenerCategoria(Integer.parseInt(idFiltrado));
        if (categoria == null) {
            addActionError("¡No se ha encontrado ninguna categoría!");
            return ERROR;
        }
        categorias.clear();
        categorias.add(categoria);
        sesion.setAttribute("categorias", categorias);
        return SUCCESS;
    }

    @Override
    public String execute() throws Exception {
        CategoriaDAO dao = new CategoriaDAO();
        categorias = dao.obtenerCategorias();
        if (categorias == null || categorias.isEmpty()) {
            addActionError("¡La lista de categorías está vacía!");
            return ERROR;
        }
        sesion.setAttribute("categorias", categorias);
        return SUCCESS;
    }
}
