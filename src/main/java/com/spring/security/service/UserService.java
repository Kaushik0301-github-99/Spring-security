package com.spring.security.service;

import com.spring.security.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private List<User> allUser = new ArrayList<>();

    public UserService(){
        allUser.add(new User(1,"niket","niket@email.com"));
        allUser.add(new User(2,"ravi","ravi@email.com"));
        allUser.add(new User(1,"akhilesh","akhilesh@email.com"));
        allUser.add(new User(1,"rahul","rahul@email.com"));
        allUser.add(new User(1,"dharmesh","dharmesh@email.com"));
        allUser.add(new User(1,"rohit","rohit@email.com"));

    }
    public List<User> fetchAllUser(){
        return allUser;
    }


}
