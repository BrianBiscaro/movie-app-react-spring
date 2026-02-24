package com.movieapp.service;

import com.movieapp.dto.MovieRequestDTO;
import com.movieapp.dto.UserRequestDTO;
import com.movieapp.dto.UserResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IUserService {

    Page<UserResponseDTO> getUsers(Pageable pageable);
    UserResponseDTO getUser(Long id);
    UserResponseDTO updateUser(Long id, UserRequestDTO user);
    void deleteUser(Long id);
    void addFavoriteMovie(Long userId, MovieRequestDTO movie);
    void deleteFavoriteMovie(Long userId, String movieExternalID);
}
