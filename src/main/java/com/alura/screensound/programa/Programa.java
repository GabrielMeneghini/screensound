package com.alura.screensound.programa;

import com.alura.screensound.entidades.Artista;
import com.alura.screensound.entidades.Musica;
import com.alura.screensound.entidades.TipoDoArtista;
import com.alura.screensound.repository.ArtistaRepository;
import com.alura.screensound.repository.MusicaRepository;

import java.util.List;
import java.util.Optional;
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
                    \n*** Screen Sound Músicas ***
                    
                    1- Cadastrar artistas
                    2- Cadastrar músicas
                    3- Listar músicas
                    4- Buscar músicas por artistas
                    
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

        Optional<Artista> optionalArtista = buscarArtista();

        if (optionalArtista.isPresent()) {
            Artista artista = optionalArtista.get();

            List<Musica> musicaList = musicaRepository.findByArtistaNomeIgnoreCase(artista.getNome());
            musicaList.forEach(System.out::println);
        } else {
            System.out.println("O artista digitado não foi encontrado.");
        }
    }

    private void cadastrarArtistas() {
        int opcaoArtista = -1;
        while (opcaoArtista != 2) {
            System.out.println("Qual é o nome do artista?");
            String nomeArtista = sc.nextLine();

            System.out.println("""
                    Qual é o tipo do artista? Escolha uma das opções abaixo:
                    1- Solo
                    2- Dupla
                    3- Banda
                    """);
            int opcaoTipoArtista = sc.nextInt();
            sc.nextLine();
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
            System.out.println("""
                    Deseja cadastrar outro artista?
                    1- Sim
                    2- Não""");
            opcaoArtista = sc.nextInt(); sc.nextLine();
        }
    }

    private void cadastrarMusicas() {
        System.out.println("Escolha um artista dentre os já cadastrados para adicionar músicas a ele:");
        listarArtistas();

        Optional<Artista> optionalArtista = buscarArtista();
        if (optionalArtista.isPresent()) {
            int opcaoMusica = -1;
            while (opcaoMusica != 2) {
                Artista artista = optionalArtista.get();

                System.out.println("\nQual o nome da música que você quer adicionar para " + artista.getNome() + "?");
                String nomeMusica = sc.nextLine();

                Musica musica = new Musica(nomeMusica, artista);
                musicaRepository.save(musica);
                artista.getMusicas().add(musica);
                System.out.println("Música cadastrada com sucesso.\n");
                System.out.printf("""
                    Deseja adicionar outra música para %s?
                    1- Sim
                    2- Não\n""", artista.getNome());
                opcaoMusica = sc.nextInt(); sc.nextLine();
            }
        } else {
            System.out.println("O artista digitado não foi encontrado.");
        }
    }

    private void listarArtistas() {
        List<Artista> artistaList = artistaRepository.findAll();
        artistaList.forEach(System.out::println);
    }

    private void listarMusicas() {
        List<Musica> musicaList = musicaRepository.OrderByArtistaNome();
        musicaList.forEach(System.out::println);
    }

    private Optional<Artista> buscarArtista() {
        System.out.print("\nEscreva o nome do artista escolhido: ");
        String nomeArtista = sc.nextLine();
        return artistaRepository.findByNomeContainingIgnoreCase(nomeArtista);
    }

}
