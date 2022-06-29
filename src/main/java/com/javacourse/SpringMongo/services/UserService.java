package com.javacourse.SpringMongo.services;


import com.javacourse.SpringMongo.domain.User;
import com.javacourse.SpringMongo.dto.UserDTO;
import com.javacourse.SpringMongo.repository.UserRepository;
import com.javacourse.SpringMongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(String id){
        User user = userRepository.findById(id).orElse(null);
        if (user == null){
            throw new ObjectNotFoundException("Object not found");
        }
        return user;
    }

    public User insert(User obj){
        return userRepository.insert(obj);
    }

    public User fromDTO(UserDTO objDTO){
        return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
    }
}
