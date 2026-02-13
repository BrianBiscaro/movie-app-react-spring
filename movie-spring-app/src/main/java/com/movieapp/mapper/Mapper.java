package com.movieapp.mapper;

import com.movieapp.dto.MovieRequestDTO;
import com.movieapp.dto.MovieResponseDTO;
import com.movieapp.dto.UserRequestDTO;
import com.movieapp.dto.UserResponseDTO;
import com.movieapp.model.Movie;
import com.movieapp.model.User;

public class Mapper {

    public static MovieResponseDTO toDTO(Movie movie){
        return MovieResponseDTO.builder()
                .id(movie.getId())
                .externalId(movie.getExternalId())
                .title(movie.getTitle())
                .poster_path(movie.getPoster_path())
                .relase_date(movie.getRelease_date())
                .build();
    }

    public static UserResponseDTO toDTO(User user){
        return UserResponseDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .username(user.getUsername())
                .email(user.getEmail())
                .build();
    }

    public static Movie toEntity(MovieRequestDTO movie){
        return Movie.builder()
                .title(movie.getTitle())
                .externalId(movie.getExternalId())
                .poster_path(movie.getPoster_path())
                .release_date(movie.getRelease_date())
                .build();
    }

    public static User toEntity(UserRequestDTO user){
        return User.builder()
                .name(user.getName())
                .username(user.getUsername())
                .email(user.getEmail())
                .birthday(user.getBirthday())
                .password(user.getPassword())
                .build();
    }
}
