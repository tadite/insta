package com.csf.insta.services;

import com.csf.insta.dao.ImageDao;
import com.csf.insta.dao.UserDao;
import com.csf.insta.dto.ProfileDto;
import com.csf.insta.entities.Image;
import com.csf.insta.entities.User;
import com.csf.insta.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserService {

    private UserDao userDao;


    private UserMapper userMapper = new UserMapper();

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;

    }

    public ProfileDto getProfile(String username){

        User user = userDao.findByUsername(username);
       return userMapper.userToProfileDto(user);
    }

    public void updateProile(User user,String fullname,String info){
        User currentUser = userDao.findByUsername(user.getUsername());
        String [] splitedName = fullname.split(" ");
        currentUser.setFirstName(splitedName[0]);
        currentUser.setLastName(splitedName[1]);
        currentUser.setInfo(info);
        userDao.save(currentUser);
    }
}
