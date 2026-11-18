package br.edu.placar;

// Enum dos times; sabe somar o próprio gol no placar
public enum Equipe {
    // Pontos que cada time soma para o Azul e para o Verde
    AZUL(1, 0),
    VERDE(0, 1);

    private final int pontoAzul;
    private final int pontoVerde;

    // Construtor: guarda os pontos de cada time
    Equipe(int pontoAzul, int pontoVerde) {
        this.pontoAzul = pontoAzul;
        this.pontoVerde = pontoVerde;
    }

    // Devolve um placar novo com o gol somado
    public Placar somarGolAo(Placar placar) {
        return new Placar(placar.golsAzul() + pontoAzul, placar.golsVerde() + pontoVerde);
    }
}
