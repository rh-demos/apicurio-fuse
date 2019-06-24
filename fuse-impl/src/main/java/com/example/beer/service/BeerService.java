package com.example.beer.service;

import com.example.beer.dto.Beer;
import java.util.List;
import java.util.LinkedList;
import java.math.BigDecimal;

public class BeerService {

    private LinkedList<Beer> mBeerList;

    public BeerService() {
        mBeerList = new LinkedList<Beer>();
        Beer beer = new Beer();
        beer.setCountry("Denmark");
        beer.setName("Carlsberg");
        beer.setRating(new BigDecimal(5));
        beer.setStatus("available");
        beer.setType("pilsner");
        mBeerList.add(beer);
        
        beer = new Beer();
        beer.setCountry("Germany");
        beer.setName("Sneider Weisse 7");
        beer.setRating(new BigDecimal(6));
        beer.setStatus("available");
        beer.setType("Weissbeer");
        mBeerList.add(beer);
    }

    public Beer getBeerByName(String name) {
        for(Beer beer: mBeerList) {
            if(name.equals(beer.getName())) {
                return beer;
            }
        }
        return null;
    }
    public List<Beer> getBeerByStatus(String status) {
    	List<Beer> filteredBeerList = (List<Beer>) mBeerList.clone();
    	filteredBeerList.removeIf(b -> status.equals(b.getStatus()));
        return filteredBeerList;
    }
    public List<Beer> getAllBeers() {
        return mBeerList;
    }
}
