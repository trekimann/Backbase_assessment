package com.backbase_assessment.backbase_assessment.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class OscarRequest {
    
    @JsonProperty("title")
    private String title;

    @JsonProperty("omdbkey")
    private String omdbKey;

    @JsonProperty("userRating")
    private int userRating;
}
