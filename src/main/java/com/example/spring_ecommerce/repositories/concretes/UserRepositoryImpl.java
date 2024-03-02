package com.example.spring_ecommerce.repositories.concretes;

import com.example.spring_ecommerce.entities.User;
import com.example.spring_ecommerce.repositories.abstracts.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private List<User> userList = new ArrayList<>();

    public UserRepositoryImpl(List<User> userList) {

        this.userList = userList;
        userList.add(new User(1,1,1,"John Proctor","john@mail.com"));
        userList.add(new User(2,2,2,"Thomas Hathorne","thomas@mail.com"));
    }

    @Override
    public List<User> getAll() {
        return userList;
    }

    @Override
    public User getByID(int id) {
        for (User user : userList) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void add(User user) {
        userList.add(user);
    }

    @Override
    public void update(int id, User user) {
        int index = 0;
        for (User userToUpdate : userList) {
            if (userToUpdate.getId() == id) {
                index = userList.indexOf(userToUpdate);
            }
        }
        userList.set(index, user);
    }

    @Override
    public void delete(int id) {
        User userToDelete = getByID(id);
        userList.remove(userToDelete);
    }

}
