package org.example.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
/**
 * Clase que representa la entidad pelicula
 * **/
@Data
@Entity
@Table(name = "pelicula")
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @OneToMany(mappedBy = "pelicula", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Opinion> opiniones = new ArrayList<>();

    private void addOpinion(Opinion opinion) {
        opiniones.add(opinion);
        opinion.setPelicula(this);
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", opiniones=" + opiniones +
                '}';
    }
}