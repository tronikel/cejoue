package hls.cejoue.service;


import hls.cejoue.dto.RecetteDto;
import hls.cejoue.model.Recette;

import java.util.List;


public interface RecetteService {

    Recette findById(int id);
    Recette createRecette(RecetteDto recette);
    Recette updateRecette(RecetteDto recette);
    RecetteDto deleteRecette(RecetteDto recette);
    List<Recette> getAllRecettes();
    List<RecetteDto> get30();
}
