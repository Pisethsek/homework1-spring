package com.example.homework1.Post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;

    @Override
    public List<Post> findAll() {
        return postRepository.getPosts();
    }

    @Override
    public Post findById(Integer id) {
        return postRepository.getPosts().stream().filter(p -> Objects.equals(p.getId(), id)).findFirst().orElse(null);
    }

    @Override
    public void addNew(Post post) {
        postRepository.getPosts().add(0, post);
    }

    @Override
    public void edit(Integer id, Post post) {
        Post p = findById(id);
        int index = postRepository.getPosts().indexOf(p);
        postRepository.getPosts().set(index, post);
    }

    @Override
    public void remove(Integer id) {
        Post p = findById(id);
        postRepository.getPosts().remove(p);
    }
}
