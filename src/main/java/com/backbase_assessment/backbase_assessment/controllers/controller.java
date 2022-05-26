package com.backbase_assessment.backbase_assessment.controllers;

import com.backbase_assessment.backbase_assessment.api.Omdb;
import com.backbase_assessment.backbase_assessment.model.OscarRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    Omdb omdb;

    public Controller(){
        this.omdb = new Omdb();
    }
    
    @GetMapping(path = "/oscar", produces = "application/json")
    public ResponseEntity<String> wonBestPicture(@RequestBody OscarRequest request) {
        return ResponseEntity.ok("Hello World: " + request.getTitle());
    }

    @GetMapping(path = "/top-ten", produces = "application/json")
    public ResponseEntity<String[]> topRated(){
        String[] topTen = new String[10];

        for (int i = 0; i < topTen.length; i++) {
            topTen[i] = "Star Trek "+ (i+1);            
        }

        return ResponseEntity.ok(topTen);
    }

    @PostMapping("/oscar")
    public ResponseEntity<String> rateMovie(@RequestBody OscarRequest request) {
        String response = String.format("You Rated %1$s as %2$s", request.getTitle(), request.getUserRating());
        return ResponseEntity.ok(response);
    }

}
