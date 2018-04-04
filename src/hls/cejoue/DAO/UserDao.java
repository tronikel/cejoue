package hls.cejoue.DAO;

import hls.cejoue.dto.NewUserDto;
import hls.cejoue.model.User;


import java.util.List;


/**
 * Created by hossiel on 22/06/2016.
 */

public interface UserDao {

    User findByUserName(String username);
    User createUser(NewUserDto user);
    User updateUser (NewUserDto user);
    NewUserDto deleteUser (NewUserDto User);
    User updatePassword(NewUserDto user);
    List<User> getAllUsers();
    boolean checkUser(String username, String password);


}
