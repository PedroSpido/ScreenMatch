package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.calculos.Classificavel;

public class Filme extends Titulo implements Classificavel {
    private String diretor;

    public Filme(String nome, int anoDeLancamento, boolean incluidoNoPlano) {
        super(nome, anoDeLancamento, incluidoNoPlano);
    }

    public Filme(TituloOmb tituloOmb) {
        super(tituloOmb);
    }

    @Override
    public int getDuracaoEmMinutos() {
        return this.duracaoEmMinutos;
    }

    @Override
    public int getClassificacao() {
        return (int) (super.pegaMediaAvaliacoes() / 2);
    }

    @Override
    public int compareTo(Titulo filme) {
        return this.getNome().compareTo(filme.getNome());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
