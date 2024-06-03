package modelo.dao;

import java.util.ArrayList;
import java.util.List;
import modelo.Comentario;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ComentarioDAO {

    Session sesion = null;

    public List<Comentario> obtenerComentarios() {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaccion = sesion.beginTransaction();
        Query consulta = sesion.createQuery("FROM Comentario");
        List<Comentario> comentarios = new ArrayList<>();
        comentarios = (ArrayList<Comentario>) consulta.list();
        transaccion.commit();
        return comentarios;
    }

    public Comentario obtenerComentario(int id_comentario) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaccion = sesion.beginTransaction();
        Query consulta = sesion.createQuery("FROM Comentario WHERE id = :id_comentario");
        consulta.setParameter("id_comentario", id_comentario);
        Comentario comentario = (Comentario) consulta.uniqueResult();
        transaccion.commit();
        return comentario;
    }
    
    public List<Comentario> obtenerComentariosUsuario(int id_usuario) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaccion = sesion.beginTransaction();
        Query consulta = sesion.createQuery("FROM Comentario WHERE id_usuario = '"+id_usuario+"'");
        List<Comentario> comentarios = new ArrayList<>();
        comentarios = (ArrayList<Comentario>) consulta.list();
        transaccion.commit();
        return comentarios;
    }

    public void registrarComentario(Comentario comentario) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaccion = sesion.beginTransaction();
        sesion.save(comentario);
        transaccion.commit();
    }

    public void actualizarComentario(Comentario comentario) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaccion = sesion.beginTransaction();
        sesion.update(comentario);
        transaccion.commit();
    }

    public void borrarComentario(Comentario comentario) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaccion = sesion.beginTransaction();
        sesion.delete(comentario);
        transaccion.commit();
    }

}
