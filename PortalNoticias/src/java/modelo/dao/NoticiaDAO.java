package modelo.dao;

import java.util.ArrayList;
import java.util.List;
import modelo.Noticia;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class NoticiaDAO {

    Session sesion = null;

    public List<Noticia> obtenerNoticias() {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaccion = sesion.beginTransaction();
        Query consulta = sesion.createQuery("FROM Noticia");
        List<Noticia> noticias = new ArrayList<>();
        noticias = (ArrayList<Noticia>) consulta.list();
        transaccion.commit();
        return noticias;
    }

    public Noticia obtenerNoticia(int id_noticia) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaccion = sesion.beginTransaction();
        Query consulta = sesion.createQuery("FROM Noticia WHERE id = :id_noticia");
        consulta.setParameter("id_noticia", id_noticia);
        Noticia noticia = (Noticia) consulta.uniqueResult();
        transaccion.commit();
        return noticia;
    }

    public void registrarNoticia(Noticia noticia) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaccion = sesion.beginTransaction();
        sesion.save(noticia);
        transaccion.commit();
    }

    public void actualizarNoticia(Noticia noticia) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaccion = sesion.beginTransaction();
        sesion.update(noticia);
        transaccion.commit();
    }

    public void borrarNoticia(Noticia noticia) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaccion = sesion.beginTransaction();
        sesion.delete(noticia);
        transaccion.commit();
    }

}
