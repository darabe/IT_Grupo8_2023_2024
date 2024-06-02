package modelo.actions.noticia;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import modelo.Noticia;
import modelo.dao.AnuncioDAO;
import modelo.dao.CategoriaDAO;
import modelo.dao.NoticiaDAO;
import modelo.dao.UsuarioDAO;

public class actualizarNoticiaAction extends ActionSupport {

    private String id;
    private String autor;
    private String titulo;
    private String contenido;
    private Noticia noticia;

    public actualizarNoticiaAction() {
        noticia = new Noticia();
        this.clearErrorsAndMessages();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public void validate() {
        String expresion="\"^[0-9]+$\"";
        String fId=getId();
         if(getAutor().equals("") || getContenido().equals("") || getTitulo()=="" || getId()==""){
            addFieldError("autor","se requiere autor");
            addFieldError("contenido", "Se requiere contenido");
            addFieldError("titulo", "Se requiere titulo");
            addFieldError("id", "Se requiere id");
        } 
         
          Pattern pattern=Pattern.compile(expresion);
        Matcher mat= pattern.matcher(fId);
        
        if(!mat.matches()){
            addFieldError("id", "El id solo puede ser numerico positivo");
        }
    }

    @Override
    public String execute() throws Exception {
        NoticiaDAO dao = new NoticiaDAO();
        noticia = dao.obtenerNoticia(Integer.parseInt(id));
        if (noticia == null) {
            addActionError("¡No existe la noticia especificada!");
            return ERROR;
        }
        // Cargar los nuevos atributos de la Noticia
        noticia.setAutor(autor);
        noticia.setTitulo(titulo);
        noticia.setContenido(contenido);
        // ARREGLAR
        noticia.setImagen("");
        noticia.setCategoria(new CategoriaDAO().obtenerCategoria(1));
        noticia.setUsuario(new UsuarioDAO().obtenerUsuario(1));
        noticia.setAnuncio(new AnuncioDAO().obtenerAnuncio(1));
        noticia.setComentarios(new HashSet(0));
        noticia.setNoticiaEtiquetas(new HashSet(0));
        // Actualizar una Noticia existente
        dao.actualizarNoticia(noticia);
        return SUCCESS;
    }

}
