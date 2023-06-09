package com.example.ControllerAdvice.service;

import com.example.ControllerAdvice.error.NoUserFoundException;
import com.example.ControllerAdvice.model.UserModel;
import com.example.ControllerAdvice.repo.UserInterface;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService implements UserInterface {
    private List<UserModel> userModels = new ArrayList<>();

    @Override
    public List<UserModel> getAll() {
        return userModels;
    }

    @Override
    public UserModel store(UserModel userModel) {
        if(userModel.getId() == null) userModel.setId(UUID.randomUUID().toString());
        userModels.add(userModel);
        return  userModel;
    }

    @Override
    public UserModel findById(String id) {
        return userModels
                .stream()
                .filter(userModel -> userModel.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElseThrow(() -> new NoUserFoundException("No user found"));
    }

    @Override
    public UserModel edit(String id, String name) {
        UserModel userModel = userModels
                .stream()
                .filter(userModel1 -> userModel1.getId().equalsIgnoreCase(id))
                .findFirst()
                .get();
        userModels.remove(userModel);
        userModel.setName(name);
        userModels.add(userModel);
        return  userModel;
    }

    @Override
    public UserModel delete(String id) {
        UserModel user = userModels
                .stream()
                .filter(userModel -> userModel.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElseThrow(() -> new NoUserFoundException("No user found"));
        userModels.remove(user);
        return user;
    }
}
