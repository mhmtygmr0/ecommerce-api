package com.app.ecommerce.controller;

import com.app.ecommerce.entity.Category;
import com.app.ecommerce.service.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories/")
public class CategoryController {

    private final CategoryServiceImpl categoryService;

    @Autowired
    public CategoryController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Category save(@RequestBody Category category) {
        return this.categoryService.save(category);
    }
}
