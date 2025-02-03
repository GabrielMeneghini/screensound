package com.alura.screensound.repository;

import com.alura.screensound.entidades.Musica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MusicaRepository extends JpaRepository<Musica, Long> {

    List<Musica> findByArtistaNomeIgnoreCase(String nome);

}
