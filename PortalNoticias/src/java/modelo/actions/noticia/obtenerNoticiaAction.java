package modelo.actions.noticia;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import modelo.Anuncio;
import modelo.Categoria;
import modelo.Comentario;
import modelo.Etiqueta;
import modelo.Noticia;
import modelo.dao.AnuncioDAO;
import modelo.dao.CategoriaDAO;
import modelo.dao.ComentarioDAO;
import modelo.dao.EtiquetaDAO;
import modelo.dao.NoticiaDAO;
import org.apache.struts2.ServletActionContext;

public class obtenerNoticiaAction extends ActionSupport {

    private HttpSession sesion;
    private String idFiltrado;
    private Noticia noticia;
    String nombreCategoria;
    Categoria categoria;
    Anuncio anuncio;
    private List<Noticia> noticias;
    private List<Categoria> categorias;
    private List<Anuncio> anuncios;
    private List<Etiqueta> etiquetas;
    private List<Comentario> comentarios;

    public obtenerNoticiaAction() {
        sesion = ServletActionContext.getRequest().getSession(false);
        noticia = null;
        noticias = new ArrayList<>();
        categorias = new ArrayList<>();
        anuncios = new ArrayList<>();
        etiquetas = new ArrayList<>();
        comentarios = new ArrayList<>();
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

    public Anuncio getAnuncio() {
        return anuncio;
    }

    public void setAnuncio(Anuncio anuncio) {
        this.anuncio = anuncio;
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

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public List<Anuncio> getAnuncios() {
        return anuncios;
    }

    public void setAnuncios(List<Anuncio> anuncios) {
        this.anuncios = anuncios;
    }

    public List<Etiqueta> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(List<Etiqueta> etiquetas) {
        this.etiquetas = etiquetas;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
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

    public String obtenerNoticiaExtendido() {
        CategoriaDAO daoC = new CategoriaDAO();
        NoticiaDAO daoN = new NoticiaDAO();
        AnuncioDAO daoA = new AnuncioDAO();
        EtiquetaDAO daoE = new EtiquetaDAO();
        ComentarioDAO daoO = new ComentarioDAO();
        noticia = daoN.obtenerNoticia(Integer.parseInt(idFiltrado));
        categorias = daoC.obtenerCategorias();
        anuncio = daoA.obtenerAnuncio(noticia.getAnuncio().getIdAnuncio());
        etiquetas = daoE.obtenerEtiquetasPorNoticia(Integer.parseInt(idFiltrado));
        comentarios = daoO.obtenerComentariosNoticia(Integer.parseInt(idFiltrado));
        if (noticia == null) {
            addActionError("¡No se ha encontrado ninguna noticia!");
            return ERROR;
        }
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

    @Override
    public String execute() throws Exception {
        NoticiaDAO dao = new NoticiaDAO();
        noticias = dao.obtenerNoticias();
        if (noticias == null || noticias.isEmpty()) {
            addActionError("¡La lista de noticias está vacía!");
            return ERROR;
        }
        sesion.setAttribute("noticias", noticias);
        return SUCCESS;
    }

}
