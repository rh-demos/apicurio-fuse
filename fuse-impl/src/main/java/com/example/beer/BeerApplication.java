package com.example.beer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.beer.service.BeerService;

/**
 * Created by martins_rh on 05/04/2019.
 */

@SpringBootApplication
public class BeerApplication {
    public static void main(String[] args){
        SpringApplication.run(BeerApplication.class, args);
    }
    @Bean
    BeerService beerService() {
    	return new BeerService();
    }
}
