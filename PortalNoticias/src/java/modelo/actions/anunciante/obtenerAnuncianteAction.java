package modelo.actions.anunciante;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import modelo.Anunciante;
import modelo.dao.AnuncianteDAO;
import org.apache.struts2.ServletActionContext;

public class obtenerAnuncianteAction extends ActionSupport {

    private HttpSession sesion;
    private String idFiltrado;
    private Anunciante anunciante;
    private List<Anunciante> anunciantes;

    public obtenerAnuncianteAction() {
        sesion = ServletActionContext.getRequest().getSession(false);
        anunciante = null;
        anunciantes = new ArrayList<>();
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

    public Anunciante getAnunciante() {
        return anunciante;
    }

    public void setAnunciante(Anunciante anunciante) {
        this.anunciante = anunciante;
    }

    public List<Anunciante> getAnunciantes() {
        return anunciantes;
    }

    public void setAnunciantes(List<Anunciante> anunciantes) {
        this.anunciantes = anunciantes;
    }

    public String obtenerAnunciante() {
        AnuncianteDAO dao = new AnuncianteDAO();
        anunciante = dao.obtenerAnunciante(Integer.parseInt(idFiltrado));
        if (anunciante == null) {
            addActionError("¡No se ha encontrado ningún anunciante!");
            return ERROR;
        }
        sesion.setAttribute("anunciante", anunciante);
        return SUCCESS;
    }

    public String obtenerAnuncianteFiltrado() {
        AnuncianteDAO dao = new AnuncianteDAO();
        anunciante = dao.obtenerAnunciante(Integer.parseInt(idFiltrado));
        if (anunciante == null) {
            addActionError("¡No se ha encontrado ningún anunciante!");
            return ERROR;
        }
        anunciantes.clear();
        anunciantes.add(anunciante);
        sesion.setAttribute("anunciantes", anunciantes);
        return SUCCESS;
    }

    @Override
    public String execute() throws Exception {
        AnuncianteDAO dao = new AnuncianteDAO();
        anunciantes = dao.obtenerAnunciantes();
        if (anunciantes == null || anunciantes.isEmpty()) {
            addActionError("¡La lista de anunciantes está vacía!");
            return ERROR;
        }
        sesion.setAttribute("anunciantes", anunciantes);
        return SUCCESS;
    }
}
