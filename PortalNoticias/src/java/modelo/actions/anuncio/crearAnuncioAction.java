package modelo.actions.anuncio;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import modelo.Anunciante;
import modelo.Anuncio;
import modelo.dao.AnuncianteDAO;
import modelo.dao.AnuncioDAO;

public class crearAnuncioAction extends ActionSupport {

    private String titulo;
    private String contenido;
    private String tipo;
    private Anuncio anuncio;
    
    private String idAnunciante;

    public crearAnuncioAction() {
        anuncio = new Anuncio();
        this.clearErrorsAndMessages();
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

    public String getIdAnunciante() {
        return idAnunciante;
    }

    public void setIdAnunciante(String idAnunciante) {
        this.idAnunciante = idAnunciante;
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
        // Cargar los atributos del Anuncio
        anuncio.setTitulo(titulo);
        anuncio.setContenido(contenido);
        anuncio.setTipo(tipo);
        anuncio.setFechaCreacion(fechaRegistro);
        // ARREGLAR
        anuncio.setImagen("");
        anuncio.setAnunciante(new AnuncianteDAO().obtenerAnunciante(Integer.parseInt(this.idAnunciante)));
        anuncio.setNoticias(new HashSet(0));
        // Registrar un nuevo Anuncio
        AnuncioDAO dao = new AnuncioDAO();
        dao.registrarAnuncio(anuncio);
        return SUCCESS;
    }

}
