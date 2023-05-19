package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.excecao.ErroDeConversaoDeAnoException;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner leitura = new Scanner(System.in);
        List<Titulo> listaDeFilmes = new ArrayList<>();
        String nome = "";
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();

        while(!nome.equalsIgnoreCase("sair")){

            System.out.println("Digite o nome de um filme: ");
            nome = leitura.nextLine();

            if(nome.equalsIgnoreCase("sair")){
                break;
            }

            String endereco = "http://www.omdbapi.com/?t=" + nome.replace(" ", "+") + "&i=tt3896198&apikey=bed58c5f";
            try{
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco))
                        .build();

                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                System.out.println(json);
                System.out.println();

                TituloOmb tituloOmb = gson.fromJson(json, TituloOmb.class);
                Titulo titulo = new Filme(tituloOmb);
                System.out.println(titulo);

                listaDeFilmes.add(titulo);


            } catch(NumberFormatException ex){
                System.out.println("Ocorreu um erro no formato do numero!");
                System.out.println(ex.getMessage());
            } catch(IllegalArgumentException ex) {
                System.out.println("Ocorreu um erro no argumento da busca!");
                System.out.println(ex.getMessage());
            } catch(ErroDeConversaoDeAnoException ex) {
                System.out.println(ex.getMessage());
            } catch(NullPointerException ex) {
                System.out.println("Esse filme não existe no sistema de busca");
                System.out.println(ex.getMessage());
            }finally {
                System.out.println("Programa finalizado!");
            }
        }

        System.out.println(listaDeFilmes);
        FileWriter escrita = new FileWriter("listaDeFilmes.txt");
        String toJson = gson.toJson(listaDeFilmes);
        escrita.write(toJson);
        escrita.close();

    }
}
