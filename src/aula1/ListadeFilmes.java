package aula1;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class ListadeFilmes { 
	
	public static void main(String[] args) throws Exception{
		
		// fazer uma conexão HTTP e bucar os top 250 filmes
		
		String url = "https://alura-imdb-api.herokuapp.com/movies";
		URI endereco = URI.create(url);
		var client = HttpClient.newHttpClient();
		var request = HttpRequest.newBuilder(endereco).GET().build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		String body = response.body();
		
		// extrair só os dados que interessam (titulo, poster, cassificação)
		
		var parser = new JsonParser();
		List<Map<String, String>> listaDeFilmes = parser.parse(body);
		
		// exibir e manipular os dados
		
		for (Map<String, String> filme : listaDeFilmes) {
			Object keyt = "title";
			System.out.println(filme.get(keyt));
			Object keyi = "image";
			System.out.println(filme.get(keyi));
			Object keyr = "imDbRating";
			System.out.println(filme.get(keyr));
			System.out.println();
			}
	}
}
