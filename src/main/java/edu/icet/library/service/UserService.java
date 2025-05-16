package edu.icet.library.service;

import edu.icet.library.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    List<User> all();
}
