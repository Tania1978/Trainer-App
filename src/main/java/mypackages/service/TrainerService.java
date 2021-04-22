
package mypackages.service;

import java.util.ArrayList;
import java.util.List;
import mypackages.entity.Trainer;
import mypackages.repository.TrainerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
 @Transactional 
public class TrainerService {
    
    @Autowired
    private TrainerRepo trepo;
    
    public List<Trainer> showTrainers(){
      List<Trainer> trainers=  trepo.showTrainers();
      return trainers;
    }
    
    public Trainer createTrainer(Trainer trainer){
        return trepo.addTrainer(trainer);
    }
    
    public Trainer updateTrainer(Trainer trainer){
       return  trepo.updateTrainer(trainer);
    }
    
    public Trainer findById(int id){
        Trainer trainer =trepo.findById(id);
        return trainer;
    }
    
    
    public void delete(int id){
        trepo.delete(id);
    }
    
      public List<String> getSubjects(){
        List<String> subjects = new ArrayList();
        subjects.add("Biology");
        subjects.add("Chemistry");
        subjects.add("Physics");
        subjects.add("Arts");
        subjects.add("Music");
        return subjects;
    }
      
//      public boolean isTrainerAlreadyInDb(Integer vatNumber){
//          boolean isTrainerAlreadyInDb = true;
//          if(trepo.getActiveTrainer(vatNumber)==null){
//              isTrainerAlreadyInDb= false;
//          }
//          return isTrainerAlreadyInDb;
//      }
}
