package com.demo.mongodb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "movies") // Specify collection name using the value attribute
public class Movie {
    @Id
    private String id;
    private String name;
    private String category;
    private String rating;
}
