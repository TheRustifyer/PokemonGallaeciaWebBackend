package com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.utils;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class Networking {
    
    private final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.108 Safari/537.36";

    private HttpClient getHttpClient() {
        return HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build();
    }

    public void makeGetRequest() throws Exception {

        System.out.println("*** Http GET request ***");

        String url = "https://api.openweathermap.org/data/2.5/weather?q=santiago%20de%20compostela,es&lang=es&appid=";
        String secretKey = "14c1ede1b48a18e153a2880b372494c6";
        
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url + secretKey))
                .setHeader("User-Agent", USER_AGENT) // request header
                .build();

        HttpResponse<String> response = getHttpClient().send(request, HttpResponse.BodyHandlers.ofString());


        System.out.println("\nGET request to URL: " + url);

        System.out.println("Response Code: " + response.statusCode());

        System.out.println(response.body() + "\n");

        System.out.println("*** END of Http GET request ***");

    }

    public void makePostRequest() throws Exception {

        System.out.println("*** Http POST request ***");

        String url = "https://www.onlinefreeconverter.com/test/post";

        String urlParameters = "param1=a&param2=b&param3=c";

 
        HttpRequest request = HttpRequest.newBuilder()

                .POST(HttpRequest.BodyPublishers.ofString(urlParameters))

                .uri(URI.create(url))

                .setHeader("User-Agent", USER_AGENT) // request header

                .header("Content-Type", "application/x-www-form-urlencoded")

                .build();

 

        HttpResponse<String> response = getHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

 

        System.out.println("\nPOST request to URL: " + url);

        System.out.println("Post Parameters: " + urlParameters);

        System.out.println("Response Code: " + response.statusCode());

        System.out.println(response.body() + "\n");

        System.out.println("*** END of Http POST request ***");

    }

}
