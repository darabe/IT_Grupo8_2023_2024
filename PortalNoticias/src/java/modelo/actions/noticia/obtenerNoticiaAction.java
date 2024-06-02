package modelo.actions.noticia;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import modelo.Categoria;
import modelo.Noticia;
import modelo.dao.CategoriaDAO;
import modelo.dao.NoticiaDAO;
import org.apache.struts2.ServletActionContext;

public class obtenerNoticiaAction extends ActionSupport {

    private HttpSession sesion;
    private String idFiltrado;
    private Noticia noticia;
    String nombreCategoria;
    Categoria categoria;
    private List<Noticia> noticias;
    
    public obtenerNoticiaAction() {
        sesion = ServletActionContext.getRequest().getSession(false);
        noticia = null;
        noticias = new ArrayList<>();
        this.clearErrorsAndMessages();
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public HttpSession getSesion() {
        return sesion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
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

    public Noticia getNoticia() {
        return noticia;
    }

    public void setNoticia(Noticia noticia) {
        this.noticia = noticia;
    }

    public List<Noticia> getNoticias() {
        return noticias;
    }

    public void setNoticias(List<Noticia> noticias) {
        this.noticias = noticias;
    }

    public String obtenerNoticia() {
        NoticiaDAO dao = new NoticiaDAO();
        noticia = dao.obtenerNoticia(Integer.parseInt(idFiltrado));
        if (noticia == null) {
            addActionError("¡No se ha encontrado ninguna noticia!");
            return ERROR;
        }
        sesion.setAttribute("noticia", noticia);
        return SUCCESS;
    }

    public String obtenerNoticiaFiltrado() {
        NoticiaDAO dao = new NoticiaDAO();
        noticia = dao.obtenerNoticia(Integer.parseInt(idFiltrado));
        if (noticia == null) {
            addActionError("¡No se ha encontrado ninguna noticia!");
            return ERROR;
        }
        noticias.clear();
        noticias.add(noticia);
        sesion.setAttribute("noticias", noticias);
        return SUCCESS;
    }
    
    public String obtenerNoticiaPorCategoria() {
        System.out.println("Ha entrado en Action con el nombre   " + nombreCategoria);
        NoticiaDAO dao = new NoticiaDAO();
        CategoriaDAO cdao = new CategoriaDAO();
        categoria = cdao.obtenerCategoriaPorNombre(nombreCategoria);
        if (categoria == null) {
            addActionError("¡Categoría no encontrada!");
            return ERROR;
        }
        noticias=dao.obtenerNoticiaporCategoria(categoria.getIdCategoria());
        if (noticia == null) {
            addActionError("¡No se ha encontrado ninguna noticia!");
            return ERROR;
        }           
        sesion.setAttribute("categoria", categoria);
        sesion.setAttribute("noticias", noticias);
        return SUCCESS;
    }

    @Override
    public String execute() throws Exception {
        NoticiaDAO dao = new NoticiaDAO();
        noticias = dao.obtenerNoticias();
        if (noticias == null || noticias.isEmpty()) {
            addActionError("¡La lista de noticias está vacía!");
            return ERROR;
        }
        setNoticias(noticias);
        sesion.setAttribute("noticias", noticias);
        return SUCCESS;
    }

}
