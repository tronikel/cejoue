package hls.cejoue.service;

/**
 * Created by hossiel on 22/06/2016.
 */

import hls.cejoue.DAO.MtokenDao;
import hls.cejoue.dto.MtokenDto;
import hls.cejoue.model.Mtoken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("IMtokenService")
public class MyMtokenDetailsService implements IMtokenService {

    //get user from the database, via Hibernate
    @Autowired
    private MtokenDao mtokenDao;


    public Mtoken findByUserName(String username) {

        return mtokenDao.findByUserName(username);
    }
    public Mtoken findById(String id) {

        return mtokenDao.findById(id);
    }

    public Mtoken createMtoken(String username){

        return mtokenDao.createMtoken(username);
    }


    public Mtoken createMtoken(String username,String jsessionid){
        return mtokenDao.createMtoken(username,jsessionid);
    }

    public List <Mtoken> getAllMtokens(){
        return mtokenDao.getAllMtokens();
    }

    public Mtoken update(MtokenDto mtokenDto){
        return mtokenDao.update(mtokenDto);
    }

}