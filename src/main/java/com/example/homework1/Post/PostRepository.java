package com.example.homework1.Post;

import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Getter
public class PostRepository {

    private Faker faker;

    private List<Post> posts;

    @Autowired
    public void setFaker(Faker faker) {
        this.faker = faker;
    }

    @PostConstruct
    void init(){
        posts = new ArrayList<>(){{
            for (int i=1; i<=10; i++){
                add(new Post(i, faker.animal().name(), faker.lorem().paragraph(), null, null, faker.avatar().image()));
            }
        }};
    }

}
