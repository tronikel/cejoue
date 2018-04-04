package hls.cejoue.service;

/**
 * Created by hossiel on 22/06/2016.
 */



import hls.cejoue.dto.DepenseDto;
import hls.cejoue.DAO.DepenseDao;
import hls.cejoue.model.Depense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("DepenseService")
public class DepenseDetailsService implements DepenseService {

    //get depense from the database, via Hibernate
    @Autowired
    private DepenseDao depenseDao;


    public Depense findById(int id  ) {

        return depenseDao.findById(id);
    }
    public DepenseDto deleteDepense (DepenseDto depense){

        return depenseDao.deleteDepense(depense);
    }
    public Depense createDepense (DepenseDto depense){

        return depenseDao.createDepense(depense);
    }

    public Depense updateDepense (DepenseDto depense) {

        return depenseDao.updateDepense(depense);
    }

    public List<DepenseDto> get30(){
        return depenseDao.get30();
    }


   public List<Depense> getAllDepenses(){
       return depenseDao.getAllDepenses();
   }


}