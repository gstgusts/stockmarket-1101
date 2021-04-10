package com.example.stockmarket.data;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class StockMarketRepository {
    private static SessionFactory factory;

    public StockMarketRepository() {
        try {
            factory = new Configuration()
                    .configure()
                    .addAnnotatedClass(Category.class)
                    .addAnnotatedClass(Stock.class)
                    .addAnnotatedClass(StockCategory.class)
                    .buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public List<Category> getCategories() {
        var session = factory.openSession();

        try {
            return session.createQuery("FROM Category").list();
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }

        return new ArrayList<>();
    }

    public List<Stock> getStocks() {
        var session = factory.openSession();

        try {
            return session.createQuery("FROM Stock").list();
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }

        return new ArrayList<>();
    }
}
