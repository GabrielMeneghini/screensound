package com.alura.screensound.programa;

import java.util.Scanner;

public class Programa {

    Scanner sc = new Scanner(System.in);

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
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:

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
}
