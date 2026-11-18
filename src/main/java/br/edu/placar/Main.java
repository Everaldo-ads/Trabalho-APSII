package br.edu.placar;

import java.util.Scanner;

// Ponto de entrada: monta os objetos e inicia o menu
public class Main {
    // Método principal: escolhe os observadores concretos e liga tudo
    public static void main(String[] args) {
        // Cria a partida e os observadores
        Partida partida = new Partida();
        Historico historico = new Historico();
        Narrador narrador = new Narrador();

        // Inscreve os observadores (narração começa ligada)
        partida.inscrever(historico);
        partida.inscrever(narrador);

        // Abre o menu e fecha o Scanner ao terminar
        try (Scanner entrada = new Scanner(System.in)) {
            new Menu(partida, historico, narrador).executar(entrada);
        }
    }
}
