package com.alura.screensound.repository;

import com.alura.screensound.entidades.Artista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {
}
