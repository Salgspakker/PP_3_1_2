package com.vadimzhavoronkov.springboot.pp_3_1_2.web.service;

import com.vadimzhavoronkov.springboot.pp_3_1_2.web.model.User;

import java.util.List;

public interface UserService {
    List<User> allUsers();
    void add(User user);
    void delete(User user);
    void edit(User user);
    User getById(int id);
}

