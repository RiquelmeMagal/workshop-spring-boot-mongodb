package com.magalhaesriquelme.workoshopmongo.service;


import com.magalhaesriquelme.workoshopmongo.domain.User;
import com.magalhaesriquelme.workoshopmongo.repository.UserRepository;
import com.magalhaesriquelme.workoshopmongo.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> FindAll() {
        return repo.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
}
