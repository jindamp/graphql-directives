package com.example.graphql.resolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.graphql.models.User;
import com.example.graphql.repo.UserRepo;

@Component
public class UserResolver implements GraphQLQueryResolver {

    @Autowired
    UserRepo userRepo;


    public List<User> users(){
        return userRepo.findAll();
    }

}
