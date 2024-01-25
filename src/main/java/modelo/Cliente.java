package modelo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Cliente")
@Table
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCliente")
    private int idCliente;

    @Column(name = "dni", columnDefinition = "char(9)")
    private String dni;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    List<Alquiler> listaAlquiler = new ArrayList<Alquiler>();

    public void addAlquiler(Alquiler alquiler) {
        this.listaAlquiler.add(alquiler);
    }

    public Cliente(String dni, String nombre, String correo) {
        this.dni = dni;
        this.nombre = nombre;
        this.email = correo;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String correo) {
        this.email = correo;
    }

    public Cliente() {
    }

    public List<Alquiler> getListaAlquiler() {
        return listaAlquiler;
    }

    public void setAlquilerLibro(List<Alquiler> listaAlquiler) {
        this.listaAlquiler = listaAlquiler;
    }

    @Override
    public String toString() {
        return "Cliente [idCliente=" + idCliente + ", dni=" + dni + ", nombre=" + nombre + ", correo=" + email
                + "]";
    }

}
