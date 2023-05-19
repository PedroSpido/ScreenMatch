package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.calculos.CalculadoraDeTempo;
import br.com.alura.screenmatch.calculos.FiltroRecomendacao;
import br.com.alura.screenmatch.modelos.Episodio;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        Filme poderosoChefao = new Filme("O poderoso chefão", 1970, true);
        Filme avatar = new Filme("Avatar", 2023, true);
        Filme whipLash = new Filme("Whiplash", 2015, false);
        Serie lost = new Serie("Lost", 2000, false);
        Episodio episodioUmLost = new Episodio("Episodio 1", 1, lost);
        FiltroRecomendacao filtro = new FiltroRecomendacao();

        List<Titulo> listaDeTitulos = new ArrayList<>();
        List<String> buscaPorArtista = new ArrayList<>();
        listaDeTitulos.add(poderosoChefao);
        listaDeTitulos.add(avatar);
        listaDeTitulos.add(whipLash);
        listaDeTitulos.add(lost);

        poderosoChefao.exibeFichaTecnica();
        poderosoChefao.avalia(7);
        poderosoChefao.avalia(6);
        poderosoChefao.avalia(8);
        poderosoChefao.setDuracaoEmMinutos(180);
        System.out.println("Total de avaliações: " + poderosoChefao.getTotalDeAvaliacoes());
        System.out.println("Média do filme: " + poderosoChefao.pegaMediaAvaliacoes());
        System.out.println("Duração em minutos: " + poderosoChefao.getDuracaoEmMinutos());
        filtro.filtro(poderosoChefao);
        System.out.println();

        lost.exibeFichaTecnica();
        lost.setTemporadas(10);
        lost.setEpisodiosPorTemporada(10);
        lost.setMinutosPorEpisodio(50);
        System.out.println("Duração em minutos: " + lost.getDuracaoEmMinutos());
        episodioUmLost.setTotalDeVizualizacoes(400);
        System.out.print(episodioUmLost.getNome() + ": ");
        filtro.filtro(episodioUmLost);
        System.out.println();

        avatar.exibeFichaTecnica();
        avatar.avalia(7);
        avatar.avalia(10);
        avatar.setDuracaoEmMinutos(200);
        System.out.println("Média do filme: " + avatar.pegaMediaAvaliacoes());
        System.out.println("Duração em minutos: " + avatar.getDuracaoEmMinutos());

        System.out.println();
        whipLash.exibeFichaTecnica();
        whipLash.avalia(9);
        whipLash.avalia(10);
        whipLash.setDuracaoEmMinutos(170);
        System.out.println("Média do filme: " + whipLash.pegaMediaAvaliacoes());
        System.out.println("Duração em minutos: " + whipLash.getDuracaoEmMinutos());

        CalculadoraDeTempo calcula = new CalculadoraDeTempo();
        calcula.incluiTitulo(avatar);
        calcula.incluiTitulo(poderosoChefao);
        calcula.incluiTitulo(lost);

        System.out.println();
        System.out.println("Tempo total para maratonar: "+ calcula.getTempoTotal());

        System.out.println();
        for (Titulo titulo : listaDeTitulos) {
            System.out.println(titulo.getNome());
            if(titulo instanceof Filme filme){
                System.out.println("Classificação: " + filme.getClassificacao());
            }
        }

        System.out.println();
        System.out.println("Tamanho da lista: " + listaDeTitulos.size());
        listaDeTitulos.forEach(titulo -> System.out.println(titulo.getNome()));
        System.out.println(listaDeTitulos);

        System.out.println();

        System.out.println();
        Collections.sort(listaDeTitulos);
        System.out.println("Lista organizada por nome: ");
        System.out.println(listaDeTitulos);

        System.out.println();
        listaDeTitulos.sort((titulo1, titulo2) -> titulo1.getAnoDeLancamento()-titulo2.getAnoDeLancamento());
        System.out.println("Lista organizada por ano: ");
        System.out.println(listaDeTitulos);
        
        buscaPorArtista.add("Adam Sandler");
        buscaPorArtista.add("Pedro");
        buscaPorArtista.add("Paulo");
        buscaPorArtista.add("Jaqueline");

        System.out.println();
        System.out.println(buscaPorArtista);

        buscaPorArtista.sort((nome1, nome2) -> nome1.compareTo(nome2));

        System.out.println();
        System.out.println(buscaPorArtista);
    }
}
