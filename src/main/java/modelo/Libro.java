package modelo;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Libro")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "Codigo")
    private String codigo;
    @Column(name = "Titulo")
    private String titulo;
    @Column(name = "Autores")
    private String autores;
    @Column(name = "Ano")
    private int ano;

    @OneToMany(mappedBy = "libro", cascade = CascadeType.ALL)
    private List<Alquiler> lista_alquiler;

    public Libro(String codigo, String titulo, String autores, int ano) {

        this.codigo = codigo;
        this.titulo = titulo;
        this.autores = autores;
        this.ano = ano;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
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

}
