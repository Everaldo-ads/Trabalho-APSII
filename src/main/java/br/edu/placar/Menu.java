package br.edu.placar;

import java.util.Map;
import java.util.Scanner;

// Menu de console: lê as opções e chama a Partida
public class Menu {
    private final Partida partida;
    private final Historico historico;
    private final Narrador narrador;
    // Mapa: opção digitada -> ação
    private final Map<String, Runnable> acoes;

    // Construtor: recebe as dependências e monta o mapa de opções
    public Menu(Partida partida, Historico historico, Narrador narrador) {
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

    // Laço principal: mostra o menu, lê a opção e executa
    public void executar(Scanner entrada) {
        System.out.println("Partida entre Azul e Verde");
        while (true) {
            // Texto da opção 5: Ligar ou Desligar
            String acaoNarrador = partida.estaInscrito(narrador) ? "Desligar" : "Ligar";

            // Mostra as opções
            System.out.println("\n1 - Gol do Azul     2 - Gol do Verde");
            System.out.println("3 - Ver placar      4 - Ver histórico");
            System.out.println("5 - " + acaoNarrador + " narração  0 - Sair");
            System.out.print("Escolha uma opção: ");

            // Sai se não houver mais entrada
            if (!entrada.hasNextLine()) {
                return;
            }

            // Lê a opção; "0" sai do programa
            String opcao = entrada.nextLine().trim();
            if ("0".equals(opcao)) {
                return;
            }

            // Executa a ação ou avisa que a opção é inválida
            Runnable acao = acoes.get(opcao);
            if (acao == null) {
                System.out.println("Opção inválida.");
            } else {
                acao.run();
            }
        }
    }

    // Liga ou desliga a narração (inscreve/remove o Narrador)
    private void alternarNarracao() {
        if (partida.estaInscrito(narrador)) {
            // Estava ligada: remove
            partida.remover(narrador);
            System.out.println("Narração desligada.");
        } else {
            // Estava desligada: inscreve
            partida.inscrever(narrador);
            System.out.println("Narração ligada.");
        }
    }

    // Mostra o histórico de gols
    private void mostrarHistorico() {
        var registros = historico.registros();

        // Sem gols: avisa e sai
        if (registros.isEmpty()) {
            System.out.println("Nenhum gol registrado.");
            return;
        }

        // Imprime cada gol numerado
        for (int i = 0; i < registros.size(); i++) {
            System.out.println("Gol " + (i + 1) + " | " + registros.get(i));
        }
    }
}
