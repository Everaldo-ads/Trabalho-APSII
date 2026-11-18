package br.edu.mural;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Professor {
    private final Set<Observador> inscritos = new LinkedHashSet<>();
    private final Set<String> atividades = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

    public boolean inscrever(Observador observador) {
        if (!inscritos.add(observador)) return false;
        for (String atividade : atividades) {
            observador.update(Evento.publicacao(atividade));
        }
        return true;
    }

    public boolean cancelarInscricao(Observador observador) {
        return inscritos.remove(observador);
    }

    public boolean publicarAtividade(String titulo) {
        if (!atividades.add(titulo)) return false;
        notificarTodos(Evento.publicacao(titulo));
        return true;
    }

    public boolean cancelarAtividade(String titulo) {
        if (!atividades.remove(titulo)) return false;
        notificarTodos(Evento.cancelamento(titulo));
        return true;
    }

    public boolean publicarNota(Observador destinatario, String titulo, double nota) {
        if (!inscritos.contains(destinatario) || !atividades.contains(titulo)) return false;
        if (!Double.isFinite(nota) || nota < 0 || nota > 10) return false;
        destinatario.update(Evento.avaliacao(titulo, nota));
        return true;
    }

    private void notificarTodos(Evento evento) {
        for (Observador observador : inscritos) {
            observador.update(evento);
        }
    }
}
