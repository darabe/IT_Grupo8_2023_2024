/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import modelo.HibernateUtil;
import modelo.Usuario;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author josem
 */
@WebService(serviceName = "DAO")
public class DAO {

    /**
     * This is a sample web service operation
     * @param nombre
     * @param contrasenya
     * @return 
     */
    @WebMethod(operationName = "consultaUsuario")
    @WebResult(name="Usuario")
    public Usuario consultaUsuario(@WebParam(name = "nombre") String nombre, @WebParam(name="contrasenya") String contrasenya) {
       Usuario usu=null;
       
       try{
           Session s1= HibernateUtil.getSessionFactory().getCurrentSession();
           Transaction tx=s1.beginTransaction();
           Query q=s1.createQuery("From Usuario WHERE nombre='"+ nombre + "' and contrasenya='" + contrasenya +"'" );
           usu=(Usuario) q.uniqueResult();
           tx.commit();
       }catch(HibernateException e){
           
       }
        
        return usu;
    }
}
