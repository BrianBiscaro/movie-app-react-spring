package com.movieapp.dto;

import lombok.Builder;

@Builder
public class UserResponseDTO {
    private Long id;
    private String name;
    private String username;
    private String email;
}
