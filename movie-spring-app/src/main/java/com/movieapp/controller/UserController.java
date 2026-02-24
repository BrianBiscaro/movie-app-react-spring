package com.movieapp.controller;

import com.movieapp.dto.MovieRequestDTO;
import com.movieapp.dto.UserRequestDTO;
import com.movieapp.dto.UserResponseDTO;
import com.movieapp.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final IUserService userService;

    @GetMapping
    public ResponseEntity<Page<UserResponseDTO>> getUsers(Pageable pageable){
        return ResponseEntity.ok(userService.getUsers(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUser(@PathVariable Long id){
        return ResponseEntity.ok(userService.getUser(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable Long id, @RequestBody UserRequestDTO userDTO){

        UserResponseDTO updatedUser = userService.updateUser(id, userDTO);

        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){

        userService.deleteUser(id);

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

    @PostMapping("/{id}/favorites")
    public ResponseEntity<Void> deleteFavoriteMovie(
            @PathVariable Long id,
            @RequestBody String movieExternalID
    ){
        userService.deleteFavoriteMovie(id, movieExternalID);

        return ResponseEntity.noContent().build();
    }
}
