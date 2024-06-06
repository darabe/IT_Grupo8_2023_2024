package modelo.actions.valoracion;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import modelo.Comentario;
import modelo.Valoracion;
import modelo.dao.ComentarioDAO;
import modelo.dao.ValoracionDAO;
import org.apache.struts2.ServletActionContext;

public class obtenerValoracionAction extends ActionSupport {

    private HttpSession sesion;
    private String idFiltrado;
    private Valoracion valoracion;
    private List<Valoracion> valoraciones;
    
    private List<Comentario> listComentarios;

    public obtenerValoracionAction() {
        sesion = ServletActionContext.getRequest().getSession(false);
        valoracion = null;
        valoraciones = new ArrayList<>();
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

    public Valoracion getValoracion() {
        return valoracion;
    }

    public void setValoracion(Valoracion valoracion) {
        this.valoracion = valoracion;
    }

    public List<Valoracion> getValoraciones() {
        return valoraciones;
    }

    public void setValoraciones(List<Valoracion> valoraciones) {
        this.valoraciones = valoraciones;
    }

    public List<Comentario> getListComentarios() {
        return listComentarios;
    }

    public void setListComentarios(List<Comentario> listComentarios) {
        this.listComentarios = listComentarios;
    }
    
    

    public String obtenerValoracion() {
        ValoracionDAO dao = new ValoracionDAO();
        valoracion = dao.obtenerValoracion(Integer.parseInt(idFiltrado));
        if (valoracion == null) {
            addActionError("¡No se ha encontrado ninguna valoración!");
            return ERROR;
        }
        sesion.setAttribute("valoracion", valoracion);
        return SUCCESS;
    }

    public String obtenerValoracionFiltrado() {
        ValoracionDAO dao = new ValoracionDAO();
        valoracion = dao.obtenerValoracion(Integer.parseInt(idFiltrado));
        if (valoracion == null) {
            addActionError("¡No se ha encontrado ninguna valoracion!");
            return ERROR;
        }
        valoraciones.clear();
        valoraciones.add(valoracion);
        sesion.setAttribute("valoraciones", valoraciones);
        return SUCCESS;
    }

    @Override
    public String execute() throws Exception {
        ValoracionDAO dao = new ValoracionDAO();
        valoraciones = dao.obtenerValoraciones();
        if (valoraciones == null || valoraciones.isEmpty()) {
            addActionError("¡La lista de valoraciones está vacía!");
            return ERROR;
        }
        ComentarioDAO cdao=new ComentarioDAO();
        this.listComentarios=cdao.obtenerComentarios();
        sesion.setAttribute("valoraciones", valoraciones);
        return SUCCESS;
    }

}
