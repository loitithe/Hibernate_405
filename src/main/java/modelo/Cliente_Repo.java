package modelo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Cliente_Repo implements Repositorio<Cliente> {

    Session session;

    public Cliente_Repo(Session session) {
        this.session = session;
    }

    public Cliente obtenerCliente(int idCliente) {
        for (Cliente cliente : listarTodos()) {
            if (cliente.getIdCliente() == idCliente) {
                System.out.println(cliente.toString());
                return cliente;
            }
        }
        System.out.println("Cliente no encontrado.");
        return null;
    }

    @Override
    public void guardar(Cliente t) {
        Transaction trx = this.session.beginTransaction();
        this.session.save(t);
        trx.commit();

    }

    @Override
    public List<Cliente> listarTodos() {
        Transaction trx = this.session.beginTransaction();
        List<Cliente> listaClientes = session.createQuery("FROM Cliente", Cliente.class).getResultList();
        for (Cliente cliente : listaClientes) {
            System.out.println(cliente.toString());
        }
        trx.commit();
        return listaClientes;
    }

    @Override
    public void actualizar(Cliente t) {
        Transaction trx = this.session.beginTransaction();
        session.update(t);
        trx.commit();
    }

    @Override
    public void eliminar(Cliente t) {
        System.out.println("Borrando...");
        Transaction trx = this.session.beginTransaction();
        session.delete(t);
        trx.commit();
    }

}
