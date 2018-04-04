package hls.cejoue.service;

/**
 * Created by hossiel on 22/06/2016.
 */


import hls.cejoue.DAO.RecetteDao;
import hls.cejoue.dto.RecetteDto;
import hls.cejoue.model.Recette;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("RecetteService")
public class RecetteDetailsService implements RecetteService {

    //get recette from the database, via Hibernate
    @Autowired
    private RecetteDao recetteDao;


    public Recette findById(int id  ) {

        return recetteDao.findById(id);
    }
    public RecetteDto deleteRecette (RecetteDto recette){

        return recetteDao.deleteRecette(recette);
    }
    public Recette createRecette (RecetteDto recette){

        return recetteDao.createRecette(recette);
    }

    public Recette updateRecette (RecetteDto recette) {

        return recetteDao.updateRecette(recette);
    }

    public List<RecetteDto> get30(){
        return recetteDao.get30();
    }
   public List<Recette> getAllRecettes(){
       return recetteDao.getAllRecettes();
   }


}