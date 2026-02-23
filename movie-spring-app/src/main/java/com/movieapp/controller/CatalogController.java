package com.movieapp.controller;

import com.movieapp.dto.ExternalApiMoviePageResponseDTO;
import com.movieapp.service.ExternalMovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/catalog")
public class CatalogController {

    private final ExternalMovieService externalMovieService;

    public CatalogController(ExternalMovieService externalMovieService) {
        this.externalMovieService = externalMovieService;
    }

    @GetMapping("/popular")
    public ResponseEntity<ExternalApiMoviePageResponseDTO> getPopularMovies(
            @RequestParam(defaultValue = "0") int page) {
        return ResponseEntity.ok(externalMovieService.getPopularMovies(page));
    }
}