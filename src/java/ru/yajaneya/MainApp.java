package ru.yajaneya;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.yajaneya.dao.CustomerDao;
import ru.yajaneya.dao.ProductDao;
import ru.yajaneya.entities.Product;
import ru.yajaneya.utils.SessionFactoryUtils;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        CustomerDao customerDao = context.getBean(CustomerDao.class);
        ProductDao productDao = context.getBean(ProductDao.class);

        System.out.println();
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
    }
}
