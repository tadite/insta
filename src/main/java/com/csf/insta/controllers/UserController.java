package com.csf.insta.controllers;

import com.csf.insta.dao.UserDao;
import com.csf.insta.dto.ProfileDto;
import com.csf.insta.entities.User;
import com.csf.insta.security.CurrentUser;
import com.csf.insta.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {


    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/profile/{username}")
    public ProfileDto getProfile(@PathVariable String username){
        return userService.getProfile(username);
    }

    @RequestMapping(value="/profile",
            method = RequestMethod.PUT)
    public  void updateProfile(@CurrentUser User user,String fullname, String info){
        userService.updateProile(user,fullname,info);
    }


}
