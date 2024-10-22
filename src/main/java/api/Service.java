package api;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dto.CodesDto;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class Service {
    //private  HttpClient httpClient;
    //private HttpRequest httpRequest;

    public static ArrayList<String> getSupportedCodes()  {
        String url="https://v6.exchangerate-api.com/v6/6b01bc1ff1fbfe893889c714/codes";
        ArrayList<String> codes = new ArrayList<>();
        try{
        HttpClient httpClient = HttpClient.newHttpClient();
     HttpRequest httpRequest = HttpRequest.newBuilder()
              .uri(URI.create(url))
              .build();
        HttpResponse<String> response= httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        Gson gson = new Gson();
            CodesDto codesDto= gson.fromJson(response.body(),CodesDto.class);
           for(List<String> pairs:codesDto.supported_codes()){
                 codes.add(pairs.get(0));
           }
        }catch (InterruptedException | IOException e){
            System.out.println("ocurrio un error al obtener los codes soportados");
            System.out.println(e.getMessage());
        }
        return codes;

    }
    public static double getRateConvertion(String base, String target){
        String url_str="https://v6.exchangerate-api.com/v6/6b01bc1ff1fbfe893889c714/pair/"+base+"/"+target;
        double  rate=0;
        try {
            URL url = new URL(url_str);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

            // Convert to JSON
            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            JsonObject jsonObj = root.getAsJsonObject();

         // Accessing object

            rate= jsonObj.get("conversion_rate").getAsDouble();
        }catch (IOException  e){
            System.out.println("Ocurrio un error al obtener la tasa de conversion");
            e.printStackTrace();
        }
        return rate;
    }
}
