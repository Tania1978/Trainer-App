
package mypackages.repository;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;


public class HibernateUtil <E> {
    
    
  @Autowired
  private SessionFactory sessionFactory;
  private Session session;
  
   protected Session getSession() {
        session = sessionFactory.getCurrentSession();//One for each connection to DB
        return session;
    }
   
   protected List<E> findAll(String query){
       session=getSession();
       Query myquery = session.createNamedQuery(query);
       List <E> list = myquery.getResultList();
       return list; 
   }
   
 
    
    protected E create(E e){
        session=getSession();
        session.saveOrUpdate(e);
        return e;
    }
    
    public E update(E e){
        session=getSession();
        session.saveOrUpdate(e);
        return e;
    }
    protected void delete(E e){
        session=getSession();
        session.delete(e);
    }
    
   
    
}
