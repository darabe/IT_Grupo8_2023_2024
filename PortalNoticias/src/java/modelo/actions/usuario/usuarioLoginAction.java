package modelo.actions.usuario;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import modelo.services.Usuario;
import modelo.services.LoginException_Exception;

public class usuarioLoginAction extends ActionSupport {

    private String correo;
    private String contrasenya;

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    @Override
    public String execute() throws Exception {
        try {
            Usuario resultado = loginUsuario(correo, contrasenya);
            if (resultado != null) {
                ActionContext ctx = ActionContext.getContext();
                ctx.getSession().put("usuario", resultado.getNombre());
                return SUCCESS;
            } else {
                addActionError("¡Correo electrónico o contraseña incorrecta!");
                return ERROR;
            }
        } catch (LoginException_Exception ex) {
            addActionError("Error de autenticación: " + ex.getMessage());
            return ERROR;
        }
    }

    private static Usuario loginUsuario(java.lang.String correo, java.lang.String contrasenya) throws LoginException_Exception {
        modelo.services.Login_Service service = new modelo.services.Login_Service();
        modelo.services.Login port = service.getLoginPort();
        return port.loginUsuario(correo, contrasenya);
    }

}
