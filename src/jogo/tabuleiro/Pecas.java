package jogo.tabuleiro;

import java.util.Arrays;

public class Pecas {
    public Peca[] peca;
    public boolean cor;
    public String[] pecas = {"P", "T", "C", "B", "D", "R"};

    // Cada conjunto de Peças (preto ou branco) terá 16 peças distintas uma cor e o tipo de cada peca no conjunto


    public String getPecaTipo(int i, int j) {
        for (Peca p : this.peca){
            if(p.getLinha() == i && p.getColuna() == j){
                return p.getTipo();
            }
        }
        return " ";
    }

    // Função pra retornar o tipo de uma peça no conjunto

    public Pecas(boolean cor) {
        this.peca = new Peca[16];
        this.cor = cor;
        if(!this.cor){
            Arrays.setAll(pecas,i -> this.pecas[i].toLowerCase());
            for (int i = 0; i < 16; i++) {
                if(i<8){
                    this.peca[i] = new Peca(1, i);
                }
                else {
                    this.peca[i] = new Peca(0, i-8);
                }
            }
        }
        else{
            for (int i = 0; i < 16; i++) {
                if(i<8){
                    this.peca[i] = new Peca(6, i);
                }
                else {
                    this.peca[i] = new Peca(7, i-8);
                }
            }
        }
        int c = 0;

        // É instanciado um vetor de 16 peças na memoria, e cada uma é instanciada com uma posição

        for (String p : pecas){

            if(p.equalsIgnoreCase("p")){
                for (int i = 0; i<8; i++){
                    this.peca[i].tipo = p;
                    this.peca[i].setAlternativas();

                }
            }
            else {
                this.peca[c+8].tipo = p;
                if(c < 4){
                    this.peca[15-c].tipo = p;
                }
                c++;
            }
            // É colocado noo vetor as peças em suas respectivas posições 0-7 peoes, seguido de T, C, B, D, R, B, C, T
        }
    }

    // definir movimentação:

    //    (Peça)(destino)     ex: Pd4, Th5
    //    (Peça)(captura)(destino)    ex:  Pxe5   txa8
    //    (peça)(destino)(cheque) e (peça)(destino)(mate)    ex: Cxf6+  e Dh5#
    //    roques      ex: 0-0 ou 0-0-0

    //    casos especiais e promoções
    //    caso haja torres ou damas em mesma linha, bispos em mesma diagonal, cavalos com destinos em comum


}
