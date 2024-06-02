package modelo.actions.etiqueta;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import modelo.Etiqueta;
import modelo.dao.EtiquetaDAO;
import org.apache.struts2.ServletActionContext;

public class obtenerEtiquetaAction extends ActionSupport {

    private HttpSession sesion;
    private String idFiltrado;
    private Etiqueta etiqueta;
    private List<Etiqueta> etiquetas;

    public obtenerEtiquetaAction() {
        sesion = ServletActionContext.getRequest().getSession(false);
        etiqueta = null;
        etiquetas = new ArrayList<>();
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

    public Etiqueta getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(Etiqueta etiqueta) {
        this.etiqueta = etiqueta;
    }

    public List<Etiqueta> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(List<Etiqueta> etiquetas) {
        this.etiquetas = etiquetas;
    }

    public String obtenerEtiqueta() {
        EtiquetaDAO dao = new EtiquetaDAO();
        etiqueta = dao.obtenerEtiqueta(Integer.parseInt(idFiltrado));
        if (etiqueta == null) {
            addActionError("¡No se ha encontrado ninguna etiqueta!");
            return ERROR;
        }
        sesion.setAttribute("etiqueta", etiqueta);
        return SUCCESS;
    }

    public String obtenerEtiquetaFiltrado() {
        EtiquetaDAO dao = new EtiquetaDAO();
        etiqueta = dao.obtenerEtiqueta(Integer.parseInt(idFiltrado));
        if (etiqueta == null) {
            addActionError("¡No se ha encontrado ninguna etiqueta!");
            return ERROR;
        }
        etiquetas.clear();
        etiquetas.add(etiqueta);
        sesion.setAttribute("etiquetas", etiquetas);
        return SUCCESS;
    }

    @Override
    public String execute() throws Exception {
        EtiquetaDAO dao = new EtiquetaDAO();
        etiquetas = dao.obtenerEtiquetas();
        if (etiquetas == null || etiquetas.isEmpty()) {
            addActionError("¡La lista de etiquetas está vacía!");
            return ERROR;
        }
        sesion.setAttribute("etiquetas", etiquetas);
        return SUCCESS;
    }

}
