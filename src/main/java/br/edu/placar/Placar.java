package br.edu.placar;

public record Placar(int golsAzul, int golsVerde) {
    @Override
    public String toString() {
        return "Azul " + golsAzul + " x " + golsVerde + " Verde";
    }
}
