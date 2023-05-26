package com.michal.movies.controller;

import com.michal.movies.controller.model.Movie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/movies")
public class MoviesController {

    @PostMapping
    public void createMovie(@RequestBody Movie movie) {
        log.info("I just received: " + movie.toString());
    }
}

