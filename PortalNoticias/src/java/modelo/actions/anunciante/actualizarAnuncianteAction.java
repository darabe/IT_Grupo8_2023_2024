package modelo.actions.anunciante;

import com.opensymphony.xwork2.ActionSupport;
import java.util.HashSet;
import modelo.Anunciante;
import modelo.dao.AnuncianteDAO;

public class actualizarAnuncianteAction extends ActionSupport {

    private String id;
    private String nombre;
    private String correo;
    private String telefono;
    private String direccion;
    private String pais;
    private Anunciante anunciante;

    public actualizarAnuncianteAction() {
        anunciante = new Anunciante();
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Anunciante getAnunciante() {
        return anunciante;
    }

    public void setAnunciante(Anunciante anunciante) {
        this.anunciante = anunciante;
    }

    @Override
    public void validate() {
        // 
    }

    @Override
    public String execute() throws Exception {
        AnuncianteDAO dao = new AnuncianteDAO();
        anunciante = dao.obtenerAnunciante(Integer.parseInt(id));
        if (anunciante == null) {
            addActionError("¡No existe el anunciante especificado!");
            return ERROR;
        }
        // Cargar los nuevos atributos del Anunciante
        anunciante.setNombre(nombre);
        anunciante.setCorreo(correo);
        anunciante.setTelefono(telefono);
        anunciante.setDireccion(direccion);
        anunciante.setPais(pais);
        // ARREGLAR:
        anunciante.setAnuncios(new HashSet(0));
        // Actualizar un Anunciante existente
        dao.actualizarAnunciante(anunciante);
        return SUCCESS;
    }

}
