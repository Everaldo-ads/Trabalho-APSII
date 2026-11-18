package br.edu.placar;

public class Narrador implements ObservadorPlacar {
    @Override
    public void atualizar(Placar placar) {
        System.out.println("Gol! " + placar);
    }
}
