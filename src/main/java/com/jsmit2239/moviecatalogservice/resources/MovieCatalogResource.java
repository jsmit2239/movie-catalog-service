package com.jsmit2239.moviecatalogservice.resources;

import com.jsmit2239.moviecatalogservice.models.CatalogItem;
import com.jsmit2239.moviecatalogservice.models.Movie;
import com.jsmit2239.moviecatalogservice.models.Rating;
import com.jsmit2239.moviecatalogservice.models.UserRatings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){

        //intialize the return object
        List<CatalogItem> catalogItems = new ArrayList<>();

        //get all rated movieId's and ratings by a particular user
        UserRatings userRatings = restTemplate.getForObject("http://localhost:8083/ratingsdata/users/" + userId, UserRatings.class);


        //get movie descriptions from movie-info-service
        for (Rating rating : userRatings.getRatings()){
            Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);
            catalogItems.add(new CatalogItem(movie.getName(), "Test", rating.getRating()));
        }

        //return catalog items
        return catalogItems;
    }
}
