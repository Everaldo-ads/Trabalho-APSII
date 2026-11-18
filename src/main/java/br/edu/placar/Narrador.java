package br.edu.placar;

// Observador que narra cada gol no console
public class Narrador implements ObservadorPlacar {
    // Recebe o aviso de gol e imprime o placar
    @Override
    public void atualizar(Placar placar) {
        System.out.println("Gol! " + placar);
    }
}
