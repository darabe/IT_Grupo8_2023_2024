package modelo.actions.comentario;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import modelo.Comentario;
import modelo.Valoracion;
import modelo.dao.ComentarioDAO;
import modelo.dao.ValoracionDAO;

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
        comentario = dao.obtenerComentario(Integer.parseInt(this.id));
        ValoracionDAO vdao = new ValoracionDAO();
        List<Valoracion> listValoraciones = vdao.obtenerValoracionesComentario(Integer.parseInt(this.id));
        for (int i = 0; i < listValoraciones.size(); i++) {
            vdao.borrarValoracion(listValoraciones.get(i));
        }
        dao.borrarComentario(comentario);
        return SUCCESS;
    }

}
