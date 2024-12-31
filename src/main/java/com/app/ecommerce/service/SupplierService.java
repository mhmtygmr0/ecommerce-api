package com.app.ecommerce.service;

import com.app.ecommerce.entity.Supplier;
import org.springframework.data.domain.Page;

public interface SupplierService {
    Supplier save(Supplier supplier);

    Supplier get(int id);

    Page<Supplier> cursor(int page, int pageSize);
}
