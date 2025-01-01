package com.app.ecommerce.controller;

import com.app.ecommerce.core.config.modelMapper.ModelMapperService;
import com.app.ecommerce.core.result.ResultData;
import com.app.ecommerce.core.utilies.ResultHelper;
import com.app.ecommerce.dto.request.product.ProductSaveRequest;
import com.app.ecommerce.dto.response.CursorResponse;
import com.app.ecommerce.dto.response.ProductResponse;
import com.app.ecommerce.entity.Product;
import com.app.ecommerce.service.product.ProductService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ModelMapperService modelMapper;
    private final ProductService productService;

    public ProductController(ModelMapperService modelMapper, ProductService productService) {
        this.modelMapper = modelMapper;
        this.productService = productService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<ProductResponse> save(@Valid @RequestBody ProductSaveRequest productSaveRequest) {
        Product product = this.modelMapper.forRequest().map(productSaveRequest, Product.class);
        this.productService.save(product);
        return ResultHelper.created(this.modelMapper.forResponse().map(product, ProductResponse.class));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<ProductResponse> get(@PathVariable("id") int id) {
        Product product = this.productService.get(id);
        return ResultHelper.success(this.modelMapper.forResponse().map(product, ProductResponse.class));
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CursorResponse<ProductResponse>> cursor(@RequestParam(name = "page", required = false, defaultValue = "0") int page,
                                                              @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
        Page<Product> productPage = this.productService.cursor(page, pageSize);
        Page<ProductResponse> productResponsePage = productPage.map(product -> this.modelMapper.forResponse().map(product, ProductResponse.class));

        return ResultHelper.cursor(productResponsePage);
    }
}
