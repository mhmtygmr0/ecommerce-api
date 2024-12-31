package com.app.ecommerce.controller;

import com.app.ecommerce.core.config.modelMapper.ModelMapperService;
import com.app.ecommerce.core.result.ResultData;
import com.app.ecommerce.core.utilies.ResultHelper;
import com.app.ecommerce.dto.request.supplier.SupplierSaveRequest;
import com.app.ecommerce.dto.response.SupplierResponse;
import com.app.ecommerce.entity.Supplier;
import com.app.ecommerce.service.SupplierService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("suppliers")
public class SupplierController {

    private final SupplierService supplierService;

    private final ModelMapperService modelMapper;

    public SupplierController(SupplierService supplierService, ModelMapperService modelMapperService) {
        this.supplierService = supplierService;
        this.modelMapper = modelMapperService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<SupplierResponse> save(@Valid @RequestBody SupplierSaveRequest supplierSaveRequest) {
        Supplier supplier = this.modelMapper.forRequest().map(supplierSaveRequest, Supplier.class);
        this.supplierService.save(supplier);
        return ResultHelper.created(this.modelMapper.forResponse().map(supplier, SupplierResponse.class));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<SupplierResponse> get(@PathVariable("id") int id) {
        Supplier supplier = this.supplierService.get(id);
        return ResultHelper.success(this.modelMapper.forResponse().map(supplier, SupplierResponse.class));
    }
}
