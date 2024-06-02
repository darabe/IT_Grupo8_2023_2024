package modelo.actions.anunciante;

import com.opensymphony.xwork2.ActionSupport;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import modelo.Anunciante;
import modelo.dao.AnuncianteDAO;

public class crearAnuncianteAction extends ActionSupport {

    private String nombre;
    private String correo;
    private String telefono;
    private String direccion;
    private String pais;
    private Anunciante anunciante;

    public crearAnuncianteAction() {
        anunciante = new Anunciante();
        this.clearErrorsAndMessages();
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
        // Obtener la fecha actual con el formato deseado
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = formato.format(new Date());
        Date fechaRegistro = formato.parse(fecha);
        // Cargar los atributos del Anunciante
        anunciante.setNombre(nombre);
        anunciante.setCorreo(correo);
        anunciante.setTelefono(telefono);
        anunciante.setDireccion(direccion);
        anunciante.setPais(pais);
        anunciante.setFechaRegistro(fechaRegistro);
        // ARREGLAR
        anunciante.setAnuncios(new HashSet(0));
        // Registrar un nuevo Anunciante
        AnuncianteDAO dao = new AnuncianteDAO();
        dao.registrarAnunciante(anunciante);
        return SUCCESS;
    }

}
