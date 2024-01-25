package modelo;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Alquiler_Repo implements Repositorio<Alquiler> {
    Session session;

    public Alquiler_Repo(Session session) {
        this.session = session;
    }

    @Override
    public void guardar(Alquiler t) {
        Transaction trx = this.session.beginTransaction();
        List<Alquiler> listaAlquiler = session.createQuery("FROM Alquiler", Alquiler.class).getResultList();
        for (Alquiler alquiler : listaAlquiler) {
            if (alquiler.equals(t)) {
                t.setAlquilado(!t.isAlquilado());
            }
        }
        session.save(t);
        trx.commit();
    }

    @Override
    public List<Alquiler> listarTodos() {
        Transaction trx = this.session.beginTransaction();
        List<Alquiler> listaAlquiler = session.createQuery("FROM Alquiler", Alquiler.class).getResultList();
        for (Alquiler alquiler : listaAlquiler) {
            System.out.println(alquiler.toString());
        }
        trx.commit();
        return listaAlquiler;
    }

    @Override
    public void actualizar(Alquiler t) {
        Transaction trx = this.session.beginTransaction();
        this.session.update(t);
        trx.commit();
    }

    @Override
    public void eliminar(Alquiler t) {
        Transaction trx = this.session.beginTransaction();
        this.session.delete(t);
        trx.commit();
    }

}
