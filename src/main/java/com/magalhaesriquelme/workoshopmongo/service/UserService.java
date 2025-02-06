package com.magalhaesriquelme.workoshopmongo.service;


import com.magalhaesriquelme.workoshopmongo.domain.User;
import com.magalhaesriquelme.workoshopmongo.dto.UserDTO;
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

    public User insert(User obj) {
        return repo.insert(obj);
    }

    public void delete(String id) {
        findById(id);
        repo.deleteById(id);
    }

    public User update(User obj) {
        User newObj = repo.findById(obj.getId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        updateData(newObj, obj);
        return repo.save(newObj);
    }

    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

    public User fromDTO(UserDTO objdto) {
        return new User(objdto.getId(), objdto.getName(), objdto.getEmail());
    }
}
