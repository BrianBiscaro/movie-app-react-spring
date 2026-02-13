package com.movieapp.controller;

import com.movieapp.dto.MovieRequestDTO;
import com.movieapp.dto.MovieResponseDTO;
import com.movieapp.model.Movie;
import com.movieapp.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriBuilder;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/movies")
public class MovieController {

    final MovieService movieService;
    @GetMapping
    public ResponseEntity<List<MovieResponseDTO>> getMovies(){
        return ResponseEntity.ok(movieService.get());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieResponseDTO> getMovieById(@PathVariable Long id){
        return ResponseEntity.ok(movieService.get(id));
    }

    @PostMapping("/{id")
    public ResponseEntity<MovieResponseDTO> createMovie(@RequestBody MovieRequestDTO movie){

        MovieResponseDTO createdMovie = movieService.save(movie);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdMovie.getId())
                .toUri();

        return ResponseEntity.created(location)
                .body(createdMovie);
    }

    @PutMapping("/{id")
    public ResponseEntity<MovieResponseDTO> updateMovie(@PathVariable Long id, @RequestBody MovieRequestDTO movie){

        MovieResponseDTO updatedMovie = movieService.update(id, movie);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(updatedMovie.getId())
                .toUri();

        return ResponseEntity.created(location)
                .body(updatedMovie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable Long id){
        movieService.delete(id);
    }

}
