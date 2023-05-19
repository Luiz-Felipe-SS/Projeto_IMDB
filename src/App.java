import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        System.out.println("============");
        System.out.println("============");
        System.out.println("============");
        System.out.println("============");


        // Fazer auma conexao HTTP e buscar os top 250 filmes
        // Aqui conectei com jeson via HTTP e peguei todas as informações do arquivo 
        String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        URI endereco = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        System.out.println(body);

        //extrair so os dados que interessam (titulo, poster, classificação)
        JasonParse parser = new JasonParse();
        List<Map<String, String>> ListaFilmes = parser.parse(body);

       
        

        //exibir e manipular os dados
        System.out.println(ListaFilmes.size());
        System.out.println(ListaFilmes.get(0));

        for (Map<String,String> film : ListaFilmes) {
           System.out.println(film.get("title")); 
           System.out.println(film.get("image")); 
           System.out.println(film.get("imDbRating")); 
           System.out.println("");
        }



    }
}
