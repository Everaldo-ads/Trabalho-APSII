package br.edu.placar;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Partida {
    private final Set<ObservadorPlacar> observadores = new LinkedHashSet<>();
    private Placar placar = new Placar(0, 0);

    public void inscrever(ObservadorPlacar observador) {
        observadores.add(Objects.requireNonNull(observador));
    }

    public void remover(ObservadorPlacar observador) {
        observadores.remove(observador);
    }

    public boolean estaInscrito(ObservadorPlacar observador) {
        return observadores.contains(observador);
    }

    public Placar placarAtual() {
        return placar;
    }

    public void registrarGol(Equipe equipe) {
        Placar novoPlacar = equipe.somarGolAo(placar);
        placar = novoPlacar;
        for (ObservadorPlacar observador : List.copyOf(observadores)) {
            observador.atualizar(novoPlacar);
        }
    }
}
