package modelo;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "Alquiler")
public class Alquiler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAlquiler;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "Id_Libro")
    private Libro libro;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "Id_Cliente")
    private Cliente cliente;

    @Column(name = "Fecha")
    private Date fecha;

    @Column(name = "Alquilado")
    private boolean alquilado;

    public Alquiler(Date fecha, boolean alquilado) {
        this.fecha = fecha;
        this.alquilado = alquilado;
    }


}
