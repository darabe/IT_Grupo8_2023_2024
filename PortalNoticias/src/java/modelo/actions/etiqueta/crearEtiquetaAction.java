package modelo.actions.etiqueta;

import com.opensymphony.xwork2.ActionSupport;
import java.util.HashSet;
import modelo.Etiqueta;
import modelo.dao.EtiquetaDAO;

public class crearEtiquetaAction extends ActionSupport {

    private String nombre;
    private String descripcion;
    private Etiqueta etiqueta;

    public crearEtiquetaAction() {
        etiqueta = new Etiqueta();
        this.clearErrorsAndMessages();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Etiqueta getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(Etiqueta etiqueta) {
        this.etiqueta = etiqueta;
    }

    @Override
    public void validate() {
        //
    }

    @Override
    public String execute() throws Exception {
        // Cargar los atributos de la Etiqueta
        etiqueta.setNombre(nombre);
        etiqueta.setDescripcion(descripcion);
        // ARREGLAR
        etiqueta.setNoticiaEtiquetas(new HashSet(0));
        // Registrar una nueva Etiqueta
        EtiquetaDAO dao = new EtiquetaDAO();
        dao.registrarEtiqueta(etiqueta);
        return SUCCESS;
    }

}
