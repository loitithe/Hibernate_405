package modelo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Libro_Repo implements Repositorio<Libro> {
    Session session;

    public Libro_Repo(Session session) {
        this.session = session;
    }

    public Libro obtenerLibro(int idLibro) {
        for (Libro libro : listarTodos()) {
            if (libro.getIdLibro() == idLibro) {
                return libro;
            }
        }
        System.out.println("Libro no encontrado");
        return null;
    }

    @Override
    public void guardar(Libro t) {
        Transaction trx = this.session.beginTransaction();
        session.save(t);
        trx.commit();
    }

    @Override
    public List<Libro> listarTodos() {
        Transaction trx = this.session.beginTransaction();
        List<Libro> listaLibros = session.createQuery("FROM Libro", Libro.class).getResultList();
        for (Libro libro : listaLibros) {
            System.out.println(libro.toString());
        }
        trx.commit();
        return listaLibros;
    }

    @Override
    public void actualizar(Libro t) {
        Transaction trx = this.session.beginTransaction();
        session.update(t);
        trx.commit();
    }

    @Override
    public void eliminar(Libro t) {
        Transaction trx = this.session.beginTransaction();
        session.delete(t);
        trx.commit();
    }

}
