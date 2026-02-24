package com.movieapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="external_id", unique = true, nullable = false)
    private String externalId;

    @Column(nullable = false)
    private String title;
    private LocalDate releaseDate;
    private String posterPath;
    @ManyToMany(mappedBy = "favoriteMovies")
    @JsonIgnore
    private Set<User> usersThatFavorited = new HashSet<>();



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie movie)) return false;
        return Objects.equals(externalId, movie.externalId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(externalId);
    }
    
}
