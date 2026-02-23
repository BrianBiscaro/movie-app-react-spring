package com.movieapp.service;

import com.movieapp.dto.ExternalApiMoviePageResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestClient;

public class ExternalMovieService implements IExternalMovieService {

    private final RestClient restClient;
    private final String apiKey;

    public ExternalMovieService(
            RestClient.Builder restClientBuilder,
            @Value("${app.tmdb.url}") String apiUrl,
            @Value("${app.tmdb.key}") String apiKey) {

        this.apiKey = apiKey;
        this.restClient = restClientBuilder.baseUrl(apiUrl).build();
    }

    public ExternalApiMoviePageResponseDTO getPopularMovies(int page) {
        int apiPage = page + 1;

        return restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/movie/popular")
                        .queryParam("api_key", apiKey)
                        .queryParam("language", "es-ES")
                        .queryParam("page", apiPage)
                        .build())
                .retrieve()
                .body(ExternalApiMoviePageResponseDTO.class);
    }
}
