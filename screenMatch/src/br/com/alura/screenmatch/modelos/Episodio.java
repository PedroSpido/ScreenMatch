package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.calculos.Classificavel;

public class Episodio implements Classificavel {
    private String nome;
    private int numero;
    private Serie serie;
    private int totalDeVizualizacoes;

    public Episodio(String nome, int numero, Serie serie) {
        this.nome = nome;
        this.numero = numero;
        this.serie = serie;
    }

    public String getNome() {
        return nome;
    }

    public int getNumero() {
        return numero;
    }

    public Serie getSerie() {
        return serie;
    }

    public int getTotalDeVizualizacoes() {
        return totalDeVizualizacoes;
    }

    public void setTotalDeVizualizacoes(int totalDeVizualizacoes) {
        this.totalDeVizualizacoes = totalDeVizualizacoes;
    }

    @Override
    public int getClassificacao() {
        if(this.getTotalDeVizualizacoes() > 100){
            return 4;
        }else{
            return 2;
        }

    }
}
