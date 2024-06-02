package modelo.dao;

import java.util.ArrayList;
import java.util.List;
import modelo.Usuario;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UsuarioDAO {

    Session sesion = null;

    public List<Usuario> obtenerUsuarios() {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaccion = sesion.beginTransaction();
        Query consulta = sesion.createQuery("FROM Usuario");
        List<Usuario> usuarios = new ArrayList<>();
        usuarios = (ArrayList<Usuario>) consulta.list();
        transaccion.commit();
        return usuarios;
    }

    public Usuario obtenerUsuario(int id_usuario) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaccion = sesion.beginTransaction();
        Query consulta = sesion.createQuery("FROM Usuario WHERE id = :id_usuario");
        consulta.setParameter("id_usuario", id_usuario);
        Usuario usuario = (Usuario) consulta.uniqueResult();
        transaccion.commit();
        return usuario;
    }

    public void registrarUsuario(Usuario usuario) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaccion = sesion.beginTransaction();
        sesion.save(usuario);
        transaccion.commit();
    }

    public void actualizarUsuario(Usuario usuario) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaccion = sesion.beginTransaction();
        sesion.update(usuario);
        transaccion.commit();
    }

    public void borrarUsuario(Usuario usuario) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaccion = sesion.beginTransaction();
        sesion.delete(usuario);
        transaccion.commit();
    }

}
