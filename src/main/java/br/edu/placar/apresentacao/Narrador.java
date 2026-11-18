package br.edu.placar.apresentacao;

import br.edu.placar.ObservadorPlacar;
import br.edu.placar.Placar;

// Observador que narra cada gol no console
public class Narrador implements ObservadorPlacar {
    // Recebe o aviso de gol e imprime o placar
    @Override
    public void atualizar(Placar placar) {
        System.out.println("Gol! " + placar);
    }
}
