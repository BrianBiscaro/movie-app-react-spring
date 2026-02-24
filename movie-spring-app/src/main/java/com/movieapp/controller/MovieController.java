package com.movieapp.controller;

import com.movieapp.dto.MovieRequestDTO;
import com.movieapp.dto.MovieResponseDTO;
import com.movieapp.model.Movie;
import com.movieapp.service.IMovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/movies")
public class MovieController {

    final IMovieService movieService;

    @GetMapping
    public ResponseEntity<Page<MovieResponseDTO>> getMovies(Pageable pageable) {
        return ResponseEntity.ok(movieService.getMovies(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieResponseDTO> getMovieById(@PathVariable Long id){
        return ResponseEntity.ok(movieService.getMovie(id));
    }

    @PostMapping("/{id}")
    public ResponseEntity<MovieResponseDTO> createMovie(@RequestBody MovieRequestDTO movie){

        MovieResponseDTO createdMovie = movieService.saveMovie(movie);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdMovie.getId())
                .toUri();

        return ResponseEntity.created(location)
                .body(createdMovie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieResponseDTO> updateMovie(@PathVariable Long id, @RequestBody MovieRequestDTO movie){

            MovieResponseDTO updatedMovie = movieService.updateMovie(id, movie);

            return ResponseEntity.ok(updatedMovie);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {

        movieService.deleteMovie(id);

        return ResponseEntity.noContent().build();
    }
}
