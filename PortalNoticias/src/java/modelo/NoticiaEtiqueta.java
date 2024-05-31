package modelo;

public class NoticiaEtiqueta implements java.io.Serializable {

    private NoticiaEtiquetaId id;
    private Etiqueta etiqueta;
    private Noticia noticia;
    private Integer dummy;

    public NoticiaEtiqueta() {
    }

    public NoticiaEtiqueta(NoticiaEtiquetaId id, Etiqueta etiqueta, Noticia noticia) {
        this.id = id;
        this.etiqueta = etiqueta;
        this.noticia = noticia;
    }

    public NoticiaEtiqueta(NoticiaEtiquetaId id, Etiqueta etiqueta, Noticia noticia, Integer dummy) {
        this.id = id;
        this.etiqueta = etiqueta;
        this.noticia = noticia;
        this.dummy = dummy;
    }

    public NoticiaEtiquetaId getId() {
        return this.id;
    }

    public void setId(NoticiaEtiquetaId id) {
        this.id = id;
    }

    public Etiqueta getEtiqueta() {
        return this.etiqueta;
    }

    public void setEtiqueta(Etiqueta etiqueta) {
        this.etiqueta = etiqueta;
    }

    public Noticia getNoticia() {
        return this.noticia;
    }

    public void setNoticia(Noticia noticia) {
        this.noticia = noticia;
    }

    public Integer getDummy() {
        return this.dummy;
    }

    public void setDummy(Integer dummy) {
        this.dummy = dummy;
    }

}
