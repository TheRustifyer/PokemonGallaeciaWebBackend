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

    public HttpResponse<String> makeGetRequest(String url) throws Exception {

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url))
                .setHeader("User-Agent", USER_AGENT) // request header
                .build();

        HttpResponse<String> response = getHttpClient().send(request, HttpResponse.BodyHandlers.ofString());


        System.out.println("\nGET request to URL: " + url);

        System.out.println("Response Code: " + response.statusCode());

        System.out.println(response.body() + "\n");

        System.out.println("*** END of Http GET request ***");
        // Still on implementation

        return response;
    }

    public HttpResponse<String> makePostRequest(String url) throws Exception {

        String urlParameters = "";
        // String urlParameters = "param1=a&param2=b&param3=c";
 
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

        return response;
    }

}
