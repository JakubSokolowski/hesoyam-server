package com.hesoyam.server.service;

import com.hesoyam.server.models.User;
import com.hesoyam.server.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User findByUsername(String username){
        return userRepository.findUserByUsername(username);
    }

    public boolean save(User user){
        if(findByUsername(user.getUsername()) == null){
            userRepository.save(user);
            return true;
        }
        return false;
    }
}