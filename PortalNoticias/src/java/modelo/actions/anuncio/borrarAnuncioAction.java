package modelo.actions.anuncio;

import com.opensymphony.xwork2.ActionSupport;
import modelo.Anuncio;
import modelo.dao.AnuncioDAO;

public class borrarAnuncioAction extends ActionSupport {

    private String id;
    private Anuncio anuncio;

    public borrarAnuncioAction() {
        anuncio = new Anuncio();
        this.clearErrorsAndMessages();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Anuncio getAnuncio() {
        return anuncio;
    }

    public void setAnuncio(Anuncio anuncio) {
        this.anuncio = anuncio;
    }

    @Override
    public String execute() throws Exception {
        AnuncioDAO dao = new AnuncioDAO();
        anuncio = dao.obtenerAnuncio(Integer.parseInt(id));
        dao.borrarAnuncio(anuncio);
        return SUCCESS;
    }

}
