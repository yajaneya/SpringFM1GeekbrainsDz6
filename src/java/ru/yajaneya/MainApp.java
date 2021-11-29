package ru.yajaneya;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.yajaneya.dao.CustomerDao;
import ru.yajaneya.dao.ProductDao;
import ru.yajaneya.entities.Product;
import ru.yajaneya.services.OrderService;
import ru.yajaneya.utils.SessionFactoryUtils;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        CustomerDao customerDao = context.getBean(CustomerDao.class);
        ProductDao productDao = context.getBean(ProductDao.class);

        System.out.println();
        System.out.println("Задание 2.");
        System.out.println("************");
        System.out.println("Продукты");
        System.out.println("-------------");
        productDao.findAll().forEach(p -> System.out.println(p));
        System.out.println("-------------");
        System.out.println();

        System.out.println("Покупатели");
        System.out.println("-------------");
        customerDao.findAll().forEach(c -> System.out.println(c));
        System.out.println("-------------");
        System.out.println();

        System.out.println("Задание 3.");
        System.out.println("************");
        // Задаем параметры:
        Long id_cust = 2L; // id покупателя
        Long id_prod = 3L; // id продукта
        OrderService orderService = context.getBean(OrderService.class);
        System.out.println("Продукты, купленные " + customerDao.findById(id_cust).getName() + " (id = " + id_cust + ")" );
        System.out.println("-------------");
        orderService.productsByIdCustomer(id_cust).forEach(p -> System.out.println(p.getTitle()));
        System.out.println("-------------");
        System.out.println();
        System.out.println("Покупатели, купившие " + productDao.findById(id_prod).getTitle() + " (id = " + id_prod + ")");
        System.out.println("-------------");
        orderService.customersByIdProduct(id_prod).forEach(c -> System.out.println(c.getName()));
        System.out.println("-------------");
        System.out.println();

    }
}
