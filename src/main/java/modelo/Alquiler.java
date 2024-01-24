package modelo;

import java.util.Date;

import javax.persistence.*;

@Entity(name = "Alquiler")
@Table
public class Alquiler {

    public Alquiler() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAlquiler;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_libro")
    private Libro libro;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @Column(name = "Fecha")
    private Date fecha;

    @Column(name = "Alquilado")
    private boolean alquilado;

    public Alquiler(Date fecha, Cliente cliente, Libro libro) {
        this.fecha = fecha;
        this.cliente = cliente;
        this.libro = libro;

        libro.addAlquiler(this);
        cliente.listaAlquiler.add(this);
    }

    public int getIdAlquiler() {
        return idAlquiler;
    }

    public void setIdAlquiler(int idAlquiler) {
        this.idAlquiler = idAlquiler;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean isAlquilado() {
        return alquilado;
    }

    public void setAlquilado(boolean alquilado) {
        this.alquilado = alquilado;

    }

    @Override
    public String toString() {
        return "Alquiler [idAlquiler=" + idAlquiler + ", libro=" + libro + ", cliente=" + cliente + ", fecha=" + fecha
                + ", alquilado=" + alquilado + "]";
    }

}
