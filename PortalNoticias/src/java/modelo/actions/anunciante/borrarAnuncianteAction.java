package modelo.actions.anunciante;

import com.opensymphony.xwork2.ActionSupport;
import modelo.Anunciante;
import modelo.dao.AnuncianteDAO;

public class borrarAnuncianteAction extends ActionSupport {

    private String id;
    private Anunciante anunciante;

    public borrarAnuncianteAction() {
        anunciante = new Anunciante();
        this.clearErrorsAndMessages();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Anunciante getAnunciante() {
        return anunciante;
    }

    public void setAnunciante(Anunciante anunciante) {
        this.anunciante = anunciante;
    }

    @Override
    public String execute() throws Exception {
        AnuncianteDAO dao = new AnuncianteDAO();
        anunciante = dao.obtenerAnunciante(Integer.parseInt(id));
        dao.borrarAnunciante(anunciante);
        return SUCCESS;
    }

}
