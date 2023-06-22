package com.michal.movies.controller;

import com.michal.movies.controller.model.Movie;
import com.michal.movies.repository.MovieRepository;
import com.michal.movies.repository.model.MovieEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MoviesController {

    private final MovieRepository movieRepository;

    @PostMapping
    public void createMovie(@RequestBody Movie movie) {
        log.info("I just received: " + movie.toString());

        MovieEntity movieEntity = MovieEntity.builder()
                .year(movie.getYear())
                .actors(movie.getActors())
                .directors(movie.getDirectors())
                .genre(movie.getGenre())
                .title(movie.getTitle())
                .id(UUID.randomUUID())
                .build();

        movieRepository.save(movieEntity);
    }

    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable("id") Long id) {
        return Movie.builder()
                .year(2000)
                .genre("horror")
                .title("Ciganska rapsodie")
                .actors(List.of("michal mrosko", "michal dord", "stepan kozub"))
                .build();

        // Implementation for retrieving a movie with the given ID
        // Return the retrieved movie object
    }

    @GetMapping
    public List<Movie> getAllMovies() {

        List<Movie> movies = new ArrayList<>();

        for (MovieEntity movieEntity : movieRepository.findAll()) {
            Movie movie = Movie.builder()
                    .year(movieEntity.getYear())
                    .genre(movieEntity.getGenre())
                    .title(movieEntity.getTitle())
                    .actors(movieEntity.getActors())
                    .build();
            movies.add(movie);
        }
        return movies;

    }


    @PutMapping("/{id}")
    public void updateMovie(@PathVariable("id") Long id, @RequestBody Movie updatedMovie) {
        // Implementation for updating a movie with the given ID using the updatedMovie object
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable("id") Long id) {
        // Implementation for deleting a movie with the given ID
    }
}

