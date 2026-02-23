package com.movieapp.service;

import com.movieapp.dto.MovieRequestDTO;
import com.movieapp.dto.MovieResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IMovieService {

    List<MovieResponseDTO> get();

    Page<MovieResponseDTO> getMovies(Pageable pageable);
    MovieResponseDTO get(Long id);

    MovieResponseDTO save(MovieRequestDTO movie);

    MovieResponseDTO update(Long id, MovieRequestDTO movie);

    void delete(Long id);
}
