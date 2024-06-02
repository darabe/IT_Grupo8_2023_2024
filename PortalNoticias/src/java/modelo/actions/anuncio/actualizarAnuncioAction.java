package modelo.actions.anuncio;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.HashSet;
import modelo.Anuncio;
import modelo.dao.AnuncianteDAO;
import modelo.dao.AnuncioDAO;

public class actualizarAnuncioAction extends ActionSupport {

    private String id;
    private String titulo;
    private String contenido;
    private String tipo;
    private Anuncio anuncio;

    public actualizarAnuncioAction() {
        anuncio = new Anuncio();
        this.clearErrorsAndMessages();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Anuncio getAnuncio() {
        return anuncio;
    }

    public void setAnuncio(Anuncio anuncio) {
        this.anuncio = anuncio;
    }

    @Override
    public void validate() {
        // 
    }

    @Override
    public String execute() throws Exception {
        AnuncioDAO dao = new AnuncioDAO();
        anuncio = dao.obtenerAnuncio(Integer.parseInt(id));
        if (anuncio == null) {
            addActionError("¡No existe el anuncio especificado!");
            return ERROR;
        }
        // Cargar los nuevos atributos del Anuncio
        anuncio.setTitulo(titulo);
        anuncio.setContenido(contenido);
        anuncio.setTipo(tipo);
        // ARREGLAR
        anuncio.setImagen("");
        anuncio.setAnunciante(new AnuncianteDAO().obtenerAnunciante(1));
        anuncio.setNoticias(new HashSet(0));
        // Actualizar un Anunciante existente
        dao.actualizarAnuncio(anuncio);
        return SUCCESS;
    }

}
