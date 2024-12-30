package com.app.ecommerce.service;

import com.app.ecommerce.entity.Category;

public interface CategoryService {
    Category save(Category category);

    Category get(int id);
}
