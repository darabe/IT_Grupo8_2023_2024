package modelo.actions.etiqueta;

import com.opensymphony.xwork2.ActionSupport;
import modelo.Etiqueta;
import modelo.dao.EtiquetaDAO;

public class borrarEtiquetaAction extends ActionSupport {

    private String id;
    private Etiqueta etiqueta;

    public borrarEtiquetaAction() {
        etiqueta = new Etiqueta();
        this.clearErrorsAndMessages();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Etiqueta getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(Etiqueta etiqueta) {
        this.etiqueta = etiqueta;
    }

    @Override
    public void validate() {
        //
    }

    @Override
    public String execute() throws Exception {
        EtiquetaDAO dao = new EtiquetaDAO();
        etiqueta = dao.obtenerEtiqueta(Integer.parseInt(id));
        dao.borrarEtiqueta(etiqueta);
        return SUCCESS;
    }

}
