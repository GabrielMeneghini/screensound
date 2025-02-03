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

    @Enumerated(EnumType.STRING)
    private TipoDoArtista tipoDoArtista;

    @Transient
    private Artista artista;

    // Constructors ----------------------------------------------------------------------------------------------------
    public Musica() {}

    public Musica(String nome, TipoDoArtista tipoDoArtista, Artista artista) {
        this.nome = nome;
        this.tipoDoArtista = tipoDoArtista;
        this.artista = artista;
    }

    // Getters and Setters ---------------------------------------------------------------------------------------------
    public String getNome() {
        return nome;
    }

    public TipoDoArtista getTipoDoArtista() {
        return tipoDoArtista;
    }

    public Artista getArtista() {
        return artista;
    }
}
