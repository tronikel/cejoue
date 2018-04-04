package hls.cejoue.service;

/**
 * Created by hossiel on 22/06/2016.
 */


import hls.cejoue.model.User;
import hls.cejoue.dto.NewUserDto;

import hls.cejoue.DAO.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("IUserService")
public class MyUserDetailsService implements IUserService {

    //get user from the database, via Hibernate
    @Autowired
    private UserDao userDao;


    public User findByUserName(String username) { return userDao.findByUserName(username); }

    public NewUserDto deleteUser (NewUserDto user){ return userDao.deleteUser(user); }

    public User createUser (NewUserDto user){ return userDao.createUser(user); }

    public User updateUser (NewUserDto user) { return userDao.updateUser(user); }


    public User UpdatePassword(NewUserDto user){ return userDao.updatePassword(user); }


    public List<User> getAllUsers(){
       return userDao.getAllUsers();
   }

  public   boolean checkUser(String username, String password){
      return userDao.checkUser( username,  password);
  }


}