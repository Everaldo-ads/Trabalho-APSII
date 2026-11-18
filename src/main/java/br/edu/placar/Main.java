package br.edu.placar;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Partida partida = new Partida();
        Historico historico = new Historico();
        Narrador narrador = new Narrador();
        partida.inscrever(historico);
        partida.inscrever(narrador);

        try (Scanner entrada = new Scanner(System.in)) {
            new Menu(partida, historico, narrador).executar(entrada);
        }
    }
}
