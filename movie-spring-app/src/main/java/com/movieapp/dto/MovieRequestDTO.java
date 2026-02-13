package com.movieapp.dto;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class MovieRequestDTO {
    private String externalId;
    private String title;
    private LocalDate release_date;
    private String poster_path;
}
