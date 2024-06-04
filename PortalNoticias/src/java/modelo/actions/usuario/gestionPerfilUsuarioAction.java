/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.actions.usuario;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import javax.servlet.http.HttpSession;
import modelo.Comentario;
import modelo.Usuario;
import modelo.Valoracion;
import modelo.dao.ComentarioDAO;
import modelo.dao.UsuarioDAO;
import modelo.dao.ValoracionDAO;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Victor
 */
public class gestionPerfilUsuarioAction extends ActionSupport {
    
    private HttpSession session;
    private Usuario usuario;
    private List<Comentario> listComentarios;
    private List<Valoracion> listValoraciones;
    
    public gestionPerfilUsuarioAction() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    public List<Comentario> getListComentarios() {
        return listComentarios;
    }

    public void setListComentarios(List<Comentario> listComentarios) {
        this.listComentarios = listComentarios;
    }

    public List<Valoracion> getListValoraciones() {
        return listValoraciones;
    }

    public void setListValoraciones(List<Valoracion> listValoraciones) {
        this.listValoraciones = listValoraciones;
    }
    
    
    
    public String execute() throws Exception {
        this.session = ServletActionContext.getRequest().getSession(false);
        UsuarioDAO udao=new UsuarioDAO();
        ComentarioDAO cdao=new ComentarioDAO();
        ValoracionDAO vdao=new ValoracionDAO();
        int idUsuario =(int)session.getAttribute("idUsuario");
        this.usuario=udao.obtenerUsuario(idUsuario);
        this.listComentarios=cdao.obtenerComentariosUsuario(idUsuario);
        this.listValoraciones=vdao.obtenerValoracionesUsuario(idUsuario);
        return SUCCESS;
    }
    
}
