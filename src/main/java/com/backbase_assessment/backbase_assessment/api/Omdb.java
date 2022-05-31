package com.backbase_assessment.backbase_assessment.api;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.backbase_assessment.backbase_assessment.model.OscarRequest;

import lombok.Getter;

@Getter
public class Omdb {
    
    private String url = "http://www.omdbapi.com/?apikey=";

    public Omdb(){
        // // Load up config to get key
        // Properties prop = new Properties();
        // String fileName = "omdb.config";        
        // try {
        //     FileInputStream fis = new FileInputStream(fileName);
        //     prop.load(fis);
        //     System.out.println(prop.getProperty("omdb.key"));
        // } catch (Exception e) {
        //     // If no key then the application wont work so should do something to prevent the user 
        // }
    }

    public String contactOmdb(OscarRequest request){
        String omdbRequest = this.url + request.getOmdbKey() + "&t=" + request.getTitle().trim().replace(" ", "+");

        if(request.getYear() != null){
            omdbRequest = omdbRequest + "&y=" + request.getYear();
        }

        omdbApiHttpRequest(omdbRequest);

        return omdbRequest;
    }
    
    public void omdbApiHttpRequest(String url){
        try {
            HttpRequest request = HttpRequest.newBuilder(new URI(url))
            .GET()
            .build();

            HttpResponse<String> response = HttpClient
            .newHttpClient()
            .send(request, HttpResponse.BodyHandlers.ofString());



            response.body();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    
}
