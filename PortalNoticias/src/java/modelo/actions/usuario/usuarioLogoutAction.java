/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.actions.usuario;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;

/**
 *
 * @author Victor
 */
public class usuarioLogoutAction extends ActionSupport {

    public usuarioLogoutAction() {
    }

    public String execute() throws Exception {
        Map<String, Object> session = ActionContext.getContext().getSession();
        session.remove("rol");
        session.remove("usuario");
        session.remove("idUsuario");
        return SUCCESS;
    }

}
