package com.demo.mongodb.repository;

import com.demo.mongodb.entity.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepository extends MongoRepository<Movie,String> {
    Movie findMovieById(String movieId);
}
