package jogo.tabuleiro;

import java.util.Arrays;

public class Tabuleiro {
    protected int tamanho = 8;
    protected String[] colunas = {"A","B","C","D","E","F","G","H"};
    private final String[][] tabuleiro;

    // Cada tabuleiro terá um tamanho pre definido e suas colunas, e a instancia de sua matriz



    Pecas b = new Pecas(true);
    Pecas p = new Pecas(false);
    // É tambem criado peças  brancas e pretas



    public Tabuleiro() {
        tabuleiro = new String[getTamanho()][getTamanho()];
        for (String[] linha : tabuleiro) {
            Arrays.fill(linha, " ");
        }
        for (int i = 0; i< 8; i++){
            tabuleiro[6][i] = b.getPecaTipo(6,i);
            tabuleiro[7][i] = b.getPecaTipo(7,i);

            tabuleiro[1][i] = p.getPecaTipo(1,i);
            tabuleiro[0][i] = p.getPecaTipo(0,i);
        }

        // O construtor gera a matriz na memória e o preenche com espaços vazios e adiciona nos respectivos locais suas peças

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

    // Funçao para exibirr o tabuleiro





}
