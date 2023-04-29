package com.example.homework1.Post;

import com.example.homework1.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    @GetMapping("")
    String requestPostsView(Model model){
        model.addAttribute("posts", postService.findAll());
        return "pages/post/posts";
    }

    @GetMapping("/{id}")
    String requestPostView(@PathVariable("id") Integer id, Model model){
        model.addAttribute("user", postService.findById(id));
        return "pages/post/post";
    }

    @GetMapping("/add")
    String requestFormAddView(Model model){
        model.addAttribute("post", new Post());
        return "pages/post/forms";
    }

    @PostMapping("/add")
    String doAddView(Post post){
        int min = 11;
        int max = 400;
        int id = (int)(Math.random()*(max-min+1)+min);
        post.setId(id);
        postService.addNew(post);
        return "redirect:/user";
    }

    @GetMapping("/edit/{id}")
    String requestFormEditView(@PathVariable("id") Integer id, Model model){
        model.addAttribute("user", postService.findById(id));
        model.addAttribute("isEdit", true);
        return "pages/post/forms";
    }

    @PostMapping("/edit/{id}")
    String doEditView(@PathVariable("id") Integer id, Post post){
        postService.edit(id, post);
        return "redirect:/post";
    }

    @GetMapping("/delete/{id}")
    String doDeleteUser(@PathVariable("id") Integer id){
        postService.remove(id);
        return "redirect:/post";
    }

}
