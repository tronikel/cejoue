package hls.cejoue.service;


import hls.cejoue.model.User;
import hls.cejoue.dto.NewUserDto;

import java.util.List;


public interface IUserService {

    User findByUserName(String username);
    User createUser(NewUserDto user);
    User updateUser (NewUserDto User);
    User UpdatePassword(NewUserDto user);
    NewUserDto deleteUser(NewUserDto user);
    boolean checkUser(String username, String password);
    List<User> getAllUsers();

}
