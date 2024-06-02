package modelo.dao;

import java.util.ArrayList;
import java.util.List;
import modelo.Etiqueta;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EtiquetaDAO {

    Session sesion = null;

    public List<Etiqueta> obtenerEtiquetas() {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaccion = sesion.beginTransaction();
        Query consulta = sesion.createQuery("FROM Etiqueta");
        List<Etiqueta> etiquetas = new ArrayList<>();
        etiquetas = (ArrayList<Etiqueta>) consulta.list();
        transaccion.commit();
        return etiquetas;
    }

    public Etiqueta obtenerEtiqueta(int id_etiqueta) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaccion = sesion.beginTransaction();
        Query consulta = sesion.createQuery("FROM Etiqueta WHERE id = :id_etiqueta");
        consulta.setParameter("id_etiqueta", id_etiqueta);
        Etiqueta etiqueta = (Etiqueta) consulta.uniqueResult();
        transaccion.commit();
        return etiqueta;
    }

    public void registrarEtiqueta(Etiqueta etiqueta) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaccion = sesion.beginTransaction();
        sesion.save(etiqueta);
        transaccion.commit();
    }

    public void actualizarEtiqueta(Etiqueta etiqueta) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaccion = sesion.beginTransaction();
        sesion.update(etiqueta);
        transaccion.commit();
    }

    public void borrarEtiqueta(Etiqueta etiqueta) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaccion = sesion.beginTransaction();
        sesion.delete(etiqueta);
        transaccion.commit();
    }
    
}
