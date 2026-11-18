package br.edu.mural;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Aluno implements Observador {
    private final String nome;
    private final Set<String> pendencias = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
    private final Map<String, Double> historico = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    public Aluno(String nome) {
        this.nome = nome;
    }

    @Override
    public void update(Evento evento) {
        String atividade = evento.atividade();
        switch (evento.tipo()) {
            case ATIVIDADE_PUBLICADA -> {
                if (!historico.containsKey(atividade)) {
                    pendencias.add(atividade);
                }
            }
            case ATIVIDADE_CANCELADA -> {
                pendencias.remove(atividade);
                historico.remove(atividade);
            }
            case NOTA_PUBLICADA -> {
                historico.put(atividade, evento.nota());
                pendencias.remove(atividade);
            }
        }
    }

    public void mostrarSituacao() {
        System.out.println("Aluno: " + nome);
        System.out.println("Pendências: " + (pendencias.isEmpty() ? "nenhuma" : String.join(", ", pendencias)));
        System.out.println("Histórico de notas:");
        if (historico.isEmpty()) {
            System.out.println("  Nenhuma nota publicada.");
        }
        historico.forEach((atividade, nota) -> System.out.println("  " + atividade + " - " + nota));
    }
}
