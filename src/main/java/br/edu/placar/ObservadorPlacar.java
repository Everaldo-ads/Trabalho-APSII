package br.edu.placar;

// Interface do Observer: quem quer ser avisado de um gol implementa esta
@FunctionalInterface
public interface ObservadorPlacar {
    // Chamado pela Partida a cada gol, com o novo placar
    void atualizar(Placar placar);
}
