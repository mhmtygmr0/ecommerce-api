package com.app.ecommerce.service;

import com.app.ecommerce.core.exception.NotFoundException;
import com.app.ecommerce.core.utilies.Msg;
import com.app.ecommerce.entity.Supplier;
import com.app.ecommerce.repository.SupplierRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    @Override
    public Supplier get(int id) {
        return this.supplierRepository.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public Page<Supplier> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return this.supplierRepository.findAll(pageable);
    }

    @Override
    public Supplier update(Supplier supplier) {
        this.get(supplier.getId());
        return this.supplierRepository.save(supplier);
    }

    @Override
    public boolean delete(int id) {
        Supplier supplier = this.get(id);
        this.supplierRepository.delete(supplier);
        return true;
    }
}
