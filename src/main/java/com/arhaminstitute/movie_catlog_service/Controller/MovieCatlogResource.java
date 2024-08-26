package com.arhaminstitute.movie_catlog_service.Controller;

import com.arhaminstitute.movie_catlog_service.models.CatlogItem;
import com.arhaminstitute.movie_catlog_service.models.Movie;
import com.arhaminstitute.movie_catlog_service.models.MovieRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catlog")
public class MovieCatlogResource {

    @Autowired
    private RestTemplate restTemplate ;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @RequestMapping("/{userId}")    //    /catlog/vimal
    public List<CatlogItem> getCatlogItem(@PathVariable("userId") String  userId){

        // get All Ratings of Movies by userId
        List<MovieRating> ratings=Arrays.asList(
                new MovieRating("1",4),
                new MovieRating("2",5)
        );

        // get Movie Info by Movie ID
        //  1.RestTemplate  : Synchronized
        //  2. WebClient  :   Synchronized and asynchronized
        // RestTemplate restTemplate=new RestTemplate();

         //WebClient.Builder webClientBuilder = WebClient.builder();




        // put it all together in a response.
       return  ratings.stream().map(movieRating -> {
           // using RestTemplate
           //Movie movie=restTemplate.getForObject("http://localhost:8082/movies/"+movieRating.getMovieId(), Movie.class);

           // using WebClient
           Movie movie=webClientBuilder.build()
                   .get()
                   .uri("http://localhost:8082/movies/"+movieRating.getMovieId())
                   .retrieve()
                   .bodyToMono(Movie.class)
                   .block();


           return   new CatlogItem(movieRating.getMovieId(),movie.getMovieName(),movieRating.getRating());
        }).collect(Collectors.toList());


//         return Collections.singletonList(
//                 new CatlogItem("1","ABC",5)
//
//         );

    }


}
