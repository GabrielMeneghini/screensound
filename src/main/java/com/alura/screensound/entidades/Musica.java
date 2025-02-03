package com.alura.screensound.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "musicas")
public class Musica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "artista_id")
    private Artista artista;

    // Constructors ----------------------------------------------------------------------------------------------------
    public Musica() {}

    public Musica(String nome, Artista artista) {
        this.nome = nome;
        this.artista = artista;
    }

    // Getters and Setters ---------------------------------------------------------------------------------------------
    public String getNome() {
        return nome;
    }

    public Artista getArtista() {
        return artista;
    }
}
