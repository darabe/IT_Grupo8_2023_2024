package modelo.dao;

import java.util.ArrayList;
import modelo.Anunciante;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AnuncianteDAO {

    Session sesion = null;

    public List<Anunciante> obtenerAnunciantes() {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaccion = sesion.beginTransaction();
        Query consulta = sesion.createQuery("FROM Anunciante");
        List<Anunciante> anunciantes = new ArrayList<>();
        anunciantes = (ArrayList<Anunciante>) consulta.list();
        transaccion.commit();
        return anunciantes;
    }

    public Anunciante obtenerAnunciante(int id_anunciante) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaccion = sesion.beginTransaction();
        Query consulta = sesion.createQuery("FROM Anunciante WHERE id = :id_anunciante");
        consulta.setParameter("id_anunciante", id_anunciante);
        Anunciante anunciante = (Anunciante) consulta.uniqueResult();
        transaccion.commit();
        return anunciante;
    }

    public void registrarAnunciante(Anunciante anunciante) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaccion = sesion.beginTransaction();
        sesion.save(anunciante);
        transaccion.commit();
    }

    public void actualizarAnunciante(Anunciante anunciante) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaccion = sesion.beginTransaction();
        sesion.update(anunciante);
        transaccion.commit();
    }

    public void borrarAnunciante(Anunciante anunciante) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaccion = sesion.beginTransaction();
        sesion.delete(anunciante);
        transaccion.commit();
    }

}
