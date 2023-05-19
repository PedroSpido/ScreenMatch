package br.com.alura.screenmatch.calculos;

public class FiltroRecomendacao {

    public void filtro(Classificavel classificavel){
        if(classificavel.getClassificacao() >= 4){
            System.out.println("Está entre os preferidos do momento");
        }else if(classificavel.getClassificacao() >= 2){
            System.out.println("Muito bem avaliado no momento");
        }else{
            System.out.println("Adicione na sua lista para assistir mais tarde");
        }
    }
}
