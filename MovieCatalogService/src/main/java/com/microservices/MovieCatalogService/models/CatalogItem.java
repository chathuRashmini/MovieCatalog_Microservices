package com.microservices.MovieCatalogService.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CatalogItem {

    private String movie_name;
    private String movie_description;
    private Integer movie_rating;

}
