package modelo.actions.valoracion;

import com.opensymphony.xwork2.ActionSupport;
import modelo.Valoracion;
import modelo.dao.ValoracionDAO;

public class borrarValoracionAction extends ActionSupport {

    private String id;
    private Valoracion valoracion;

    public borrarValoracionAction() {
        valoracion = new Valoracion();
        this.clearErrorsAndMessages();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Valoracion getValoracion() {
        return valoracion;
    }

    public void setValoracion(Valoracion valoracion) {
        this.valoracion = valoracion;
    }

    @Override
    public String execute() throws Exception {
        ValoracionDAO dao = new ValoracionDAO();
        valoracion = dao.obtenerValoracion(Integer.parseInt(id));
        dao.borrarValoracion(valoracion);
        return SUCCESS;
    }

}
