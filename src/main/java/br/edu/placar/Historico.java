package br.edu.placar;

import java.util.ArrayList;
import java.util.List;

public class Historico implements ObservadorPlacar {
    private final List<Placar> registros = new ArrayList<>();

    @Override
    public void atualizar(Placar placar) {
        registros.add(placar);
    }

    public List<Placar> registros() {
        return List.copyOf(registros);
    }
}
