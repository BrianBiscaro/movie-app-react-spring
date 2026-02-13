package com.movieapp.service;

import com.movieapp.dto.MovieRequestDTO;
import com.movieapp.dto.MovieResponseDTO;

import java.util.List;

public interface IMovieService {

    List<MovieResponseDTO> get();

    MovieResponseDTO get(Long id);

    MovieResponseDTO save(MovieRequestDTO movie);

    MovieResponseDTO update(Long id, MovieRequestDTO movie);

    void delete(Long id);
}
