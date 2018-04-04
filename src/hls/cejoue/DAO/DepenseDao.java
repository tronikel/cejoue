package hls.cejoue.DAO;

import hls.cejoue.dto.RecetteDto;
import hls.cejoue.model.Depense;
import hls.cejoue.dto.DepenseDto;

import java.util.List;

/**
 * Created by hossiel on 22/06/2016.
 */

public interface DepenseDao {

    Depense findById(int Id);
    Depense createDepense(DepenseDto depense);
    DepenseDto deleteDepense(DepenseDto depense);
    Depense updateDepense(DepenseDto depense);
    List<Depense> getAllDepenses();
    List<DepenseDto> get30();


}
