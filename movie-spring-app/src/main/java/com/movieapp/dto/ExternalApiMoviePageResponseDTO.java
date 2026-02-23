package com.movieapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record ExternalApiMoviePageResponseDTO(
        int page,
        @JsonProperty("results") List<ExternalApiMovieDTO> results,
        @JsonProperty("total_pages") int totalPages,
        @JsonProperty("total_results") int totalResults
) {}
