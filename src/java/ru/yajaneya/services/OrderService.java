package ru.yajaneya.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yajaneya.dao.CustomerDao;
import ru.yajaneya.dao.ProductDao;
import ru.yajaneya.entities.Customer;
import ru.yajaneya.entities.Product;

import java.util.List;

@Component
public class OrderService {
    ProductDao productDao;
    CustomerDao customerDao;


    @Autowired
    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Autowired
    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public List<Product> productsByIdCustomer (Long id) {
        List<Product> products = customerDao.findById(id).getProducts();
        return products;
    }

    public List<Customer> customersByIdProduct (Long id) {
        List<Customer> customers = productDao.findById(id).getCustomers();
        return customers;
    }
}
