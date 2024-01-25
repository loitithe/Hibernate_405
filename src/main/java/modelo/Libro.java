package modelo;

import java.util.List;

import javax.persistence.*;

@Entity(name = "Libro")
@Table
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLibro")
    private int idLibro;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "Titulo")
    private String titulo;

    @Column(name = "Autores")
    private String autores;

    @Column(name = "año")
    private int año;

    @OneToMany(mappedBy = "libro", cascade = CascadeType.ALL)
    private List<Alquiler> lista_alquiler;

    public Libro() {
    }

    @Override
    public String toString() {
        return "Libro [idLibro=" + idLibro + " codigo " + codigo + ", titulo=" + titulo + ", autores=" + autores
                + ", año=" + año
                + "]";
    }

    public Libro(String codigo, String titulo, String autores, int ano) {

        this.codigo = codigo;
        this.titulo = titulo;
        this.autores = autores;
        this.año = ano;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int codigo) {
        this.idLibro = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int ano) {
        this.año = ano;
    }

    public List<Alquiler> getLista_alquiler() {
        return lista_alquiler;
    }

    public void setLista_alquiler(List<Alquiler> alquiler) {
        this.lista_alquiler = alquiler;
    }

    public void addAlquiler(Alquiler alquiler) {
        this.lista_alquiler.add(alquiler);

    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

}
