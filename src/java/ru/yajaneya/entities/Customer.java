package ru.yajaneya.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "customers")
public class Customer {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "name")
    private String name;

    @ManyToMany (fetch = FetchType.EAGER)
    @JoinTable (
            name = "customers_products",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;


    public Customer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(id + ". " + name + ", куплено товаров " + products.size() + ":");
        products.forEach(p -> sb.append(" " + p.getTitle() + ","));
        String str = sb.substring(0, sb.length() - 1);
        str += ".";
        return str;
    }
}
