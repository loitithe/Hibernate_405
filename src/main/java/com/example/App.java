package com.example;

import java.util.Date;

import org.hibernate.Session;

import modelo.Alquiler;
import modelo.Alquiler_Repo;
import modelo.Cliente;
import modelo.Cliente_Repo;
import modelo.Libro;
import modelo.Libro_Repo;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Session session = HibernateUtil.get().openSession();

        Alquiler_Repo alquiler_Repo = new Alquiler_Repo(session);
        alquiler_Repo.listarTodos();

        Libro_Repo libro_Repo = new Libro_Repo(session);
        libro_Repo.listarTodos();

        Cliente_Repo cliente_Repo = new Cliente_Repo(session);
        // cliente_Repo.obtenerCliente(2);
        Cliente cliente = new Cliente("3333", "Paxo", "paxostyles@gmail.com");
        cliente_Repo.guardar(cliente);
        // cliente_Repo.listarTodos();
        // cliente_Repo.eliminar(cliente_Repo.obtenerCliente(3));
        // cliente_Repo.listarTodos();

        Libro libro = new Libro("8888", "Los 8", "severiano", 1970);
        libro_Repo.guardar(libro);
        // libro_Repo.eliminar(libro_Repo.obtenerLibro(4));
        // libro_Repo.listarTodos();

        Date date = new Date();

        Alquiler alquiler = new Alquiler(date, cliente, libro);
        alquiler_Repo.guardar(alquiler);
        alquiler_Repo.listarTodos();

    }
}
