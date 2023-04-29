package com.example.homework1.user;

import com.example.homework1.category.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("")
    String requestUsersView(Model model){
        model.addAttribute("users", userService.findAll());
        return "pages/user/users";
    }

    @GetMapping("/{id}")
    String requestCategoryView(@PathVariable("id") Integer id, Model model){
        model.addAttribute("user", userService.findById(id));
        return "pages/user/user";
    }

    @GetMapping("/add")
    String requestFormAddView(Model model){
        model.addAttribute("user", new User());
        return "pages/user/forms";
    }

    @PostMapping("/add")
    String doAddView(User user){
        int min = 11;
        int max = 400;
        int id = (int)(Math.random()*(max-min+1)+min);
        user.setId(id);
        userService.addNew(user);
        return "redirect:/user";
    }

    @GetMapping("/edit/{id}")
    String requestFormEditView(@PathVariable("id") Integer id, Model model){
        model.addAttribute("user", userService.findById(id));
        model.addAttribute("isEdit", true);
        return "pages/user/forms";
    }

    @PostMapping("/edit/{id}")
    String doEditView(@PathVariable("id") Integer id, User user){
        userService.edit(id, user);
        return "redirect:/user";
    }

    @GetMapping("/delete/{id}")
    String doDeleteUser(@PathVariable("id") Integer id){
        userService.remove(id);
        return "redirect:/user";
    }

}
