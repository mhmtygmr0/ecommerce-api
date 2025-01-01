package com.app.ecommerce.controller;

import com.app.ecommerce.core.config.modelMapper.ModelMapperService;
import com.app.ecommerce.core.result.Result;
import com.app.ecommerce.core.result.ResultData;
import com.app.ecommerce.core.utilies.ResultHelper;
import com.app.ecommerce.dto.request.product.ProductSaveRequest;
import com.app.ecommerce.dto.request.product.ProductUpdateRequest;
import com.app.ecommerce.dto.response.CursorResponse;
import com.app.ecommerce.dto.response.ProductResponse;
import com.app.ecommerce.dto.response.SupplierResponse;
import com.app.ecommerce.entity.Category;
import com.app.ecommerce.entity.Product;
import com.app.ecommerce.entity.Supplier;
import com.app.ecommerce.service.category.CategoryService;
import com.app.ecommerce.service.product.ProductService;
import com.app.ecommerce.service.supplier.SupplierService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ModelMapperService modelMapper;
    private final ProductService productService;
    private final CategoryService categoryService;
    private final SupplierService supplierService;

    public ProductController(ModelMapperService modelMapper, ProductService productService, CategoryService categoryService, SupplierService supplierService) {
        this.modelMapper = modelMapper;
        this.productService = productService;
        this.categoryService = categoryService;
        this.supplierService = supplierService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<ProductResponse> save(@Valid @RequestBody ProductSaveRequest productSaveRequest) {
        Product product = this.modelMapper.forRequest().map(productSaveRequest, Product.class);

        Category category = this.categoryService.get(productSaveRequest.getCategoryId());
        product.setCategory(category);

        Supplier supplier = this.supplierService.get(productSaveRequest.getSupplierId());
        product.setSupplier(supplier);

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
    public ResultData<CursorResponse<ProductResponse>> cursor(@RequestParam(name = "page", required = false, defaultValue = "0") int page, @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
        Page<Product> productPage = this.productService.cursor(page, pageSize);
        Page<ProductResponse> productResponsePage = productPage.map(product -> this.modelMapper.forResponse().map(product, ProductResponse.class));

        return ResultHelper.cursor(productResponsePage);
    }

    @GetMapping("/{id}/supplier")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<SupplierResponse> getSupplier(@PathVariable("id") int id) {
        Product product = this.productService.get(id);
        return ResultHelper.success(this.modelMapper.forResponse().map(product.getSupplier(), SupplierResponse.class));
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResultData<ProductResponse> update(@Valid @RequestBody ProductUpdateRequest productUpdateRequest) {
        Product product = this.modelMapper.forRequest().map(productUpdateRequest, Product.class);

        Category category = this.categoryService.get(productUpdateRequest.getCategoryId());
        product.setCategory(category);

        Supplier supplier = this.supplierService.get(productUpdateRequest.getSupplierId());
        product.setSupplier(supplier);

        this.productService.update(product);
        return ResultHelper.created(this.modelMapper.forResponse().map(product, ProductResponse.class));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") int id) {
        this.productService.delete(id);
        return ResultHelper.ok();
    }
}
