package com.movieapp.controller;

import com.movieapp.dto.MovieRequestDTO;
import com.movieapp.dto.UserRequestDTO;
import com.movieapp.dto.UserResponseDTO;
import com.movieapp.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final IUserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getUsers(){
        return ResponseEntity.ok(userService.get());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUser(@PathVariable Long id){
        return ResponseEntity.ok(userService.get(id));
    }

    @PostMapping("/{id}")
    ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO userDTO){

        UserResponseDTO createdUser = userService.save(userDTO);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdUser.getId())
                .toUri();

        return ResponseEntity.created(location).body(createdUser);
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> newUser(@RequestBody UserRequestDTO user){

        UserResponseDTO createdUser = userService.save(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable Long id, @RequestBody UserRequestDTO userDTO){

        UserResponseDTO updatedUser = userService.update(id, userDTO);

        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){

        userService.delete(id);

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/favorites")
    public ResponseEntity<String> addFavoriteMovie(
            @PathVariable Long id,
            @RequestBody MovieRequestDTO movieDto) {

        userService.addFavoriteMovie(id, movieDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Película agregada a favoritos exitosamente");
    }
}
