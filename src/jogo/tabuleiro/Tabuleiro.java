package jogo.tabuleiro;

import java.util.Arrays;
import java.util.HashMap;

public class Tabuleiro {
    protected int tamanho = 8;
    protected String[] linhas = {"A","B","C","D","E","F","G","H"};
    private final String[][] tabuleiro;


    Pecas b = new Pecas(true);
    Pecas p = new Pecas(false);



    public Tabuleiro() {
        tabuleiro = new String[getTamanho()][getTamanho()];
        for (String[] linha : tabuleiro) {
            Arrays.fill(linha, " ");
        }
        for (int i = 0; i< 8; i++){
            tabuleiro[6][i] = b.getPecaTipo(i);
            tabuleiro[7][i] = b.getPecaTipo(i+8);

            tabuleiro[1][i] = p.getPecaTipo(i);
            tabuleiro[0][i] = p.getPecaTipo(i+8);
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

    public void moverPeca(String pecaPos){
        pecaPos = pecaPos.substring(1);
        int c = 0;
        for (String n : linhas){
            if( pecaPos.substring(0,1).toUpperCase().equals(n)){
                c++;
            }
        }



    }




}
