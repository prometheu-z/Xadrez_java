package jogo.tabuleiro;

import java.util.Arrays;
import java.util.Locale;

public class Pecas {
    public boolean cor;
    public String[] tipo;
    public String[] pecas = {"P", "T", "C", "B", "D", "R"};

    public Pecas(boolean cor) {
        this.cor = cor;
        tipo = new String[16];
        int c = 0;
        for (String p : pecas){
            if(!this.cor){
                Arrays.setAll(pecas,i -> pecas[i].toLowerCase());
            }

            if(p.equalsIgnoreCase("p")){
                for (int i = 0; i<8; i++){
                    tipo[i] = p;
                }
            }
            else {
                tipo[c+8] = p;
                if(c < 4){
                    tipo[15-c] = p;
                }
                c++;
            }

        }
    }
}
