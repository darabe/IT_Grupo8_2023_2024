package modelo.actions.usuario;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.HashSet;
import modelo.Usuario;
import modelo.dao.UsuarioDAO;

public class actualizarUsuarioAction extends ActionSupport {

    private String id;
    private String nombre;
    private String correo;
    private String contrasenya;
    private String rol;
    private Usuario usuario;

    public actualizarUsuarioAction() {
        usuario = new Usuario();
        this.clearErrorsAndMessages();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public void validate() {
        // 
    }

    @Override
    public String execute() throws Exception {
        UsuarioDAO dao = new UsuarioDAO();
        usuario = dao.obtenerUsuario(Integer.parseInt(id));
        if (usuario == null) {
            addActionError("¡No existe el usuario especificado!");
            return ERROR;
        }
        // Cargar los nuevos atributos del Usuario
        usuario.setNombre(nombre);
        usuario.setCorreo(correo);
        usuario.setContrasenya(contrasenya);
        usuario.setRol(rol);
        // ARREGLAR
        usuario.setComentarios(new HashSet(0));
        usuario.setNoticias(new HashSet(0));
        usuario.setValoracions(new HashSet(0));
        // Actualizar un Comentario existente
        dao.actualizarUsuario(usuario);
        return SUCCESS;
    }

}
