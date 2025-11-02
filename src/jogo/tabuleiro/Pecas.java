package jogo.tabuleiro;

import java.util.Arrays;

public class Pecas {
    public Peca[] peca;
    public boolean cor;
    public String[] pecas = {"P", "T", "C", "B", "D", "R"};


    public String getPecaTipo(int i) {
        return this.peca[i].tipo;
    }

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
                    this.peca[i] = new Peca(0, i);
                }

            }
        }
        else{
            for (int i = 0; i < 16; i++) {
                if(i<8){
                    this.peca[i] = new Peca(6, i);
                }
                else {
                    this.peca[i] = new Peca(7, i);
                }
            }
        }
        int c = 0;

        for (String p : pecas){

            if(p.equalsIgnoreCase("p")){
                for (int i = 0; i<8; i++){
                    this.peca[i].tipo = p;

                }
            }
            else {
                this.peca[c+8].tipo = p;
                if(c < 4){
                    this.peca[15-c].tipo = p;
                }
                c++;
            }

        }

    }
}
