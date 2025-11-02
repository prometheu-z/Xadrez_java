package jogo.tabuleiro;

import java.util.ArrayList;

public class Peca {
    private int linha;
    private int coluna;
    public String tipo;
    ArrayList<String> alternativas = new ArrayList();

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

    public ArrayList<String> getAlternativas() {
        return alternativas;
    }

    public void setAlternativas(ArrayList<String> alternativas, String pos) {
        alternativas.add(pos);
    }
    public void remAlternativas(ArrayList<String> alternativas, String pos) {
        alternativas.remove(pos);
    }
}
