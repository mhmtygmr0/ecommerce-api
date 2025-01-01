package com.app.ecommerce.controller;

import com.app.ecommerce.core.config.modelMapper.ModelMapperService;
import com.app.ecommerce.service.product.ProductService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private final ModelMapperService modelMapper;
    private final ProductService productService;

    public ProductController(ModelMapperService modelMapper, ProductService productService) {
        this.modelMapper = modelMapper;
        this.productService = productService;
    }
}
