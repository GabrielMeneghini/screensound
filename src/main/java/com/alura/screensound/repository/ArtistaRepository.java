package com.alura.screensound.repository;

import com.alura.screensound.entidades.Artista;
import com.alura.screensound.entidades.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {

    Optional<Artista> findByNomeContainingIgnoreCase(String nomeArtista);

    @Query("SELECT m FROM Artista a JOIN a.musicas m WHERE m.artista.nome ILIKE %:nomeArtista%")
    List<Musica> buscaMusicasPorArtista(String nomeArtista);

}
