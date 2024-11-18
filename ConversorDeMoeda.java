package br.com.alura.ConversorDeMoeda;


import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConversorDeMoeda {

    private static final String API_URL = "https://v6.exchangerate-api.com/v6/9af4a0f5dd5f57df93f0054f/latest/";

    public static double obterTaxaDeCambio(String de, String para) throws Exception {

        String url_str = API_URL + de;


        URL url = new URL(url_str);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        // Converter a resposta para JSON
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader(request.getInputStream()));
        JsonObject jsonobj = root.getAsJsonObject();

        // Verificar o status do resultado
        String req_result = jsonobj.get("result").getAsString();
        if (!req_result.equals("success")) {
            throw new Exception("Falha ao obter a taxa de câmbio. Resultado: " + req_result);
        }

        // Obter a taxa de conversão da moeda de destino
        JsonObject conversionRates = jsonobj.getAsJsonObject("conversion_rates");
        return conversionRates.get(para).getAsDouble();
    }

    public static double converter(double valor, double taxa) {
        return valor * taxa;
    }
}

