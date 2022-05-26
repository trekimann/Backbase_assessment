package com.backbase_assessment.backbase_assessment.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor
@Getter
public class OscarRequest {
    
    @NonNull
    @JsonProperty("title")
    private String title;

    @JsonProperty("omdbkey")
    private String omdbKey;

    @JsonProperty("userRating")
    private Integer userRating;

    @JsonProperty("year")
    private Integer year;
}
