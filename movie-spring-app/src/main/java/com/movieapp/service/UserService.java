package com.movieapp.service;

import com.movieapp.dto.MovieRequestDTO;
import com.movieapp.dto.UserRequestDTO;
import com.movieapp.dto.UserResponseDTO;
import com.movieapp.mapper.Mapper;
import com.movieapp.model.Movie;
import com.movieapp.model.User;
import com.movieapp.repository.MovieRepository;
import com.movieapp.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final UserRepository userRepository;
    private final MovieRepository movieRepository;

    @Override
    public Page<UserResponseDTO> getUsers(Pageable pageable) {
        return userRepository.findAll(pageable)
                .map(Mapper::toDTO);
    }

    @Override
    public UserResponseDTO getUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(RuntimeException::new);

        return Mapper.toDTO(user);
    }


    @Override
    @Transactional
    public UserResponseDTO updateUser(Long id, UserRequestDTO user) {

        User userEntity = userRepository.findById(id)
                .orElseThrow(RuntimeException::new);
        userEntity.setName(user.getName());
        userEntity.setBirthday(user.getBirthday());
        userEntity.setEmail(user.getEmail());
        userEntity.setPassword(user.getPassword());
        userEntity.setUsername(user.getUsername());

        User updatedUser = userRepository.save(userEntity);

        return Mapper.toDTO(updatedUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void addFavoriteMovie(Long userId, MovieRequestDTO movieDTO) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado"));


        Movie movieEntity = movieRepository.findByExternalId(movieDTO.getExternalId())
                .orElseGet(() -> {
                    Movie newMovie = Mapper.toEntity(movieDTO);
                    return movieRepository.save(newMovie);
                });


        user.addFavoriteMovie(movieEntity);

    }

    @Override
    @Transactional
    public void deleteFavoriteMovie(Long userId, String movieExternalID){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado"));

        Movie movie = movieRepository.findByExternalId(movieExternalID)
                .orElseThrow(() -> new EntityNotFoundException("Película no encontrada"));

        user.deleteFavoriteMovie(movie);

    }
}
