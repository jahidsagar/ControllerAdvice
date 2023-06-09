package com.example.ControllerAdvice.repo;

import com.example.ControllerAdvice.model.UserModel;

import java.util.List;

public interface UserInterface {
    public List<UserModel> getAll();

    public UserModel store(UserModel userModel);

    public UserModel findById(String id);

    public UserModel edit(String id, String name);

    public UserModel delete(String id);
}
