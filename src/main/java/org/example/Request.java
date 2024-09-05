package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Request {
    private final String BASE_URL = "https://bbs-api-os.hoyolab.com/game_record/hkrpg/api";
    private final String ENDPOINT = "/note?server=prod_official_usa&role_id=SEU_ID";
    private final HttpClient CLIENTE;
    private static final String WEBHOOK_URL = "https://discord.com/api/webhooks/1277804599155363850/f5Jcl7czofSBlUVNxluCiYAVuOEkYv4WN9i9IqSmNP7OZfCDucPc0oHgGUTHF3OnHy4a";

    public Request(){
        CLIENTE = HttpClient.newHttpClient();
    }

    public String sendRequest() throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + ENDPOINT))
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/127.0.0.0 Safari/537.36")
                .header("Cookie", "Seu-Cookie")
                .header("X-Rpc-App_version", "1.5.0")
                .header("X-Rpc-Client_type", "5")
                .header("X-Rpc-Language", "pt-pt")
                .header("Ds", "1724773688,PziJsi,d4c96bf318ce355681c9d7dc338d53ec")
                .GET()
                .build();

        return CLIENTE.send(request, HttpResponse.BodyHandlers.ofString()).body();
    }
    public ApiResponse parseResponse(String jsonResponse) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(jsonResponse, ApiResponse.class);
    }

    public static void sendToWebhook(String message) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        JsonObject json = new JsonObject();
        json.addProperty("content", message);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(WEBHOOK_URL))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json.toString()))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 204) {
            System.out.println("Mensagem enviada com sucesso para o webhook do Discord!");
        } else {
            System.out.println("Falha ao enviar mensagem. Código de status: " + response.statusCode());
            System.out.println("Resposta do servidor: " + response.body());
        }
    }
}




