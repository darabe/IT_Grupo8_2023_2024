package modelo.actions.usuario;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import modelo.Usuario;
import modelo.dao.UsuarioDAO;
import org.apache.struts2.ServletActionContext;

public class obtenerUsuarioAction extends ActionSupport {

    private HttpSession sesion;
    private String idFiltrado;
    private Usuario usuario;
    private List<Usuario> usuarios;

    public obtenerUsuarioAction() {
        sesion = ServletActionContext.getRequest().getSession(false);
        usuario = null;
        usuarios = new ArrayList<>();
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public String obtenerUsuario() {
        UsuarioDAO dao = new UsuarioDAO();
        usuario = dao.obtenerUsuario(Integer.parseInt(idFiltrado));
        if (usuario == null) {
            addActionError("¡No se ha encontrado ningún usuario!");
            return ERROR;
        }
        sesion.setAttribute("usuario", usuario);
        return SUCCESS;
    }

    public String obtenerUsuarioFiltrado() {
        UsuarioDAO dao = new UsuarioDAO();
        usuario = dao.obtenerUsuario(Integer.parseInt(idFiltrado));
        if (usuario == null) {
            addActionError("¡No se ha encontrado ningún usuario!");
            return ERROR;
        }
        usuarios.clear();
        usuarios.add(usuario);
        sesion.setAttribute("usuarios", usuarios);
        return SUCCESS;
    }

    @Override
    public String execute() throws Exception {
        UsuarioDAO dao = new UsuarioDAO();
        usuarios = dao.obtenerUsuarios();
        if (usuarios == null || usuarios.isEmpty()) {
            addActionError("¡La lista de usuarios está vacía!");
            return ERROR;
        }
        sesion.setAttribute("usuarios", usuarios);
        return SUCCESS;
    }

}
