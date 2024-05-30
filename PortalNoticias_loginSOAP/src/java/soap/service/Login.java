package soap.service;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import soap.HibernateUtil;
import soap.Usuario;

@WebService(serviceName = "Login")
public class Login {

    @WebMethod(operationName = "loginUsuario")
    @WebResult(name = "Usuario")
    public Usuario loginUsuario(@WebParam(name = "correo") String correo, @WebParam(name = "contrasenya") String contrasenya) throws LoginException {
        Session sesion = null;
        Usuario cuenta = null;
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            Transaction transaccion = sesion.beginTransaction();
            Query consulta = sesion.createQuery("FROM Usuario WHERE correo = :correo AND contrasenya = :contrasenya");
            consulta.setParameter("correo", correo);
            consulta.setParameter("contrasenya", contrasenya);
            cuenta = (Usuario) consulta.uniqueResult();
            transaccion.commit();
        } catch (HibernateException ex) {
            throw new LoginException("Error durante el inicio de sesión: " + ex.getMessage(), ex);
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }
        return cuenta;
    }
}
