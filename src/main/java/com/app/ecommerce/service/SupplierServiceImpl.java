package com.app.ecommerce.service;

import com.app.ecommerce.entity.Supplier;
import com.app.ecommerce.repository.SupplierRepository;
import org.springframework.stereotype.Service;

@Service
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;

    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public Supplier save(Supplier supplier) {
        return this.supplierRepository.save(supplier);
    }
}
