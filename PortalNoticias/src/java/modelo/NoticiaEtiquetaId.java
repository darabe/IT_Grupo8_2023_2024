package modelo;

public class NoticiaEtiquetaId implements java.io.Serializable {

    private int idNoticia;
    private int idEtiqueta;

    public NoticiaEtiquetaId() {
    }

    public NoticiaEtiquetaId(int idNoticia, int idEtiqueta) {
        this.idNoticia = idNoticia;
        this.idEtiqueta = idEtiqueta;
    }

    public int getIdNoticia() {
        return this.idNoticia;
    }

    public void setIdNoticia(int idNoticia) {
        this.idNoticia = idNoticia;
    }

    public int getIdEtiqueta() {
        return this.idEtiqueta;
    }

    public void setIdEtiqueta(int idEtiqueta) {
        this.idEtiqueta = idEtiqueta;
    }

    @Override
    public boolean equals(Object other) {
        if ((this == other)) {
            return true;
        }
        if ((other == null)) {
            return false;
        }
        if (!(other instanceof NoticiaEtiquetaId)) {
            return false;
        }
        NoticiaEtiquetaId castOther = (NoticiaEtiquetaId) other;
        return (this.getIdNoticia() == castOther.getIdNoticia())
                && (this.getIdEtiqueta() == castOther.getIdEtiqueta());
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 37 * result + this.getIdNoticia();
        result = 37 * result + this.getIdEtiqueta();
        return result;
    }

}
