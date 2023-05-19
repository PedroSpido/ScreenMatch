package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.excecao.ErroDeConversaoDeAnoException;

public abstract class Titulo implements Comparable<Titulo>{
    private String nome;
    private int anoDeLancamento;
    private boolean incluidoNoPlano;
    private double somaAvaliacao;
    private int totalDeAvaliacoes;
    protected int duracaoEmMinutos;

    public Titulo(String nome, int anoDeLancamento, boolean incluidoNoPlano) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public Titulo(TituloOmb tituloOmb) {
        this.nome = tituloOmb.title();

        if(tituloOmb.year().length() > 4){
            throw new ErroDeConversaoDeAnoException("Não foi possível converter o ano com mais " +
                    "de 4 caracteres");
        }
        this.anoDeLancamento = Integer.valueOf(tituloOmb.year());

        if(tituloOmb.runtime().length() <= 6){
            this.duracaoEmMinutos = Integer.valueOf(tituloOmb.runtime().substring(0, 2));
        }else if(tituloOmb.runtime().length() >= 7){
            this.duracaoEmMinutos = Integer.valueOf(tituloOmb.runtime().substring(0, 3));
        }
    }

    public String getNome() {
        return nome;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public abstract int getDuracaoEmMinutos();

    public void exibeFichaTecnica(){
        System.out.println("Nome do titulo: "+ this.nome);
        System.out.println("Ano de lançamento: "+ this.anoDeLancamento);
        System.out.println("Incluído no plano: "+ this.incluidoNoPlano);
    }

    public void avalia(double nota){
        this.somaAvaliacao += nota;
        this.totalDeAvaliacoes++;
    }

    public int getTotalDeAvaliacoes() {
        return totalDeAvaliacoes;
    }

    @Override
    public String toString() {
        return "Filme: " + this.getNome() + ", (Ano de lançamento: " + this.getAnoDeLancamento() + ")" + " (Duração em minutos: " + this.getDuracaoEmMinutos() + ")";
    }

    public double pegaMediaAvaliacoes(){
        return this.somaAvaliacao / this.totalDeAvaliacoes;
    }
}
