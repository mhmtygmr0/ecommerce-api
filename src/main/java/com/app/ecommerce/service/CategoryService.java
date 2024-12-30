package com.app.ecommerce.service;

import com.app.ecommerce.entity.Category;
import org.springframework.data.domain.Page;

public interface CategoryService {
    Category save(Category category);

    Category get(int id);

    Page<Category> cursor(int page, int pageSize);

    Category update(Category category);

    boolean delete(int id);
}
