package modelo.actions.noticia;

import com.opensymphony.xwork2.ActionSupport;
import modelo.Noticia;
import modelo.dao.NoticiaDAO;

public class borrarNoticiaAction extends ActionSupport {

    private String id;
    private Noticia noticia;

    public borrarNoticiaAction() {
        noticia = new Noticia();
        this.clearErrorsAndMessages();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Noticia getNoticia() {
        return noticia;
    }

    public void setNoticia(Noticia noticia) {
        this.noticia = noticia;
    }

    @Override
    public String execute() throws Exception {
        NoticiaDAO dao = new NoticiaDAO();
        noticia = dao.obtenerNoticia(Integer.parseInt(id));
        dao.borrarNoticia(noticia);
        return SUCCESS;
    }

}
