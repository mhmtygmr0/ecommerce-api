package com.app.ecommerce.service.customer;

import com.app.ecommerce.core.exception.NotFoundException;
import com.app.ecommerce.core.utilies.Msg;
import com.app.ecommerce.entity.Customer;
import com.app.ecommerce.repository.CustomerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer save(Customer customer) {
        return this.customerRepository.save(customer);
    }

    @Override
    public Customer get(int id) {
        return this.customerRepository.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public Page<Customer> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return this.customerRepository.findAll(pageable);
    }

    @Override
    public Customer update(Customer customer) {
        this.get(customer.getId());
        return this.customerRepository.save(customer);
    }

    @Override
    public boolean delete(int id) {
        Customer customer = this.get(id);
        this.customerRepository.delete(customer);
        return true;
    }
}
