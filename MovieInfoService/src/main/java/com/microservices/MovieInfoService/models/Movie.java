package com.microservices.MovieInfoService.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Movie {

    private String movie_name;
    private String movie_description;

}
