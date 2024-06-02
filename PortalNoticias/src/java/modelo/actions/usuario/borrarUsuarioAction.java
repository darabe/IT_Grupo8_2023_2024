package modelo.actions.usuario;

import com.opensymphony.xwork2.ActionSupport;
import modelo.Usuario;
import modelo.dao.UsuarioDAO;

public class borrarUsuarioAction extends ActionSupport {

    private String id;
    private Usuario usuario;

    public borrarUsuarioAction() {
        usuario = new Usuario();
        this.clearErrorsAndMessages();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String execute() throws Exception {
        UsuarioDAO dao = new UsuarioDAO();
        usuario = dao.obtenerUsuario(Integer.parseInt(id));
        dao.borrarUsuario(usuario);
        return SUCCESS;
    }

}
