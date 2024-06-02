package modelo.actions.usuario;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import modelo.Usuario;
import modelo.dao.UsuarioDAO;

public class crearUsuarioAction extends ActionSupport {

    private String nombre;
    private String correo;
    private String contrasenya;
    private String rol;
    private Usuario usuario;

    public crearUsuarioAction() {
        usuario = new Usuario();
        this.clearErrorsAndMessages();
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
        // Obtener la fecha actual con el formato deseado
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = formato.format(new Date());
        Date fechaRegistro = formato.parse(fecha);
        // Cargar los atributos del Usuario
        usuario.setNombre(nombre);
        usuario.setCorreo(correo);
        usuario.setContrasenya(contrasenya);
        usuario.setRol(rol);
        usuario.setFechaRegistro(fechaRegistro);
        // ARREGLAR
        usuario.setComentarios(new HashSet(0));
        usuario.setNoticias(new HashSet(0));
        usuario.setValoracions(new HashSet(0));
        // Registrar un nuevo Usuario
        UsuarioDAO dao = new UsuarioDAO();
        dao.registrarUsuario(usuario);
        return SUCCESS;
    }

}
