package br.com.alura.screenmatch.modelos;

public class Serie extends Titulo{
    private int temporadas;
    private int episodiosPorTemporada;
    private boolean ativa;
    private int minutosPorEpisodio;

    public Serie(String nome, int anoDeLancamento, boolean incluidoNoPlano) {
        super(nome, anoDeLancamento, incluidoNoPlano);
    }

    public Serie(TituloOmb tituloOmb) {
        super(tituloOmb);
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public int getEpisodiosPorTemporada() {
        return episodiosPorTemporada;
    }

    public void setEpisodiosPorTemporada(int episodiosPorTemporada) {
        this.episodiosPorTemporada = episodiosPorTemporada;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public int getMinutosPorEpisodio() {
        return minutosPorEpisodio;
    }

    public void setMinutosPorEpisodio(int minutosPorEpisodio) {
        this.minutosPorEpisodio = minutosPorEpisodio;
    }

    @Override
    public int getDuracaoEmMinutos() {
        return this.temporadas * this.episodiosPorTemporada * this.minutosPorEpisodio;
    }

    @Override
    public int compareTo(Titulo serie) {
        return this.getNome().compareTo(serie.getNome());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
