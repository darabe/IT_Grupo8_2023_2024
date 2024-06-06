package modelo.actions.comentario;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import modelo.Comentario;
import modelo.Noticia;
import modelo.dao.ComentarioDAO;
import modelo.dao.NoticiaDAO;
import org.apache.struts2.ServletActionContext;

public class obtenerComentarioAction extends ActionSupport {

    private HttpSession sesion;
    private String idFiltrado;
    private Comentario comentario;
    private List<Comentario> comentarios;
    private List<Noticia> noticias;

    public obtenerComentarioAction() {
        sesion = ServletActionContext.getRequest().getSession(false);
        comentario = null;
        comentarios = new ArrayList<>();
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

    public Comentario getComentario() {
        return comentario;
    }

    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public String obtenerComentario() {
        ComentarioDAO dao = new ComentarioDAO();
        comentario = dao.obtenerComentario(Integer.parseInt(idFiltrado));
        if (comentario == null) {
            addActionError("¡No se ha encontrado ningún comentario!");
            return ERROR;
        }
        sesion.setAttribute("comentario", comentario);
        return SUCCESS;
    }

    public String obtenerComentarioFiltrado() {
        ComentarioDAO dao = new ComentarioDAO();
        comentario = dao.obtenerComentario(Integer.parseInt(idFiltrado));
        if (comentario == null) {
            addActionError("¡No se ha encontrado ningún comentario!");
            return ERROR;
        }
        comentarios.clear();
        comentarios.add(comentario);
        sesion.setAttribute("comentarios", comentarios);
        return SUCCESS;
    }

    public List<Noticia> getNoticias() {
        return noticias;
    }

    public void setNoticias(List<Noticia> noticias) {
        this.noticias = noticias;
    }
    
    

    @Override
    public String execute() throws Exception {
        ComentarioDAO dao = new ComentarioDAO();
        comentarios = dao.obtenerComentarios();
        if (comentarios == null || comentarios.isEmpty()) {
            addActionError("¡La lista de comentarios está vacía!");
            return ERROR;
        }
        NoticiaDAO ndao=new NoticiaDAO();
        this.noticias=ndao.obtenerNoticias();
        sesion.setAttribute("comentarios", comentarios);
        return SUCCESS;
    }

}
