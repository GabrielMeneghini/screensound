package com.alura.screensound.programa;

import com.alura.screensound.entidades.Artista;
import com.alura.screensound.entidades.Musica;
import com.alura.screensound.entidades.TipoDoArtista;
import com.alura.screensound.repository.ArtistaRepository;
import com.alura.screensound.repository.MusicaRepository;

import java.util.List;
import java.util.Scanner;

public class Programa {

    private Scanner sc = new Scanner(System.in);
    private ArtistaRepository artistaRepository;
    private MusicaRepository musicaRepository;

    // Constructors ----------------------------------------------------------------------------------------------------
    public Programa(ArtistaRepository artistaRepository, MusicaRepository musicaRepository) {
        this.artistaRepository = artistaRepository;
        this.musicaRepository = musicaRepository;
    }

    // Methods ---------------------------------------------------------------------------------------------------------
    public void iniciarPrograma() {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("""
                    *** Screen Sound Músicas ***
                    
                    1- Cadastrar artistas
                    2- Cadastrar músicas
                    3- Listar músicas
                    4- Buscar músicas por artistas
                    5- Pesquisar dados por artista (com IA)
                    
                    0- Sair
                    """);
            opcao = sc.nextInt(); sc.nextLine();
            switch (opcao) {
                case 1:
                    cadastrarArtistas();
                    break;
                case 2:
                    cadastrarMusicas();
                    break;
                case 3:
                    listarMusicas();
                    break;
                case 4:
                    buscarMusicasPorArtista();
                    break;
                case 5:

                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private void buscarMusicasPorArtista() {
        System.out.println("Escolha um artista dentre os já cadastrados para ver todas as suas músicas:");
        listarArtistas();

        Artista artista = buscarArtista();

        List<Musica> musicaList = musicaRepository.findByArtistaNomeIgnoreCase(artista.getNome());
        musicaList.forEach(System.out::println);
    }

    private void cadastrarArtistas() {
        System.out.println("Qual é o nome do artista?");
        String nomeArtista = sc.nextLine();

        System.out.println("""
                Qual é o tipo do artista? Escolha uma das opções abaixo:
                1- Solo
                2- Dupla
                3- Banda
                """);
        int opcaoTipoArtista = sc.nextInt(); sc.nextLine();
        TipoDoArtista tipoDoArtista = null;
        switch (opcaoTipoArtista) {
            case 1:
                tipoDoArtista = TipoDoArtista.SOLO;
                break;
            case 2:
                tipoDoArtista = TipoDoArtista.DUPLA;
                break;
            case 3:
                tipoDoArtista = TipoDoArtista.BANDA;
                break;
            default:
                System.out.println("Opção inválida");
        }

        artistaRepository.save(new Artista(nomeArtista, tipoDoArtista));
        System.out.println("Artista cadastrado com sucesso.\n");
    }

    private void cadastrarMusicas() {
        System.out.println("Escolha um artista dentre os já cadastrados para adicionar músicas:");
        listarArtistas();

        Artista artista = buscarArtista();

        System.out.println("\nQual o nome da música que você quer adicionar para " + artista.getNome() + "?");
        String nomeMusica = sc.nextLine();

        musicaRepository.save(new Musica(nomeMusica, artista));
        System.out.println("Música cadastrada com sucesso.\n");
    }

    private void listarArtistas() {
        List<Artista> artistaList = artistaRepository.findAll();
        artistaList.forEach(System.out::println);
    }

    private void listarMusicas() {
        List<Musica> musicaList = musicaRepository.findAll();
        musicaList.forEach(System.out::println);
    }

    private Artista buscarArtista() {
        System.out.print("\nEscreva o nome do artista escolhido: ");
        String nomeArtista = sc.nextLine();
        return artistaRepository.findByNomeContainingIgnoreCase(nomeArtista);
    }
}
