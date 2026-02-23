package com.movieapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ExternalApiMovieDTO(
        Long id,
        String title,
        @JsonProperty("overview") String description,
        @JsonProperty("release_date") String releaseDate,
        @JsonProperty("poster_path") String posterPath
) {}

