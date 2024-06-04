package modelo.actions.valoracion;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpSession;
import modelo.Comentario;
import modelo.Valoracion;
import modelo.dao.ComentarioDAO;
import modelo.dao.UsuarioDAO;
import modelo.dao.ValoracionDAO;
import org.apache.struts2.ServletActionContext;

public class actualizarValoracionAction extends ActionSupport {

    private HttpSession sesion;
    private String id;
    private String puntuacion;
    private Valoracion valoracion;
    private String idComentario;

    public actualizarValoracionAction() {
        valoracion = new Valoracion();
        this.clearErrorsAndMessages();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(String puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Valoracion getValoracion() {
        return valoracion;
    }

    public void setValoracion(Valoracion valoracion) {
        this.valoracion = valoracion;
    }

    public HttpSession getSesion() {
        return sesion;
    }

    public void setSesion(HttpSession sesion) {
        this.sesion = sesion;
    }

    public String getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(String idComentario) {
        this.idComentario = idComentario;
    }

    @Override
    public void validate() {
        // 
    }

    @Override
    public String execute() throws Exception {
        
        this.sesion = ServletActionContext.getRequest().getSession(false);
        int idUser=(int)this.sesion.getAttribute("idUsuario");
        ValoracionDAO dao = new ValoracionDAO();
        valoracion = dao.obtenerValoracion(Integer.parseInt(id));
        if (valoracion == null) {
            addActionError("¡No existe la valoración especificada!");
            return ERROR;
        }
        // Obtener la fecha actual con el formato deseado
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = formato.format(new Date());
        Date fechaActualizada = formato.parse(fecha);
        // Cargar los nuevos atributos de la Valoración
        valoracion.setPuntuacion(Integer.parseInt(puntuacion));
        valoracion.setFechaCreacion(fechaActualizada);
        // ARREGLAR
        Comentario comentario=new ComentarioDAO().obtenerComentario(Integer.parseInt(this.idComentario));
        valoracion.setComentario(comentario);
        
        UsuarioDAO udao=new UsuarioDAO();
        valoracion.setUsuario(udao.obtenerUsuario(idUser));
        // Actualizar un Comentario existente
        dao.actualizarValoracion(valoracion);
        return SUCCESS;
    }

}
