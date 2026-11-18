package br.edu.mural;

public record Evento(Tipo tipo, String atividade, Double nota) {
    public enum Tipo {
        ATIVIDADE_PUBLICADA, ATIVIDADE_CANCELADA, NOTA_PUBLICADA
    }

    public static Evento publicacao(String atividade) {
        return new Evento(Tipo.ATIVIDADE_PUBLICADA, atividade, null);
    }

    public static Evento cancelamento(String atividade) {
        return new Evento(Tipo.ATIVIDADE_CANCELADA, atividade, null);
    }

    public static Evento avaliacao(String atividade, double nota) {
        return new Evento(Tipo.NOTA_PUBLICADA, atividade, nota);
    }
}
