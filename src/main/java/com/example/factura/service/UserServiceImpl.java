package com.example.factura.service;

import com.example.factura.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public boolean login(User user) {

        String userName = "hvaldivia";
        String password = "123456";

        if(user.getUsername().equals(userName) && user.getPassword().equals(password))
            return true;

        return false;
    }
}
