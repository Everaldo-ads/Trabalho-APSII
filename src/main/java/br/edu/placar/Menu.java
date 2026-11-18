package br.edu.placar;

import java.util.Map;
import java.util.Scanner;

class Menu {
    private final Partida partida;
    private final Historico historico;
    private final Narrador narrador;
    private final Map<String, Runnable> acoes;

    Menu(Partida partida, Historico historico, Narrador narrador) {
        this.partida = partida;
        this.historico = historico;
        this.narrador = narrador;
        acoes = Map.of(
                "1", () -> partida.registrarGol(Equipe.AZUL),
                "2", () -> partida.registrarGol(Equipe.VERDE),
                "3", () -> System.out.println(partida.placarAtual()),
                "4", this::mostrarHistorico,
                "5", this::alternarNarracao
        );
    }

    void executar(Scanner entrada) {
        System.out.println("Partida entre Azul e Verde");
        while (true) {
            String acaoNarrador = partida.estaInscrito(narrador) ? "Desligar" : "Ligar";
            System.out.println("\n1 - Gol do Azul     2 - Gol do Verde");
            System.out.println("3 - Ver placar      4 - Ver histórico");
            System.out.println("5 - " + acaoNarrador + " narração  0 - Sair");
            System.out.print("Escolha uma opção: ");
            if (!entrada.hasNextLine()) {
                return;
            }
            String opcao = entrada.nextLine().trim();
            if ("0".equals(opcao)) {
                return;
            }
            Runnable acao = acoes.get(opcao);
            if (acao == null) {
                System.out.println("Opção inválida.");
            } else {
                acao.run();
            }
        }
    }

    private void alternarNarracao() {
        if (partida.estaInscrito(narrador)) {
            partida.remover(narrador);
            System.out.println("Narração desligada.");
        } else {
            partida.inscrever(narrador);
            System.out.println("Narração ligada.");
        }
    }

    private void mostrarHistorico() {
        var registros = historico.registros();
        if (registros.isEmpty()) {
            System.out.println("Nenhum gol registrado.");
            return;
        }
        for (int i = 0; i < registros.size(); i++) {
            System.out.println("Gol " + (i + 1) + " | " + registros.get(i));
        }
    }
}
