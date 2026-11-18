package br.edu.placar;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

// Objeto observado (Subject): guarda o placar e avisa os inscritos a cada gol
public class Partida {
    // Observadores inscritos (sem repetição, na ordem de entrada)
    private final Set<ObservadorPlacar> observadores = new LinkedHashSet<>();
    // Placar atual, começa 0 x 0
    private Placar placar = new Placar(0, 0);

    // Inscreve um observador
    public void inscrever(ObservadorPlacar observador) {
        observadores.add(Objects.requireNonNull(observador));
    }

    // Remove a inscrição de um observador
    public void remover(ObservadorPlacar observador) {
        observadores.remove(observador);
    }

    // Diz se o observador está inscrito
    public boolean estaInscrito(ObservadorPlacar observador) {
        return observadores.contains(observador);
    }

    // Devolve o placar atual
    public Placar placarAtual() {
        return placar;
    }

    // Registra o gol e notifica os observadores
    public void registrarGol(Equipe equipe) {
        // Calcula e guarda o novo placar
        Placar novoPlacar = equipe.somarGolAo(placar);
        placar = novoPlacar;

        // Avisa cada observador (sobre uma cópia da lista)
        for (ObservadorPlacar observador : List.copyOf(observadores)) {
            observador.atualizar(novoPlacar);
        }
    }
}
