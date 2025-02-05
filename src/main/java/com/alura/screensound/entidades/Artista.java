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

    @Enumerated(EnumType.STRING)
    private TipoDoArtista tipoDoArtista;

    @OneToMany(mappedBy = "artista", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Musica> musicas;

    // Constructors ----------------------------------------------------------------------------------------------------
    public Artista() {}

    public Artista(String nome, TipoDoArtista tipoDoArtista) {
        this.nome = nome;
        this.tipoDoArtista = tipoDoArtista;
    }

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

    public void setMusicas(List<Musica> musicas) {
        this.musicas = musicas;
    }

    // Methods ---------------------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return "Artista{" +
                "nome='" + nome + '\'' +
                ", tipoDoArtista=" + tipoDoArtista +
                '}';
    }

}
