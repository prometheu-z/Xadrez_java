package jogo.tabuleiro;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class Peca {
    private int linha;
    private int coluna;
    public String tipo;
    public Pecas pecas;
    ArrayList<Cordenada<Integer, Integer>> alternativas = new ArrayList();



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


    public void setAlternativas(int i, int j) {
        this.alternativas.add(new Cordenada<>(i, j));
    }

    public void setAlternativas() {
        this.alternativas.removeAll(alternativas);
    }

    public void getPosAlternativas(Peca p, boolean cor){
        int x=1;
        if(cor){
            x = -1;
        }
        int linhapos = p.getLinha();
        int colunapos = p.getColuna();
        String t = p.getTipo();

        if(t.equalsIgnoreCase("P")){

            p.setAlternativas(linhapos +x, colunapos);
            p.setAlternativas(linhapos +x, colunapos +1);
            p.setAlternativas(linhapos +x, colunapos -1);

        }
        else if(t.equalsIgnoreCase("B")) {
            int tempL = linhapos;
            int tempC = colunapos;

            for (int i = 1; i <= 8; i++) {
                p.setAlternativas(tempL + i, tempC + i);
                p.setAlternativas(tempL - i, tempC - i);
                p.setAlternativas(tempL + i, tempC - i);
                p.setAlternativas(tempL - i, tempC + i);

            }

        }
        else if(t.equalsIgnoreCase("C")){
            int primeiraPosL = linhapos+2;
            int primeiraPosC = colunapos+1;
            int segundaPosL = linhapos+1;
            int segundaPosC = colunapos+2;

            p.setAlternativas(primeiraPosL, primeiraPosC);
            p.setAlternativas(segundaPosL, segundaPosC);

            p.setAlternativas(primeiraPosL, primeiraPosC-2);
            p.setAlternativas(segundaPosL, segundaPosC-4);

            p.setAlternativas(primeiraPosL-4, primeiraPosC);
            p.setAlternativas(segundaPosL-2, segundaPosC);

            p.setAlternativas(primeiraPosL-4, primeiraPosC-2);
            p.setAlternativas(segundaPosL-2, segundaPosC-4);


        }
        else if(t.equalsIgnoreCase("T")){
            for(int i = 1; i<8;i++){
                p.setAlternativas(linhapos+i,colunapos);
                p.setAlternativas(linhapos-i,colunapos);
                p.setAlternativas(linhapos,colunapos+i);
                p.setAlternativas(linhapos,colunapos-i);
            }
        }
        else if(t.equalsIgnoreCase("D")){
            Peca pTemp = new Peca(linhapos, colunapos);
            pTemp.tipo = "T";
            getPosAlternativas(pTemp, cor);

            p.alternativas.addAll(pTemp.alternativas);

            pTemp.tipo = "B";
            getPosAlternativas(pTemp, cor);

            p.alternativas.addAll(pTemp.alternativas);

        }
        else if(t.equalsIgnoreCase("R")){
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (i == 0 && j == 0) {
                        continue; // Pula a própria casa do Rei
                    }
                    p.setAlternativas(linhapos + i, colunapos + j);
                }
            }
        }
        Predicate<Cordenada<Integer, Integer>> foraDoTabuleiro = c ->
                c.linha < 0 || c.linha >= 8 || c.coluna < 0 || c.coluna >= 8;

        p.alternativas.removeIf(foraDoTabuleiro);
    }



    // Setters e Getters
}
