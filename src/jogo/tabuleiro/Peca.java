package jogo.tabuleiro;

import java.util.ArrayList;

public class Peca {
    private int linha;
    private int coluna;
    public String tipo;
    ArrayList<Integer[]> alternativas = new ArrayList();

    // Cada peca do tabuleiro tera um linha e colunas associada a ela, seu tipo e alternativas de movimentação

    public String getTipo() {
        return this.tipo;
    }



    public Peca(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

    public int getColuna() {
        return coluna;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }


    public void setAlternativas(ArrayList<String> alternativas, String pos) {
        alternativas.add(pos);
    }
    public void remAlternativas(ArrayList<String> alternativas, String pos) {
        alternativas.remove(pos);
    }

    // Setters e Getters
}
