package jogo.tabuleiro;

import java.util.Arrays;

public class Tabuleiro {
    protected int tamanho = 8;
    private String[][] tabuleiro;
    Pecas b = new Pecas(true);
    Pecas p = new Pecas(false);


    public Tabuleiro() {
        tabuleiro = new String[getTamanho()][getTamanho()];
        for (String[] linha : tabuleiro) {
            Arrays.fill(linha, " ");
        }
        for (int i = 0; i< 8; i++){
            tabuleiro[6][i] = b.tipo[i];
            tabuleiro[7][i] = b.tipo[i+8];
            tabuleiro[1][i] = p.tipo[i];
            tabuleiro[0][i] = p.tipo[i+8];
        }

    }

    public int getTamanho() {
        return tamanho;
    }


    public void mostrarTabuleiro(){

        for (int i = 0; i< getTamanho(); i++){
            System.out.print(8-i+"  ");
            for (int j = 0; j<getTamanho(); j++){
                System.out.print("["+tabuleiro[i][j]+"] ");
            }
            System.out.println();
        }
        System.out.print("    a   b   c   d   e   f   g   h");
        System.out.println();

    }




}
