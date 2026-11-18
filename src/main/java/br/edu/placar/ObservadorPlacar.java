package br.edu.placar;

@FunctionalInterface
public interface ObservadorPlacar {
    void atualizar(Placar placar);
}
