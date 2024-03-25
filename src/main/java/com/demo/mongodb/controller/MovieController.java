package com.demo.mongodb.controller;

import com.demo.mongodb.entity.Movie;
import com.demo.mongodb.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    //POST - Add a movie
    @PostMapping("/create")
    public Movie addMovie(@RequestBody Movie movie){
        return movieRepository.save(movie);
    }

    //GET - Get all movies & Get movie by ID
    @GetMapping("/")
    public List<Movie> getAllMovie(){
        return movieRepository.findAll();
    }

    @GetMapping("/{movieId}")
    public Movie getByIdMovie(@PathVariable String movieId){
        return movieRepository.findMovieById(movieId);
    }

    //PUT - Update a movie
    @PutMapping("/update/{movieId}")
    public Movie updateMovie(@PathVariable String movieId, @RequestBody Movie movie){
        return movieRepository.save(movie);
    }

    //DELETE - Delete a movie
    @DeleteMapping("/delete/{movieId}")
    public ResponseEntity<String> deleteMovie(@PathVariable String movieId) {
        try {
            movieRepository.deleteById(movieId);
            return ResponseEntity.ok("Movie deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete movie");
        }
    }

}
