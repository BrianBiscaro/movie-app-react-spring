package com.movieapp.service;

import com.movieapp.dto.MovieRequestDTO;
import com.movieapp.dto.UserRequestDTO;
import com.movieapp.dto.UserResponseDTO;
import java.util.List;
import java.util.Optional;

public interface IUserService {

    List<UserResponseDTO> get();
    UserResponseDTO get(Long id);
    UserResponseDTO save(UserRequestDTO user);
    UserResponseDTO update(Long id, UserRequestDTO user);
    void delete(Long id);
    void addFavoriteMovie(Long userId, MovieRequestDTO movie);

}
