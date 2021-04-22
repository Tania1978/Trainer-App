
package mypackages.repository;

import java.util.List;
import javax.persistence.NoResultException;
import mypackages.entity.Trainer;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class TrainerRepo extends HibernateUtil<Trainer> {
    
    public List<Trainer> showTrainers(){
        List <Trainer> trainers= super.findAll("Trainer.findAll");
        return trainers;
    }
    
    public Trainer findById(int id){
       Session session=getSession();
       Query myquery = session.createNamedQuery("Trainer.findById");
       myquery.setParameter("id", id);
     Trainer trainer = (Trainer) myquery.getSingleResult();
       return trainer;

    }
    
    public Trainer addTrainer(Trainer trainer){
        return  super.create(trainer);
    }
    
    public Trainer updateTrainer(Trainer trainer){
        return super.update(trainer);
    }
    
  public void delete(int id){
     Trainer trainer = findById(id);
      super.delete(trainer);
  }  
  
//  public Trainer getActiveTrainer(Integer vatNumber){
//      Session session=getSession();
//      Trainer trainer;
//      try{
//       Query myquery = session.createNamedQuery("Trainers.findByVatNumber");
//       myquery.setParameter("vatNumber", vatNumber);
//       trainer = (Trainer) myquery.getSingleResult();
//      }catch (NoResultException e) {
//        trainer= null;
//      }
//       return trainer;
//  }
    
}
