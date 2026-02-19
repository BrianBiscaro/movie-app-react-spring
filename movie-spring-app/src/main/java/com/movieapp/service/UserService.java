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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final UserRepository userRepository;
    private final MovieRepository movieRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<UserResponseDTO> get() {
        return userRepository.findAll()
                .stream()
                .map(Mapper::toDTO)
                .toList();
    }

    @Override
    public UserResponseDTO get(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(RuntimeException::new);

        return Mapper.toDTO(user);
    }

    @Override
    public UserResponseDTO save(UserRequestDTO user) {

        User newUser = Mapper.toEntity(user);

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        User savedUser = userRepository.save(newUser);

        return Mapper.toDTO(savedUser);
    }

    @Override
    @Transactional
    public UserResponseDTO update(Long id, UserRequestDTO user) {

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
    public void delete(Long id) {
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


        userRepository.save(user);
    }
}
