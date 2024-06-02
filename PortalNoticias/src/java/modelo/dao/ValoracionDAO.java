package modelo.dao;

import java.util.ArrayList;
import java.util.List;
import modelo.Valoracion;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ValoracionDAO {

    Session sesion = null;

    public List<Valoracion> obtenerValoraciones() {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaccion = sesion.beginTransaction();
        Query consulta = sesion.createQuery("FROM Valoracion");
        List<Valoracion> valoraciones = new ArrayList<>();
        valoraciones = (ArrayList<Valoracion>) consulta.list();
        transaccion.commit();
        return valoraciones;
    }

    public Valoracion obtenerValoracion(int id_valoracion) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaccion = sesion.beginTransaction();
        Query consulta = sesion.createQuery("FROM Valoracion WHERE id = :id_valoracion");
        consulta.setParameter("id_valoracion", id_valoracion);
        Valoracion valoracion = (Valoracion) consulta.uniqueResult();
        transaccion.commit();
        return valoracion;
    }

    public void registrarValoracion(Valoracion valoracion) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaccion = sesion.beginTransaction();
        sesion.save(valoracion);
        transaccion.commit();
    }

    public void actualizarValoracion(Valoracion valoracion) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaccion = sesion.beginTransaction();
        sesion.update(valoracion);
        transaccion.commit();
    }

    public void borrarValoracion(Valoracion valoracion) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaccion = sesion.beginTransaction();
        sesion.delete(valoracion);
        transaccion.commit();
    }

}
