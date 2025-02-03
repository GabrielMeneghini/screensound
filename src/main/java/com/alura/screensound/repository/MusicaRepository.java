package com.alura.screensound.repository;

import com.alura.screensound.entidades.Musica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicaRepository extends JpaRepository<Musica, Long> {
}
