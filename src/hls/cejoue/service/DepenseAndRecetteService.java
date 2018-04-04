package hls.cejoue.service;


import hls.cejoue.dto.DepenseAndRecetteDto;
import hls.cejoue.dto.DepenseDto;
import hls.cejoue.model.Depense;

import java.util.List;


public interface DepenseAndRecetteService {


    List<DepenseAndRecetteDto> getAll();
    List<DepenseAndRecetteDto> get60();

}
