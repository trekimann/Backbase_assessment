package com.backbase_assessment.backbase_assessment;

import com.backbase_assessment.backbase_assessment.controllers.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.Test;

@AutoConfigureMockMvc
@EnableWebMvc
@SpringBootTest(classes = Controller.class)
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test 
    public void shouldReturnRatingConfirmMessageWhenUserRatedMovie() throws Exception {
        String jsonRequest = "{\"title\":\"Apple\",\"userRating\": \"5\",\"omdbkey\":\"813a7e6a\"}";
        String expectedResponse = "You Rated Apple as 5";
        this.mockMvc
            .perform(post("/oscar")
                .accept(MediaType.APPLICATION_JSON)
                .contentType("application/json")
                .content(jsonRequest))
            .andExpect(status().isOk())
            .andExpect(content()
            .contentType("text/plain"))
            .andExpect(content()
            .string(expectedResponse));
    }
    
}
