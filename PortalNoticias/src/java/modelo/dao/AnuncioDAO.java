package modelo.dao;

import java.util.ArrayList;
import modelo.Anuncio;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AnuncioDAO {

    Session sesion = null;

    public List<Anuncio> obtenerAnuncios() {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaccion = sesion.beginTransaction();
        Query consulta = sesion.createQuery("FROM Anuncio");
        List<Anuncio> anuncios = new ArrayList<>();
        anuncios = (ArrayList<Anuncio>) consulta.list();
        transaccion.commit();
        return anuncios;
    }

    public Anuncio obtenerAnuncio(int id_anuncio) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaccion = sesion.beginTransaction();
        Query consulta = sesion.createQuery("FROM Anuncio WHERE id = :id_anuncio");
        consulta.setParameter("id_anuncio", id_anuncio);
        Anuncio anuncio = (Anuncio) consulta.uniqueResult();
        transaccion.commit();
        return anuncio;
    }

    public void registrarAnuncio(Anuncio anuncio) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaccion = sesion.beginTransaction();
        sesion.save(anuncio);
        transaccion.commit();
    }

    public void actualizarAnuncio(Anuncio anuncio) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaccion = sesion.beginTransaction();
        sesion.update(anuncio);
        transaccion.commit();
    }

    public void borrarAnuncio(Anuncio anuncio) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaccion = sesion.beginTransaction();
        sesion.delete(anuncio);
        transaccion.commit();
    }

}
