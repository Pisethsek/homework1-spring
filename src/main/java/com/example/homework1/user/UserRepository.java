package com.example.homework1.user;

import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Getter
public class UserRepository {
    private Faker faker;
    private List<User> users;

    @Autowired
    public void setFaker(Faker faker) {
        this.faker = faker;
    }

    @PostConstruct
    void init(){
        users = new ArrayList<>(){{
           for (int i=1; i<=10; i++){
               add(new User(i, faker.name().username(), faker.lorem().paragraph()));
           }
        }};
    }
}
