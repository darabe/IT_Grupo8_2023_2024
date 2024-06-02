package modelo.actions.etiqueta;

import com.opensymphony.xwork2.ActionSupport;
import java.util.HashSet;
import java.util.Set;
import modelo.Etiqueta;
import modelo.dao.EtiquetaDAO;

public class actualizarEtiquetaAction extends ActionSupport {
    
    private String id;
    private String nombre;
    private String descripcion;
    private Etiqueta etiqueta;

    public actualizarEtiquetaAction() {
        etiqueta = new Etiqueta();
        this.clearErrorsAndMessages();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
    public void validate(){
        //
    }

    @Override
    public String execute() throws Exception {
        EtiquetaDAO dao = new EtiquetaDAO();
        etiqueta = dao.obtenerEtiqueta(Integer.parseInt(id));
        if(etiqueta == null){
            addActionError("¡No existe la etiqueta especificada!");
            return ERROR;
        }
        // Cargar los nuevos atributos de la Etiqueta
        etiqueta.setNombre(nombre);
        etiqueta.setDescripcion(descripcion);
        etiqueta.setNoticiaEtiquetas(new HashSet(0));
        // Actualizar una Etiqueta existente
        dao.actualizarEtiqueta(etiqueta);
        return SUCCESS;
    }

}
