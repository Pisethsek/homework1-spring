package com.example.homework1.Post;

import java.util.List;

public interface PostService {
    List<Post> findAll();
    Post findById(Integer id);
    void addNew(Post post);
    void edit(Integer id, Post post);
    void remove(Integer id);
}
