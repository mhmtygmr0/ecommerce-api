package com.app.ecommerce.service.product;

import com.app.ecommerce.entity.Product;
import org.springframework.data.domain.Page;

public interface ProductService {
    Product save(Product product);

    Product get(int id);

    Page<Product> cursor(int page, int pageSize);

    Product update(Product product);

    boolean delete(int id);
}
