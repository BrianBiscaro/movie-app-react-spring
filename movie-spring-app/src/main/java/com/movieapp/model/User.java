package com.movieapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String name;
    private String email;
    private LocalDate birthday;
    private String password;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Movie> movies = new HashSet<>();
}
