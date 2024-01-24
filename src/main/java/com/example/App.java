package com.example;

import org.hibernate.Session;

import modelo.Alquiler_Repo;
import modelo.Cliente_Repo;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Session session = HibernateUtil.get().openSession();

        Alquiler_Repo alquiler_Repo = new Alquiler_Repo(session);
        alquiler_Repo.listarTodos();
    }
}
