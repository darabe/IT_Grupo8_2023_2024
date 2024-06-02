package modelo.actions.comentario;

import com.opensymphony.xwork2.ActionSupport;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import modelo.Comentario;
import modelo.dao.ComentarioDAO;
import modelo.dao.NoticiaDAO;
import modelo.dao.UsuarioDAO;

public class actualizarComentarioAction extends ActionSupport {

    private String id;
    private String contenido;
    private Comentario comentario;

    public actualizarComentarioAction() {
        comentario = new Comentario();
        this.clearErrorsAndMessages();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        ComentarioDAO dao = new ComentarioDAO();
        comentario = dao.obtenerComentario(Integer.parseInt(id));
        if (comentario == null) {
            addActionError("¡No existe el comentario especificado!");
            return ERROR;
        }
        // Obtener la fecha actual con el formato deseado
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = formato.format(new Date());
        Date fechaActualizada = formato.parse(fecha);
        // Cargar los nuevos atributos del Comentario
        comentario.setContenido(contenido);
        comentario.setFechaCreacion(fechaActualizada);
        // ARREGLAR
        comentario.setNoticia(new NoticiaDAO().obtenerNoticia(1));
        comentario.setUsuario(new UsuarioDAO().obtenerUsuario(1));
        comentario.setValoracions(new HashSet(0));
        // Actualizar un Comentario existente
        dao.actualizarComentario(comentario);
        return SUCCESS;
    }

}
