package com.csf.insta.controllers;

import com.csf.insta.dao.UserDao;
import com.csf.insta.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {


    @Autowired
    private UserDao userDao;

    @RequestMapping("/profile/{username}")
    public User getUser(@PathVariable String username){

        User user = new User();
        user.setFirstName("first");
        user.setLastName("last");
        user.setUsername("name");
        user.setPassword("pass");
        userDao.save(user);
        return userDao.findByUsername(username);
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
