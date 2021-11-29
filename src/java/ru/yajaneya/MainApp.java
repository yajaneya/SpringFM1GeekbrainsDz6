package ru.yajaneya;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.yajaneya.entities.Product;
import ru.yajaneya.utils.SessionFactoryUtils;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        SessionFactoryUtils s = new SessionFactoryUtils();

        s.init();

        s.getSession().beginTransaction();

        System.out.println();
        System.out.println("Продукты");
        System.out.println("-------------");
        s.getSession().createQuery("from Product").getResultList().forEach(p -> System.out.println(p));
        System.out.println("-------------");
        System.out.println();

        System.out.println("Покупатели");
        System.out.println("-------------");
        s.getSession().createQuery("from Customer").getResultList().forEach(p -> System.out.println(p));
        System.out.println("-------------");
        System.out.println();

        s.getSession().getTransaction().commit();


        s.shutdown();

    }
}
