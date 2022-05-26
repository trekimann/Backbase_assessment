package com.backbase_assessment.backbase_assessment.api;

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

        return omdbRequest;
    }
    
}
