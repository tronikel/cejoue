package hls.cejoue.service;

/**
 * Created by hossiel on 22/06/2016.
 */


import hls.cejoue.DAO.DepenseDao;
import hls.cejoue.DAO.RecetteDao;
import hls.cejoue.dto.DepenseAndRecetteDto;
import hls.cejoue.dto.DepenseDto;
import hls.cejoue.dto.RecetteDto;
import hls.cejoue.model.Depense;
import hls.cejoue.model.Recette;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;


@Service("DepenseAndRecetteService")
public class DepenseAndRecetteDetailsService implements DepenseAndRecetteService {

    //get depense from the database, via Hibernate
    @Autowired
    private DepenseDao depenseDao;
    @Autowired
    private RecetteDao recetteDao;



    public  List<DepenseAndRecetteDto> get60() {
        List<DepenseAndRecetteDto> depenseAndRecetteDtos = null;
        List<DepenseDto> depenseDtos = depenseDao.get30();
        List<RecetteDto> recetteDtos = recetteDao.get30();
        int i,j;
        if ((depenseDtos != null)||(recetteDtos != null)) {
            depenseAndRecetteDtos = new ArrayList<DepenseAndRecetteDto>();
            if (depenseDtos != null) {

                for (i = 0; i < depenseDtos.size(); i++) {
                    depenseAndRecetteDtos.add(new DepenseAndRecetteDto(depenseDtos.get(i)));
                }
            }
            if (recetteDtos != null) {
                for (j = 0; j < recetteDtos.size(); j++) {
                    depenseAndRecetteDtos.add(new DepenseAndRecetteDto(recetteDtos.get(j)));
                }
            }
        }
        tri_insertion(depenseAndRecetteDtos);
        return depenseAndRecetteDtos;
    }

    public  List<DepenseAndRecetteDto> getAll(){

        List<DepenseAndRecetteDto> depenseAndRecetteDtos = null;
        List<Depense> depenses = depenseDao.getAllDepenses();
        List<Recette> recettes = recetteDao.getAllRecettes();
        int i,j;
        if ((depenses != null)||(recettes != null)) {
            depenseAndRecetteDtos = new ArrayList<DepenseAndRecetteDto>();
            if (depenses != null) {

                for (i = 0; i < depenses.size(); i++) {
                    depenseAndRecetteDtos.add(new DepenseAndRecetteDto(new DepenseDto(depenses.get(i))));
                }
            }
            if (recettes != null) {
                for (j = 0; j < recettes.size(); j++) {
                    depenseAndRecetteDtos.add(new DepenseAndRecetteDto(new RecetteDto(recettes.get(j))));
                }
            }
        }

        tri_insertion(depenseAndRecetteDtos);
        return depenseAndRecetteDtos;

    }




    static public void tri_insertion(List<DepenseAndRecetteDto> list)    {

        int i, j;

        for (i = 1; i < list.size(); ++i) {

            DepenseAndRecetteDto elem = list.get(i);

            for (j = i; j > 0 && list.get(j-1).getDateSoumission().before(elem.getDateSoumission()); j--)

                list.set(j, list.get(j-1));

            list.set(j, elem);
        }

    }





}