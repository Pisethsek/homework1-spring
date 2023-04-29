package com.example.homework1.category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category findById(Integer id);
    void addNew(Category category);
    void edit(Integer id, Category category);
    void remove(Integer id);
}
