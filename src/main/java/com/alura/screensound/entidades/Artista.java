package com.alura.screensound.entidades;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "artistas")
public class Artista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @Transient
    private List<Musica> musicas;

    // Constructors ----------------------------------------------------------------------------------------------------
    public Artista() {}

    public Artista(String nome, List<Musica> musicas) {
        this.nome = nome;
        this.musicas = musicas;
    }

    // Getters and Setters ---------------------------------------------------------------------------------------------
    public String getNome() {
        return nome;
    }

    public List<Musica> getMusicas() {
        return musicas;
    }
}
