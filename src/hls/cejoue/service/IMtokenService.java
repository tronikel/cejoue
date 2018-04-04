package hls.cejoue.service;




        import hls.cejoue.dto.MtokenDto;
        import hls.cejoue.model.Mtoken;

        import java.util.List;

/**
 * Created by hossiel on 22/06/2016.
 */

public interface IMtokenService {

    Mtoken findByUserName(String username);
    Mtoken findById(String id);
    Mtoken createMtoken(String username,String jsessionid);
    List<Mtoken> getAllMtokens();
    Mtoken update(MtokenDto mtokenDto);
    Mtoken createMtoken(String username);


}