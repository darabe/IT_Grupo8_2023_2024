package modelo.actions.valoracion;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.text.SimpleDateFormat;
import java.util.Date;
import modelo.Valoracion;
import modelo.dao.ComentarioDAO;
import modelo.dao.UsuarioDAO;
import modelo.dao.ValoracionDAO;

public class crearValoracionAction extends ActionSupport {

    private String puntuacion;
    private Valoracion valoracion;

    public crearValoracionAction() {
        valoracion = new Valoracion();
        this.clearErrorsAndMessages();
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
        // Obtener la fecha actual con el formato deseado
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = formato.format(new Date());
        Date fechaRegistro = formato.parse(fecha);
        // Cargar los atributos de la Valoración
        valoracion.setPuntuacion(Integer.parseInt(puntuacion));
        valoracion.setFechaCreacion(fechaRegistro);
        // ARREGLAR
        valoracion.setComentario(new ComentarioDAO().obtenerComentario(1));
        valoracion.setUsuario(new UsuarioDAO().obtenerUsuario(1));
        // Registrar una nueva Valoración
        ValoracionDAO dao = new ValoracionDAO();
        dao.registrarValoracion(valoracion);
        return SUCCESS;
    }

}
