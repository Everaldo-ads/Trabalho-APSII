package br.edu.placar;

public enum Equipe {
    AZUL(1, 0),
    VERDE(0, 1);

    private final int pontoAzul;
    private final int pontoVerde;

    Equipe(int pontoAzul, int pontoVerde) {
        this.pontoAzul = pontoAzul;
        this.pontoVerde = pontoVerde;
    }

    public Placar somarGolAo(Placar placar) {
        return new Placar(placar.golsAzul() + pontoAzul, placar.golsVerde() + pontoVerde);
    }
}
