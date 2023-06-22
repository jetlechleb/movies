package com.michal.movies.controller.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Movie {

    private Long id;
    private String title;
    private List<String> directors;
    private List<String> actors;
    private String genre;
    private Integer year;
}


