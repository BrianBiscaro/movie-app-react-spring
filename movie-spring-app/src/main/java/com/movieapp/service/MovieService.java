package com.movieapp.service;


import com.movieapp.dto.MovieRequestDTO;
import com.movieapp.dto.MovieResponseDTO;
import com.movieapp.mapper.Mapper;
import com.movieapp.model.Movie;
import com.movieapp.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieService implements IMovieService {

    private final MovieRepository movieRepository;

    @Override
    public List<MovieResponseDTO> get() {
        return movieRepository.findAll()
                .stream()
                .map(Mapper::toDTO)
                .toList();
    }

    @Override
    public MovieResponseDTO get(Long id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(RuntimeException::new);

        return Mapper.toDTO(movie);

    }

    @Override
    public MovieResponseDTO save(MovieRequestDTO movie) {

        Movie newMovie = Mapper.toEntity(movie);

        movieRepository.save(newMovie);

        return Mapper.toDTO(newMovie);
    }

    @Override
    public MovieResponseDTO update(Long id, MovieRequestDTO movie) {

        Movie updatedMovie = movieRepository.findById(id)
                .orElseThrow(RuntimeException::new);

        updatedMovie.setExternalId(movie.getExternalId());
        updatedMovie.setTitle(movie.getTitle());
        updatedMovie.setPoster_path(movie.getPoster_path());
        updatedMovie.setRelease_date(movie.getRelease_date());

        movieRepository.save(updatedMovie);

        return Mapper.toDTO(updatedMovie);
    }

    @Override
    public void delete(Long id) {
         movieRepository.deleteById(id);
    }

}
