package com.movieapp.repository;

import com.movieapp.dto.MovieResponseDTO;
import com.movieapp.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    Optional<Movie> findMovieByTitle(String title);

    Optional<Movie> findByExternalId(String externalId);

}
