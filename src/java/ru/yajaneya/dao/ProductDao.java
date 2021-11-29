package ru.yajaneya.dao;

import org.springframework.stereotype.Component;
import ru.yajaneya.entities.Product;

import java.util.List;

@Component
public interface ProductDao {

    Product findById (Long id);
    List<Product> findAll();
    void deleteById(Long id);
    Product saveOrUpdate(Product product);
}
