package modelo.actions.valoracion;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.text.SimpleDateFormat;
import java.util.Date;
import modelo.Valoracion;
import modelo.dao.ComentarioDAO;
import modelo.dao.UsuarioDAO;
import modelo.dao.ValoracionDAO;

public class actualizarValoracionAction extends ActionSupport {

    private String id;
    private String puntuacion;
    private Valoracion valoracion;

    public actualizarValoracionAction() {
        valoracion = new Valoracion();
        this.clearErrorsAndMessages();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(String puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Valoracion getValoracion() {
        return valoracion;
    }

    public void setValoracion(Valoracion valoracion) {
        this.valoracion = valoracion;
    }

    @Override
    public void validate() {
        // 
    }

    @Override
    public String execute() throws Exception {
        ValoracionDAO dao = new ValoracionDAO();
        valoracion = dao.obtenerValoracion(Integer.parseInt(id));
        if (valoracion == null) {
            addActionError("¡No existe la valoración especificada!");
            return ERROR;
        }
        // Obtener la fecha actual con el formato deseado
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = formato.format(new Date());
        Date fechaActualizada = formato.parse(fecha);
        // Cargar los nuevos atributos de la Valoración
        valoracion.setPuntuacion(Integer.parseInt(puntuacion));
        valoracion.setFechaCreacion(fechaActualizada);
        // ARREGLAR
        valoracion.setComentario(new ComentarioDAO().obtenerComentario(1));
        valoracion.setUsuario(new UsuarioDAO().obtenerUsuario(1));
        // Actualizar un Comentario existente
        dao.actualizarValoracion(valoracion);
        return SUCCESS;
    }

}
