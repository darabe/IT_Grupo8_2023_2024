package modelo.actions.usuario;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import javax.servlet.http.HttpSession;
import modelo.Anunciante;
import modelo.Anuncio;
import modelo.Categoria;
import modelo.Comentario;
import modelo.Etiqueta;
import modelo.Noticia;
import modelo.Usuario;
import modelo.Valoracion;
import modelo.dao.AnuncianteDAO;
import modelo.dao.AnuncioDAO;
import modelo.dao.CategoriaDAO;
import modelo.dao.ComentarioDAO;
import modelo.dao.EtiquetaDAO;
import modelo.dao.NoticiaDAO;
import modelo.dao.UsuarioDAO;
import modelo.dao.ValoracionDAO;
import org.apache.struts2.ServletActionContext;

public class gestionPerfilAdminAction extends ActionSupport {

    private HttpSession session;
    private Usuario usuario;
    private List<Anunciante> anunciantes;
    private List<Anuncio> anuncios;
    private List<Categoria> categorias;
    private List<Comentario> comentarios;
    private List<Etiqueta> etiquetas;
    private List<Noticia> noticias;
    private List<Usuario> usuarios;
    private List<Valoracion> valoraciones;

    public gestionPerfilAdminAction() {
    }

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Anunciante> getAnunciantes() {
        return anunciantes;
    }

    public void setAnunciantes(List<Anunciante> anunciantes) {
        this.anunciantes = anunciantes;
    }

    public List<Anuncio> getAnuncios() {
        return anuncios;
    }

    public void setAnuncios(List<Anuncio> anuncios) {
        this.anuncios = anuncios;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public List<Etiqueta> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(List<Etiqueta> etiquetas) {
        this.etiquetas = etiquetas;
    }

    public List<Noticia> getNoticias() {
        return noticias;
    }

    public void setNoticias(List<Noticia> noticias) {
        this.noticias = noticias;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Valoracion> getValoraciones() {
        return valoraciones;
    }

    public void setValoraciones(List<Valoracion> valoraciones) {
        this.valoraciones = valoraciones;
    }

    @Override
    public String execute() throws Exception {
        this.session = ServletActionContext.getRequest().getSession(false);
        AnuncianteDAO daoA = new AnuncianteDAO();
        AnuncioDAO daoN = new AnuncioDAO();
        CategoriaDAO daoC = new CategoriaDAO();
        ComentarioDAO daoO = new ComentarioDAO();
        EtiquetaDAO daoE = new EtiquetaDAO();
        NoticiaDAO daoT = new NoticiaDAO();
        UsuarioDAO daoU = new UsuarioDAO();
        ValoracionDAO daoV = new ValoracionDAO();
        int idUsuario = (int) session.getAttribute("idUsuario");
        this.usuario = daoU.obtenerUsuario(idUsuario);
        anunciantes = daoA.obtenerAnunciantes();
        anuncios = daoN.obtenerAnuncios();
        categorias = daoC.obtenerCategorias();
        comentarios = daoO.obtenerComentarios();
        etiquetas = daoE.obtenerEtiquetas();
        noticias = daoT.obtenerNoticias();
        usuarios = daoU.obtenerUsuarios();
        valoraciones = daoV.obtenerValoraciones();
        return SUCCESS;
    }

}
