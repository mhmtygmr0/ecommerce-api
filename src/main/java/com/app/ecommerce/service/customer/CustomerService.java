package com.app.ecommerce.service.customer;

import com.app.ecommerce.entity.Customer;
import org.springframework.data.domain.Page;

public interface CustomerService {
    Customer save(Customer customer);

    Customer get(int id);

    Page<Customer> cursor(int page, int pageSize);

    Customer update(Customer customer);

    boolean delete(int id);
}
