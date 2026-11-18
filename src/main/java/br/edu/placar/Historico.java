package br.edu.placar;

import java.util.ArrayList;
import java.util.List;

// Observador que guarda o placar de cada gol
public class Historico implements ObservadorPlacar {
    // Lista dos placares, na ordem dos gols
    private final List<Placar> registros = new ArrayList<>();

    // Recebe o aviso de gol e guarda o placar
    @Override
    public void atualizar(Placar placar) {
        registros.add(placar);
    }

    // Devolve uma cópia da lista para consulta
    public List<Placar> registros() {
        return List.copyOf(registros);
    }
}
