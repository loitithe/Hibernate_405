package modelo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Cliente")
@Table
public class Cliente {

    @Id
    @Column(name = "idCliente")
    private String dni;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Correo")
    private String correo;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    List<Alquiler> listaAlquiler = new ArrayList<Alquiler>();

    public void addAlquiler(Alquiler alquiler) {
        this.listaAlquiler.add(alquiler);
    }

    public Cliente(String dni, String nombre, String correo) {
        this.dni = dni;
        this.nombre = nombre;
        this.correo = correo;
    }

    public String getDni() {
        return dni;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
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
        return "Cliente [dni=" + dni + ", nombre=" + nombre + ", correo=" + correo + ", listaAlquiler=" + listaAlquiler
                + "]";
    }

}
