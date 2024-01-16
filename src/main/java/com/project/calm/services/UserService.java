package com.project.calm.services;

import com.project.calm.dto.UserDTO;
import com.project.calm.entities.User;
import com.project.calm.exceptions.EntityAlreadyCreatedException;
import com.project.calm.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){return userRepository.findAll();}

    public User insertUser(User user) throws EntityAlreadyCreatedException{
        if(userRepository.existsByEmailContainingIgnoreCase(user.getEmail())){
            throw new EntityAlreadyCreatedException("L'utilisateur existe déjà en base !", User.class.getName());
        }
        return userRepository.save(user);
    }

    public User updadateUser(UserDTO userDTO, Integer id) throws IllegalArgumentException, NoSuchElementException{
        Optional<User> optionalUser = userRepository.findById(id);
        User user = optionalUser.get();
        user.updateUser(userDTO);
        return userRepository.save(user);
    }

    public Optional<User> deleteUserById(Integer id) throws IllegalArgumentException{
        Optional<User> optionalUser = userRepository.findById(id);
        userRepository.deleteById(id);
        return  optionalUser;
    }
}
