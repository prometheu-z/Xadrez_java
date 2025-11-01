package jogo.tabuleiro;

public class Tabuleiro {
    protected int tamanho = 8;
    private int[][] tabuleiro = new int[tamanho][tamanho];


    public int getTamanho() {
        return tamanho;
    }

    public Tabuleiro(int tamanho) {
        this.tamanho = tamanho;

    }
    public void mostrartabuleiro(){
        System.out.print("  a  b  c  d  e  f  g  h");
        for (int i = 0; i< getTamanho(); i++){
            for (int j = 0; j<getTamanho(); j++){
                System.out.print(8-i);
                System.out.print("["+tabuleiro[i][j]+"] ");
            }
        }
    }
}
