package com.movieapp.service;

import com.movieapp.dto.ExternalApiMoviePageResponseDTO;

public interface IExternalMovieService {

    ExternalApiMoviePageResponseDTO getPopularMovies(int page);


}
