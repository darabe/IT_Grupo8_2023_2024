package modelo.actions.usuario;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import javax.servlet.http.HttpSession;
import modelo.Usuario;
import modelo.dao.ComentarioDAO;
import modelo.dao.UsuarioDAO;
import modelo.dao.ValoracionDAO;
import org.apache.struts2.ServletActionContext;

public class gestionPerfilAdminAction extends ActionSupport {

    private HttpSession session;
    private Usuario usuario;

    public gestionPerfilAdminAction() {
    }

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String execute() throws Exception {
        this.session = ServletActionContext.getRequest().getSession(false);
        UsuarioDAO udao = new UsuarioDAO();
        int idUsuario = (int) session.getAttribute("idUsuario");
        this.usuario = udao.obtenerUsuario(idUsuario);
        return SUCCESS;
    }

}
