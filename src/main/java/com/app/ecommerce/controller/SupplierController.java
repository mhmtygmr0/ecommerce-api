package com.app.ecommerce.controller;

import com.app.ecommerce.core.config.modelMapper.ModelMapperService;
import com.app.ecommerce.core.result.Result;
import com.app.ecommerce.core.result.ResultData;
import com.app.ecommerce.core.utilies.ResultHelper;
import com.app.ecommerce.dto.request.supplier.SupplierSaveRequest;
import com.app.ecommerce.dto.request.supplier.SupplierUpdateRequest;
import com.app.ecommerce.dto.response.CursorResponse;
import com.app.ecommerce.dto.response.SupplierResponse;
import com.app.ecommerce.entity.Supplier;
import com.app.ecommerce.service.SupplierService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
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

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CursorResponse<SupplierResponse>> cursor(@RequestParam(name = "page", required = false, defaultValue = "0") int page, @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
        Page<Supplier> supplierPage = this.supplierService.cursor(page, pageSize);
        Page<SupplierResponse> supplierResponsePage = supplierPage.map(supplier -> this.modelMapper.forResponse().map(supplier, SupplierResponse.class));

        return ResultHelper.cursor(supplierResponsePage);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<SupplierResponse> update(@Valid @RequestBody SupplierUpdateRequest supplierUpdateRequest) {
        Supplier supplier = this.modelMapper.forRequest().map(supplierUpdateRequest, Supplier.class);
        this.supplierService.update(supplier);
        return ResultHelper.success(this.modelMapper.forResponse().map(supplier, SupplierResponse.class));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") int id) {
        this.supplierService.delete(id);
        return ResultHelper.ok();
    }
}
