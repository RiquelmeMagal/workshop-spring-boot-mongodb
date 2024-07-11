package com.magalhaesriquelme.workoshopmongo.service;


import com.magalhaesriquelme.workoshopmongo.domain.User;
import com.magalhaesriquelme.workoshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;
    
    public List<User> FindAll(){
        return repo.findAll();
    }
}
