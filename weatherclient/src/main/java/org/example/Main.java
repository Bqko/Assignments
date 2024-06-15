package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;
import java.util.Scanner;

public class Main {

    private static final String WEATHER_API_KEY = "570b637a9ad722710ab6510f73db4d27";  // Replace with your OpenWeatherMap API key
    private static final String WEATHER_BASE_URL = "http://api.openweathermap.org/data/2.5/weather";
    private static final String EXCHANGE_API_KEY = "027ab873a4fc5382724addfd"; // Replace with your Exchange Rate API key
    private static final String EXCHANGE_BASE_URL = "https://v6.exchangerate-api.com/v6";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello! I'm your weather and exchange rate chatbot. Ask me about the weather today.");
        System.out.print("Enter city name: ");
        String cityName = scanner.nextLine();

        String weather = getWeather(cityName);
        System.out.println("Weather in " + cityName + ": " + weather);

        double exchangeRate = getExchangeRate("USD", "GEL");
        System.out.println("Exchange rate (USD to GEL): " + exchangeRate);
    }

    private static String getWeather(String cityName) {
        String urlString = WEATHER_BASE_URL + "?q=" + cityName + "&appid=" + WEATHER_API_KEY + "&units=metric";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlString))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JSONObject jsonResponse = new JSONObject(response.body());

            if (jsonResponse.getInt("cod") == 200) {
                JSONObject main = jsonResponse.getJSONObject("main");
                double temperature = main.getDouble("temp");
                return "Temperature: " + temperature + "°C";
            } else {
                return "City not found.";
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return "Error fetching weather data.";
        }
    }

    private static double getExchangeRate(String fromCurrency, String toCurrency) {
        String urlString = EXCHANGE_BASE_URL + "/" + EXCHANGE_API_KEY + "/latest/" + fromCurrency;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlString))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JSONObject jsonResponse = new JSONObject(response.body());

            if (jsonResponse.getString("result").equals("success")) {
                return jsonResponse.getJSONObject("conversion_rates").getDouble(toCurrency);
            } else {
                return -1; // Indicate an error in fetching the exchange rate
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return -1; // Indicate an error in fetching the exchange rate
        }
    }
}
