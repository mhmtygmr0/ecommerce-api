package com.app.ecommerce.controller;

import com.app.ecommerce.entity.Category;
import com.app.ecommerce.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Category save(@Valid @RequestBody Category category) {
        return this.categoryService.save(category);
    }
}
