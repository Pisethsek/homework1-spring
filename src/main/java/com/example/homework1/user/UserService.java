package com.example.homework1.user;


import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Integer id);
    void addNew(User user);
    void edit(Integer id, User user);
    void remove(Integer id);
}
