package hls.cejoue.DAO;

import hls.cejoue.dto.RecetteDto;
import hls.cejoue.model.Recette;


import java.util.List;

/**
 * Created by hossiel on 22/06/2016.
 */

public interface RecetteDao {

    Recette findById(int Id);
    Recette createRecette(RecetteDto depense);
    RecetteDto deleteRecette(RecetteDto depense);
    Recette updateRecette(RecetteDto depense);
    List<Recette> getAllRecettes();
    List<RecetteDto> get30();

}
