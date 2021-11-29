package ru.yajaneya.dao;

import org.springframework.stereotype.Component;
import ru.yajaneya.entities.Customer;

import java.util.List;

@Component
public interface CustomerDao {

    Customer findById (Long id);
    List<Customer> findAll();
    void deleteById(Long id);
    Customer saveOrUpdate(Customer customer);

}
