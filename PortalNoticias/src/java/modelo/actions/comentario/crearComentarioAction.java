package modelo.actions.comentario;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import modelo.Comentario;
import modelo.dao.ComentarioDAO;
import modelo.dao.NoticiaDAO;
import modelo.dao.UsuarioDAO;

public class crearComentarioAction extends ActionSupport {

    private String contenido;
    private Comentario comentario;

    public crearComentarioAction() {
        comentario = new Comentario();
        this.clearErrorsAndMessages();
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Comentario getComentario() {
        return comentario;
    }

    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
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
        // Cargar los atributos del Comentario
        comentario.setContenido(contenido);
        comentario.setFechaCreacion(fechaRegistro);
        // ARREGLAR
        comentario.setNoticia(new NoticiaDAO().obtenerNoticia(1));
        comentario.setUsuario(new UsuarioDAO().obtenerUsuario(1));
        comentario.setValoracions(new HashSet(0));
        // Registrar un nuevo Comentario
        ComentarioDAO dao = new ComentarioDAO();
        dao.registrarComentario(comentario);
        return SUCCESS;
    }

}
