package br.edu.placar;

// Placar imutável (record) com os gols de cada time
public record Placar(int golsAzul, int golsVerde) {
    // Texto do placar, ex.: "Azul 1 x 0 Verde"
    @Override
    public String toString() {
        return "Azul " + golsAzul + " x " + golsVerde + " Verde";
    }
}
