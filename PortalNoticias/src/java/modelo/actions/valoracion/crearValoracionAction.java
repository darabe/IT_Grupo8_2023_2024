package modelo.actions.valoracion;

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

public class crearValoracionAction extends ActionSupport {

    private HttpSession sesion;
    private String puntuacion;
    private Valoracion valoracion;
    private String idComentario;

    public crearValoracionAction() {
        valoracion = new Valoracion();
        this.clearErrorsAndMessages();
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

    @Override
    public void validate() {
        // 
    }

    public String getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(String idComentario) {
        this.idComentario = idComentario;
    }

    public HttpSession getSesion() {
        return sesion;
    }

    public void setSesion(HttpSession sesion) {
        this.sesion = sesion;
    }

    @Override
    public String execute() throws Exception {
        this.sesion = ServletActionContext.getRequest().getSession(false);
        int idUser = (int) this.sesion.getAttribute("idUsuario");
        // Obtener la fecha actual con el formato deseado
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = formato.format(new Date());
        Date fechaRegistro = formato.parse(fecha);
        // Cargar los atributos de la Valoración
        valoracion.setPuntuacion(Integer.parseInt(puntuacion));
        valoracion.setFechaCreacion(fechaRegistro);
        // ARREGLAR
        Comentario comentario = new ComentarioDAO().obtenerComentario(Integer.parseInt(this.idComentario));
        valoracion.setComentario(comentario);

        UsuarioDAO udao = new UsuarioDAO();
        valoracion.setUsuario(udao.obtenerUsuario(idUser));
        // Registrar una nueva Valoración
        ValoracionDAO dao = new ValoracionDAO();
        dao.registrarValoracion(valoracion);
        return SUCCESS;
    }

}
