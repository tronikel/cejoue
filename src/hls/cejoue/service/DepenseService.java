package hls.cejoue.service;


import hls.cejoue.dto.DepenseAndRecetteDto;
import hls.cejoue.dto.DepenseDto;
import hls.cejoue.model.Depense;

import java.util.List;


public interface DepenseService {

    Depense findById(int id);
    Depense createDepense(DepenseDto depense);
    Depense updateDepense(DepenseDto depense);
    DepenseDto deleteDepense(DepenseDto depense);
    List<Depense> getAllDepenses();
    List<DepenseDto> get30();



}
