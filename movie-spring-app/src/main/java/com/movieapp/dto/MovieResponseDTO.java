package com.movieapp.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class MovieResponseDTO {
    private Long id;
    private String externalId;
    private String title;
    private LocalDate relaseDate;
    private String posterPath;
}
