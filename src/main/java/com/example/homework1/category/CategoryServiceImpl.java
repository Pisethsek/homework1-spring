package com.example.homework1.category;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.getCategories();
    }

    @Override
    public Category findById(Integer id) {
        return categoryRepository.getCategories().stream().filter(c -> Objects.equals(c.getId(), id)).findFirst().orElse(null);
    }

    @Override
    public void addNew(Category category) {
        categoryRepository.getCategories().add(0, category);
    }

    @Override
    public void edit(Integer id, Category category) {
        Category c = findById(id);
        int index = categoryRepository.getCategories().indexOf(c);
        categoryRepository.getCategories().set(index, category);
    }

    @Override
    public void remove(Integer id) {
        Category c = findById(id);
        categoryRepository.getCategories().remove(c);
    }
}
