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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'guardar'");
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizar'");
    }

    @Override
    public void eliminar(Alquiler t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }

}
