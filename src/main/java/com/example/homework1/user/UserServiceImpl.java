package com.example.homework1.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    @Override
    public List<User> findAll() {
        return userRepository.getUsers();
    }

    @Override
    public User findById(Integer id) {
        return userRepository.getUsers().stream().filter(u -> Objects.equals(u.getId(), id)).findFirst().orElse(null);
    }

    @Override
    public void addNew(User user) {
        userRepository.getUsers().add(0, user);
    }

    @Override
    public void edit(Integer id, User user) {
        User u = findById(id);
        int index = userRepository.getUsers().indexOf(u);
        userRepository.getUsers().set(index, user);
    }

    @Override
    public void remove(Integer id) {
        User u = findById(id);
        userRepository.getUsers().remove(u);
    }

}
