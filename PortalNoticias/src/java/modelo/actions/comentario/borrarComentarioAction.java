package modelo.actions.comentario;

import com.opensymphony.xwork2.ActionSupport;
import modelo.Comentario;
import modelo.dao.ComentarioDAO;

public class borrarComentarioAction extends ActionSupport {

    private String id;
    private Comentario comentario;

    public borrarComentarioAction() {
        comentario = new Comentario();
        this.clearErrorsAndMessages();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Comentario getComentario() {
        return comentario;
    }

    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }

    @Override
    public String execute() throws Exception {
        ComentarioDAO dao = new ComentarioDAO();
        comentario = dao.obtenerComentario(Integer.parseInt(id));
        dao.borrarComentario(comentario);
        return SUCCESS;
    }

}
