package com.csf.insta.dao;

import com.csf.insta.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Long> {

    public User findByUsername(String username);


}
