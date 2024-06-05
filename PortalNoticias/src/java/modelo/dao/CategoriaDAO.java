package modelo.dao;

import java.util.ArrayList;
import java.util.List;
import modelo.Categoria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CategoriaDAO {

    Session sesion = null;

    public List<Categoria> obtenerCategorias() {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaccion = sesion.beginTransaction();
        Query consulta = sesion.createQuery("FROM Categoria");
        List<Categoria> categorias = new ArrayList<>();
        categorias = (ArrayList<Categoria>) consulta.list();
        transaccion.commit();
        return categorias;
    }

    public Categoria obtenerCategoria(int id_categoria) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaccion = sesion.beginTransaction();
        Query consulta = sesion.createQuery("FROM Categoria WHERE id = :id_categoria");
        consulta.setParameter("id_categoria", id_categoria);
        Categoria categoria = (Categoria) consulta.uniqueResult();
        transaccion.commit();
        return categoria;
    }

    public Categoria obtenerCategoriaPorNombre(String nombre) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaccion = sesion.beginTransaction();
        Query consulta = sesion.createQuery("FROM Categoria WHERE nombre = :nombre");
        consulta.setParameter("nombre", nombre);
        Categoria categoria = (Categoria) consulta.uniqueResult();
        transaccion.commit();
        return categoria;
    }

    public void registrarCategoria(Categoria categoria) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaccion = sesion.beginTransaction();
        sesion.save(categoria);
        transaccion.commit();
    }

    public void actualizarCategoria(Categoria categoria) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaccion = sesion.beginTransaction();
        sesion.update(categoria);
        transaccion.commit();
    }

    public void borrarCategoria(Categoria categoria) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaccion = sesion.beginTransaction();
        sesion.delete(categoria);
        transaccion.commit();
    }

}
