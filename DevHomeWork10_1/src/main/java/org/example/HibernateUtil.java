package org.example;


import org.example.entity.Client;
import org.example.entity.Planet;
import org.example.entity.Ticket;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
    private static final HibernateUtil INSTANCE;


    private SessionFactory sessionFactory;

    static {
        INSTANCE = new HibernateUtil();
    }

    private HibernateUtil() {
        sessionFactory = new Configuration()
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Planet.class)
                .addAnnotatedClass(Ticket.class)
                .buildSessionFactory();
    }

    public static HibernateUtil getInstance() {
        return INSTANCE;
    }

    public void close() {
        sessionFactory.close();
    }
}
