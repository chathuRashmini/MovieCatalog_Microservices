package com.microservices.RatingsDataService.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UserRating {

    private List<Rating> userRating;
}
