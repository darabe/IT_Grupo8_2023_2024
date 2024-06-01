package modelo.actions.anuncio;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import modelo.Anuncio;
import modelo.dao.AnuncioDAO;
import org.apache.struts2.ServletActionContext;

public class obtenerAnuncioAction extends ActionSupport {

    private HttpSession sesion;
    private String idFiltrado;
    private Anuncio anuncio;
    private List<Anuncio> anuncios;

    public obtenerAnuncioAction() {
        sesion = ServletActionContext.getRequest().getSession(false);
        anuncio = null;
        anuncios = new ArrayList<>();
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

    public Anuncio getAnuncio() {
        return anuncio;
    }

    public void setAnuncio(Anuncio anuncio) {
        this.anuncio = anuncio;
    }

    public List<Anuncio> getAnuncios() {
        return anuncios;
    }

    public void setAnuncios(List<Anuncio> anuncios) {
        this.anuncios = anuncios;
    }

    public String obtenerAnuncio() {
        AnuncioDAO dao = new AnuncioDAO();
        anuncio = dao.obtenerAnuncio(Integer.parseInt(idFiltrado));
        if (anuncio == null) {
            addActionError("¡No se ha encontrado ningún anuncio!");
            return ERROR;
        }
        sesion.setAttribute("anuncio", anuncio);
        return SUCCESS;
    }

    public String obtenerAnuncioFiltrado() {
        AnuncioDAO dao = new AnuncioDAO();
        anuncio = dao.obtenerAnuncio(Integer.parseInt(idFiltrado));
        if (anuncio == null) {
            addActionError("¡No se ha encontrado ningún anuncio!");
            return ERROR;
        }
        anuncios.clear();
        anuncios.add(anuncio);
        sesion.setAttribute("anuncios", anuncios);
        return SUCCESS;
    }

    @Override
    public String execute() throws Exception {
        AnuncioDAO dao = new AnuncioDAO();
        anuncios = dao.obtenerAnuncios();
        if (anuncios == null || anuncios.isEmpty()) {
            addActionError("¡La lista de anuncios está vacía!");
            return ERROR;
        }
        sesion.setAttribute("anuncios", anuncios);
        return SUCCESS;
    }

}
