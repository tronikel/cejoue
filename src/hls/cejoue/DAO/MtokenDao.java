package hls.cejoue.DAO;


import hls.cejoue.dto.MtokenDto;
import hls.cejoue.model.Mtoken;

import java.util.List;

/**
 * Created by hossiel on 22/06/2016.
 */

public interface MtokenDao {

    Mtoken findByUserName(String username);
    List <Mtoken> findAllByUserName(String username);
    Mtoken findById(String id);
    Mtoken update(MtokenDto mtokenDto);
    Mtoken createMtoken(String username);
    Mtoken createMtoken(String username,String jsessionid);
    List<Mtoken> getAllMtokens();


}
