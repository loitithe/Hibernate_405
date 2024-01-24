package com.example;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;

public class HibernateUtil {
    private static final SessionFactory SESSION_FACTORY;
    static {
        try {
            String hibernatePropsFilePath = "hibernate.cfg.xml";
            File hibernatePropsFile = new File(hibernatePropsFilePath);
            SESSION_FACTORY = new Configuration().configure(hibernatePropsFile).buildSessionFactory();

        } catch (Throwable e) {
            System.err.println("Error al crear la configuración de hibernate" + e.getMessage());
            throw new ExceptionInInitializerError();
        }
    }

    public static SessionFactory get() {
        return SESSION_FACTORY;
    }
}
