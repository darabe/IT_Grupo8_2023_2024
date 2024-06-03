package modelo.actions.comentario;

import com.opensymphony.xwork2.ActionSupport;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import javax.servlet.http.HttpSession;
import modelo.Comentario;
import modelo.dao.ComentarioDAO;
import modelo.dao.NoticiaDAO;
import modelo.dao.UsuarioDAO;
import org.apache.struts2.ServletActionContext;

public class actualizarComentarioAction extends ActionSupport {

    private HttpSession sesion;
    private String id;
    private String contenido;
    private Comentario comentario;

    public actualizarComentarioAction() {
        comentario = new Comentario();
        this.clearErrorsAndMessages();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Comentario getComentario() {
        return comentario;
    }

    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }

    public HttpSession getSesion() {
        return sesion;
    }

    public void setSesion(HttpSession sesion) {
        this.sesion = sesion;
    }

    @Override
    public void validate() {
        // 
    }

    @Override
    public String execute() throws Exception {
        this.sesion = ServletActionContext.getRequest().getSession(false);
        int idUser=(int)this.sesion.getAttribute("idUsuario");
        ComentarioDAO dao = new ComentarioDAO();
        comentario = dao.obtenerComentario(Integer.parseInt(id));
        if (comentario == null) {
            addActionError("¡No existe el comentario especificado!");
            return ERROR;
        }
        // Obtener la fecha actual con el formato deseado
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = formato.format(new Date());
        Date fechaActualizada = formato.parse(fecha);
        // Cargar los nuevos atributos del Comentario
        comentario.setContenido(contenido);
        comentario.setFechaCreacion(fechaActualizada);
        UsuarioDAO udao=new UsuarioDAO();
        comentario.setUsuario(udao.obtenerUsuario(idUser));
        comentario.setValoracions(new HashSet(0));
        // Actualizar un Comentario existente
        dao.actualizarComentario(comentario);
        return SUCCESS;
    }

}
