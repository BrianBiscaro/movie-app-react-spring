package com.movieapp.service;

import com.movieapp.dto.MovieRequestDTO;
import com.movieapp.dto.MovieResponseDTO;
import com.movieapp.mapper.Mapper;
import com.movieapp.model.Movie;
import com.movieapp.repository.MovieRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@RequiredArgsConstructor
public class MovieService implements IMovieService {

    private final MovieRepository movieRepository;

    @Override
    public Page<MovieResponseDTO> getMovies(Pageable pageable){
        return movieRepository.findAll(pageable)
                .map(Mapper::toDTO);
    }

    @Override
    public MovieResponseDTO getMovie(Long id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(RuntimeException::new);

        return Mapper.toDTO(movie);

    }

    @Override
    public MovieResponseDTO saveMovie(MovieRequestDTO movie) {

        Movie newMovie = Mapper.toEntity(movie);

        Movie savedMovie= movieRepository.save(newMovie);

        return Mapper.toDTO(savedMovie);
    }


    @Override
    @Transactional
    public MovieResponseDTO updateMovie(Long id, MovieRequestDTO movieDTO) {

        Movie movieEntity = movieRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Movie not found with id: " + id));

        movieEntity.setExternalId(movieDTO.getExternalId());
        movieEntity.setTitle(movieDTO.getTitle());
        movieEntity.setPosterPath(movieDTO.getPosterPath());
        movieEntity.setReleaseDate(movieDTO.getReleaseDate());

        movieRepository.save(movieEntity);

        return Mapper.toDTO(movieEntity);
    }

    @Override
    public void deleteMovie(Long id) {
         movieRepository.deleteById(id);
    }

}
