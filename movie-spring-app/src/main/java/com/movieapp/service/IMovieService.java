package com.movieapp.service;

import com.movieapp.dto.MovieRequestDTO;
import com.movieapp.dto.MovieResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IMovieService {

    Page<MovieResponseDTO> getMovies(Pageable pageable);
    MovieResponseDTO getMovie(Long id);
    MovieResponseDTO saveMovie(MovieRequestDTO movie);
    MovieResponseDTO updateMovie(Long id, MovieRequestDTO movie);
    void deleteMovie(Long id);
}
