package com.example.homework1.Post;

import com.example.homework1.category.Category;
import com.example.homework1.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private Integer id;
    private String title;
    private String description;
    private User user;
    private Category category;
    private String photo;
}
