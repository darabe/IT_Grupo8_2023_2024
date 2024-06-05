package modelo.actions;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import modelo.Anuncio;
import modelo.Categoria;
import modelo.Noticia;
import modelo.dao.AnuncioDAO;
import modelo.dao.CategoriaDAO;
import modelo.dao.NoticiaDAO;

public class cargaInicialAction extends ActionSupport {

    private String categoriaNombre;
    private List<Noticia> noticias;
    private List<Categoria> categorias;
    private List<Anuncio> anuncios;

    public cargaInicialAction() {
        noticias = new ArrayList<>();
        categorias = new ArrayList<>();
        anuncios = new ArrayList<>();
    }

    public String getCategoriaNombre() {
        return categoriaNombre;
    }

    public void setCategoriaNombre(String categoriaNombre) {
        this.categoriaNombre = categoriaNombre;
    }

    public List<Noticia> getNoticias() {
        return noticias;
    }

    public void setNoticias(List<Noticia> noticias) {
        this.noticias = noticias;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public List<Anuncio> getAnuncios() {
        return anuncios;
    }

    public void setAnuncios(List<Anuncio> anuncios) {
        this.anuncios = anuncios;
    }

    @Override
    public String execute() throws Exception {
        NoticiaDAO daoN = new NoticiaDAO();
        CategoriaDAO daoC = new CategoriaDAO();
        AnuncioDAO daoA = new AnuncioDAO();
        noticias = daoN.obtenerNoticias();
        categorias = daoC.obtenerCategorias();
        anuncios = daoA.obtenerAnuncios();
        if (!anuncios.isEmpty()) {
            Collections.shuffle(anuncios);
            anuncios = anuncios.subList(0, Math.min(anuncios.size(), 2));
        }
        if (categoriaNombre != null) {
            String categoriaNombreCodificado = URLEncoder.encode(categoriaNombre, "UTF-8");
            noticias = daoN.obtenerNoticiaPorCategoria(
                    daoC.obtenerCategoriaPorNombre(
                            categoriaNombreCodificado
                    ).getIdCategoria()
            );
        }
        return SUCCESS;
    }

}
