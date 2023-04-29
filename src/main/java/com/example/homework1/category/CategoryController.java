package com.example.homework1.category;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("")
    String requestCategoriesView(Model model){
        model.addAttribute("categories", categoryService.findAll());
        return "pages/category/categories";
    }

    @GetMapping("/{id}")
    String requestCategoryView(@PathVariable("id") Integer id, Model model){
        model.addAttribute("category", categoryService.findById(id));
        return "pages/category/category";
    }

    @GetMapping("/add")
    String requestFormAddView(Model model){
        model.addAttribute("category", new Category());
        return "pages/category/forms";
    }

    @PostMapping("/add")
    String doAddView(Category category){
        int min = 11;
        int max = 400;
        int id = (int)(Math.random()*(max-min+1)+min);
        category.setId(id);
        categoryService.addNew(category);
        return "redirect:/category";
    }

    @GetMapping("/edit/{id}")
    String requestFormEditView(@PathVariable("id") Integer id, Model model){
        model.addAttribute("category", categoryService.findById(id));
        model.addAttribute("isEdit", true);
        return "pages/category/forms";
    }

    @PostMapping("/edit/{id}")
    String doEditView(@PathVariable("id") Integer id, Category category){
        categoryService.edit(id, category);
        return "redirect:/category";
    }

    @GetMapping("/delete/{id}")
    String doDeleteCategory(@PathVariable("id") Integer id){
        categoryService.remove(id);
        return "redirect:/category";
    }
}
