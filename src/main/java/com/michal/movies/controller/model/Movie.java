package com.michal.movies.controller.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class Movie {

    private String title;
    private List<String> directors;
    private List<String> actors;
    private String genre;
    private Integer year;
}


