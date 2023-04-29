package com.example.homework1.category;

import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Getter
public class CategoryRepository {

    private Faker faker;

    @Autowired
    public void setFaker(Faker faker) {
        this.faker = faker;
    }

    private List<Category> categories;

    @PostConstruct
    void init(){
        categories = new ArrayList<>(){{
            for (int i=1; i<=10; i++){
                add(new Category(i, faker.country().name()));
            }
        }};
    }

}
