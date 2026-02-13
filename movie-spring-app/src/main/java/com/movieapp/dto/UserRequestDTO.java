package com.movieapp.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class UserRequestDTO {
    private String username;
    private String name;
    private String password;
    private String email;
    private LocalDate birthday;
}
