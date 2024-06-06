package modelo.actions.noticia;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpSession;
import modelo.Noticia;
import modelo.dao.AnuncioDAO;
import modelo.dao.CategoriaDAO;
import modelo.dao.NoticiaDAO;
import modelo.dao.UsuarioDAO;
import org.apache.struts2.ServletActionContext;

public class crearNoticiaAction extends ActionSupport {

    private String autor;
    private String titulo;
    private String contenido;
    private Noticia noticia;
    
    private String idCategoria;
    private HttpSession sesion;
    private String idAnuncio;

    public crearNoticiaAction() {
        noticia = new Noticia();
        this.clearErrorsAndMessages();
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
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

    public Noticia getNoticia() {
        return noticia;
    }

    public void setNoticia(Noticia noticia) {
        this.noticia = noticia;
    }

    public String getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(String idCategoria) {
        this.idCategoria = idCategoria;
    }

    public HttpSession getSesion() {
        return sesion;
    }

    public void setSesion(HttpSession sesion) {
        this.sesion = sesion;
    }

    public String getIdAnuncio() {
        return idAnuncio;
    }

    public void setIdAnuncio(String idAnuncio) {
        this.idAnuncio = idAnuncio;
    }
    
    

    @Override
    public void validate() {
        if (getAutor().equals("") || getContenido().equals("") || "".equals(getTitulo())) {
            addFieldError("autor", "Se requiere autor");
            addFieldError("contenido", "Se requiere contenido");
            addFieldError("titulo", "Se requiere titulo");
        }
    }

    @Override
    public String execute() throws Exception {
        
        this.sesion = ServletActionContext.getRequest().getSession(false);
        int idUser = (int) this.sesion.getAttribute("idUsuario");
        // Obtener la fecha actual con el formato deseado
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = formato.format(new Date());
        Date fechaRegistro = formato.parse(fecha);
        // Cargar los atributos de la Noticia
        noticia.setAutor(autor);
        noticia.setTitulo(titulo);
        noticia.setContenido(contenido);
        noticia.setFechaCreacion(fechaRegistro);
        // ARREGLAR
        noticia.setImagen("");
        noticia.setCategoria(new CategoriaDAO().obtenerCategoria(Integer.parseInt(this.idCategoria)));
        noticia.setUsuario(new UsuarioDAO().obtenerUsuario(idUser));
        noticia.setAnuncio(new AnuncioDAO().obtenerAnuncio(Integer.parseInt(this.idAnuncio)));
        noticia.setComentarios(new HashSet(0));
        noticia.setNoticiaEtiquetas(new HashSet(0));
        // Registrar una nueva Noticia
        NoticiaDAO dao = new NoticiaDAO();
        dao.registrarNoticia(noticia);
        return SUCCESS;
    }

}
