package com.springsecurity.login.demo.service;

import com.springsecurity.login.demo.model.Users;
import com.springsecurity.login.demo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class usersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public boolean createNewUser(Users user){
        boolean isSaved = false;
        user.setPwd(passwordEncoder.encode(user.getPwd()));
        user = usersRepository.save(user);
        if (user.getUserId() > 0){
            isSaved = true;
        }
        return isSaved;
    }
}
