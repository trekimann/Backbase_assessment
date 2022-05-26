package com.backbase_assessment.backbase_assessment.controllers;

import com.backbase_assessment.backbase_assessment.api.Omdb;
import com.backbase_assessment.backbase_assessment.model.OscarRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

}
