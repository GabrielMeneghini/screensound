package com.alura.screensound.programa;

import com.alura.screensound.entidades.Artista;
import com.alura.screensound.entidades.TipoDoArtista;
import com.alura.screensound.repository.ArtistaRepository;
import com.alura.screensound.repository.MusicaRepository;

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
                    5- Pesquisar dados por artista
                    
                    0- Sair
                    """);
            opcao = sc.nextInt(); sc.nextLine();
            switch (opcao) {
                case 1:
                    cadastrarArtistas();
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

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
}
